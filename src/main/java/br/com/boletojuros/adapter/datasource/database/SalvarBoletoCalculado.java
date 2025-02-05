package br.com.boletojuros.adapter.datasource.database;

import br.com.boletojuros.adapter.datasource.database.entities.BoletoCalculadoEntity;
import br.com.boletojuros.adapter.datasource.database.repositories.BoletoCalculadoRepository;
import br.com.boletojuros.adapter.datasource.mapper.BoletoCalculadoMapper;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.port.out.SalvarCalculoBoletoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {

    private final BoletoCalculadoRepository boletoCalculadoRepository;
    private final BoletoCalculadoMapper boletoCalculadoMapper;

    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        BoletoCalculadoEntity entity = boletoCalculadoMapper.toEntity(boletoCalculado);
        boletoCalculadoRepository.save(entity);
    }
}
