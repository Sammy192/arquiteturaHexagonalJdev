package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exceptions.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import br.com.boletojuros.core.port.out.SalvarCalculoBoletoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

    @Override
    public BoletoCalculado calcularJurosParaBoleto(String codigo, LocalDate dataPagamento) {
        var boleto = complementoBoletoPort.obterBoletoCompleto(codigo);
        validar(boleto);

        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(new BigDecimal(100));
        var juros = valorJurosDia.multiply(new BigDecimal(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);

        var boletoCalculado = BoletoCalculado.builder()
                .codigo(boleto.getCodigo())
                .dataPagamento(dataPagamento)
                .juros(juros)
                .dataVencimento(boleto.getDataVencimento())
                .valorOriginal(boleto.getValor())
                .valorCorrigido(boleto.getValor().add(juros))
                .tipo(boleto.getTipo())
                .build();

        salvarCalculoBoletoPort.persistirBoleto(boletoCalculado);

        return boletoCalculado;
    }

    private void validar(Boleto boleto) {
        if (Objects.isNull(boleto)) {
            throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
        }
        if (!boleto.getTipo().equals(TipoBoleto.XPTO)) {
            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }
        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);
        }
    }

    private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }
}
