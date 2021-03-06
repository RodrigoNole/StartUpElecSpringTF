package pe.edu.upc.StartUp.Elec.Business.Crud;


import pe.edu.upc.StartUp.Elec.Model.Entity.Home;

import java.util.List;

public interface HomeService extends CrudService<Home, Integer>{

    public List<Home> getAll();

    public Home save (Home home);

    public Home update (Home home);

    public void deleteById (Integer id);
}
