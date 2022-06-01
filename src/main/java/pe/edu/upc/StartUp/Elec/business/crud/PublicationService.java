package pe.edu.upc.StartUp.Elec.business.crud;



import java.util.List;

import pe.edu.upc.StartUp.Elec.model.entity.Publication;



public interface PublicationService extends CrudService<Publication, Integer>{

	public List<Publication> findByName(String name) throws Exception ;

}
