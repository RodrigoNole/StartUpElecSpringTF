package pe.edu.upc.StartUp.Elec.Service;

import pe.edu.upc.StartUp.Elec.Model.Entity.Home;

import java.util.List;

public interface HomeService {

    public List<Home> getAll();

    public Home save (Home home);

    public Home update (Home home);

    public void deleteById (Integer id);
}
