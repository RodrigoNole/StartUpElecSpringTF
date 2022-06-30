package pe.edu.upc.StartUp.Elec.Business.Crud;


import pe.edu.upc.StartUp.Elec.Model.Entity.Publication;

import java.util.List;

public interface PublicationService extends CrudService<Publication, Integer>{

    public List<Publication> getAll();

    public List<Publication> findByName(String name);

    public Publication save (Publication publication);

    public Publication update (Publication publication);

    public void deleteById (Integer id);
}
