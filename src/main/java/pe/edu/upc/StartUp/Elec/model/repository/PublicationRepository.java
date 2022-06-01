package pe.edu.upc.StartUp.Elec.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.StartUp.Elec.model.entity.Publication;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>{

	List<Publication> findByName(String name) throws Exception;
}
