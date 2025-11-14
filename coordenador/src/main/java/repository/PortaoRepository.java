package repository;

import model.Portao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaoRepository extends JpaRepository<Portao, Long> {
    
}