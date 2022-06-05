package pe.edu.upc.StartUp.Elec.Business.Crud;


import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;

import java.util.List;

public interface TypeCardService extends CrudService<TypeCard, Integer>{

    public List<TypeCard> getAll();

    public TypeCard save (TypeCard typeCard);

    public TypeCard update (TypeCard typeCard);

    public void deleteById (Integer id);
}
