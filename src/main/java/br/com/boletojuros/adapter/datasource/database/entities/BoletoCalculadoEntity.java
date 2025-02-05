package br.com.boletojuros.adapter.datasource.database.entities;

import br.com.boletojuros.core.domain.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "boleto_calculado")
@Getter
@Setter
public class BoletoCalculadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column
    private BigDecimal valorOriginal;

    @Column
    private BigDecimal valorCorrigido;

    @Column
    private LocalDate dataVencimento;

    @Column
    private LocalDate dataPagamento;

    @Column
    private BigDecimal juros;

    @Column
    private TipoBoleto tipo;

}