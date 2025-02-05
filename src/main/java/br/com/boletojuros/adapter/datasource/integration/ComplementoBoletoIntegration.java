package br.com.boletojuros.adapter.datasource.integration;

import br.com.boletojuros.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros.adapter.datasource.integration.dtos.BoletoDTO;
import br.com.boletojuros.adapter.datasource.mapper.BoletoMapper;
import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient complementoBoletoClient;
    private final BoletoMapper mapper;

    @Override
    public Boleto executar(String codigo) {
        BoletoDTO boletoDTO = complementoBoletoClient.getBoleto(codigo);
        return mapper.toBoletoDomain(boletoDTO);
    }
}
