package pe.edu.upc.StartUp.Elec.Business.Crud;

import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;

import java.util.List;

public interface BenefitService {


    public List<Benefit> getAll();
    public List<Benefit> findByName(String name);

    public Benefit save (Benefit benefit);

    public Benefit update (Benefit benefit);

    public void deleteById (Integer id);



}
