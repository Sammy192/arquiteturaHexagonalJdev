package br.com.boletojuros.adapter.http;

import br.com.boletojuros.adapter.http.dtos.CalculoBoletoRequest;
import br.com.boletojuros.adapter.http.dtos.CalculoBoletoResponse;
import br.com.boletojuros.adapter.http.mapper.BoletoCalculadoMapper;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/boleto")
@AllArgsConstructor
public class CalculoBoletoController {

    private final CalculoBoletoPort calculoBoletoPort;
    private final BoletoCalculadoMapper boletoCalculoMapper;

    @PostMapping("/calculo")
    @Operation(summary = "Calcular juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto) {
        BoletoCalculado boletoCalculado = calculoBoletoPort.calcularJurosParaBoleto(boleto.getCodigo(), boleto.getDataPagamento());
        return ResponseEntity.ok(boletoCalculoMapper.toDto(boletoCalculado));
    }
}
