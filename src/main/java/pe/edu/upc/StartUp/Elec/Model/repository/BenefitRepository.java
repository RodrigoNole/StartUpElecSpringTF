package pe.edu.upc.StartUp.Elec.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;

import java.util.List;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
    List<Benefit> findByName (String name);

}
