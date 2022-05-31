package pe.edu.upc.StartUp.Elec.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;

@Repository
public interface TypeCardRepository extends JpaRepository<TypeCard, Integer> {

}
