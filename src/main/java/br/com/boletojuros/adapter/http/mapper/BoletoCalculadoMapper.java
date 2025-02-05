package br.com.boletojuros.adapter.http.mapper;

import br.com.boletojuros.adapter.http.dtos.CalculoBoletoResponse;
import br.com.boletojuros.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {
    CalculoBoletoResponse toDto(BoletoCalculado boletoCalculado);
}
