package br.com.boletojuros.core.domain;

import br.com.boletojuros.core.domain.enums.TipoBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BoletoCalculado {

    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valorCorrigido;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal juros;
    private TipoBoleto tipo;
}
