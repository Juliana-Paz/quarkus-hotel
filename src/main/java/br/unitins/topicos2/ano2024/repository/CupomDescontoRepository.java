package br.unitins.topicos2.ano2024.repository;

import br.unitins.topicos2.ano2024.model.CupomDesconto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomDescontoRepository implements PanacheRepository<CupomDesconto> {
}
