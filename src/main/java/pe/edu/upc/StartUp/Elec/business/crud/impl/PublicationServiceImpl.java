package pe.edu.upc.StartUp.Elec.business.crud.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.StartUp.Elec.business.crud.PublicationService;
import pe.edu.upc.StartUp.Elec.model.entity.Publication;
import pe.edu.upc.StartUp.Elec.model.repository.PublicationRepository;





@Service
public class PublicationServiceImpl implements PublicationService{

	@Autowired
	private PublicationRepository publicationRepository;
	
	@Override
	public JpaRepository<Publication, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.publicationRepository;
	}
 
	@Override
	public List<Publication> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return this.publicationRepository.findByName(name);
	}
}
