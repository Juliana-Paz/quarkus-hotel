package br.unitins.topicos2.ano2024.repository;

import br.unitins.topicos2.ano2024.model.Servico;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicoRepository implements PanacheRepository<Servico> {
}
