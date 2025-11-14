package repository;

import model.Ar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArRepository extends JpaRepository<Ar, Long> {
    
}