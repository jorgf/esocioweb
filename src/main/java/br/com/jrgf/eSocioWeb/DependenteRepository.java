package br.com.jrgf.eSocioWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.jrgf.eSocioWeb.models.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer>{

}
