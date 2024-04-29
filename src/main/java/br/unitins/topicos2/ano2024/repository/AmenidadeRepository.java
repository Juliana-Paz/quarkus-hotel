package br.unitins.topicos2.ano2024.repository;

import br.unitins.topicos2.ano2024.model.Amenidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AmenidadeRepository implements PanacheRepository<Amenidade> {

    public List<Amenidade> findByIds(List<Long> ids) {
        return list("id in ?1", ids);
    }
}
