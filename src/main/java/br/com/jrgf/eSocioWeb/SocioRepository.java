package br.com.jrgf.eSocioWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.jrgf.eSocioWeb.models.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer>{

}
