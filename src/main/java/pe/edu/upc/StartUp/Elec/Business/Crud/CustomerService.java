package pe.edu.upc.StartUp.Elec.Business.Crud;

import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    public List<Customer> findByDni(Integer dni);
    public Customer save (Customer customer);

    public Customer update (Customer customer);

    public void deleteById (Integer id);

}
