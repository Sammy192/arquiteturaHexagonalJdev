package br.com.boletojuros.adapter.datasource.mapper;

import br.com.boletojuros.adapter.datasource.integration.dtos.BoletoDTO;
import br.com.boletojuros.core.domain.Boleto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    Boleto toBoletoDomain(BoletoDTO boletoDTO);
}
