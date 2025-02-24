package br.com.boletojuros.adapter.datasource.database;

import br.com.boletojuros.adapter.datasource.database.entities.BoletoCalculadoEntity;
import br.com.boletojuros.adapter.datasource.database.repositories.BoletoCalculadoRepository;
import br.com.boletojuros.adapter.datasource.mapper.BoletoCalculoMapper;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.port.out.SalvarCalculoBoletoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {

    private final BoletoCalculadoRepository boletoCalculadoRepository;
    private final BoletoCalculoMapper boletoCalculoMapper;

    @Override
    public void persistirBoleto(BoletoCalculado boletoCalculado) {
        BoletoCalculadoEntity entity = boletoCalculoMapper.toEntity(boletoCalculado);
        boletoCalculadoRepository.save(entity);
    }
}
