package pe.edu.upc.StartUp.Elec.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.StartUp.Elec.Model.Entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
