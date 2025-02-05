package br.com.boletojuros.adapter.datasource.integration.dtos;

import br.com.boletojuros.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class BoletoDTO {
    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;
}
