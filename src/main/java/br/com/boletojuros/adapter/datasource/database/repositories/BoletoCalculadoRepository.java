package br.com.boletojuros.adapter.datasource.database.repositories;

import br.com.boletojuros.adapter.datasource.database.entities.BoletoCalculadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoCalculadoRepository extends JpaRepository<BoletoCalculadoEntity, Long> {
}