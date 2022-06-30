package pe.edu.upc.StartUp.Elec.Business.Crud;


import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee, Integer>{

    public List<Employee> getAll();
    
    public List<Employee> findByDni(Integer dni);

    public Employee save (Employee employee);

    public Employee update (Employee employee);

    public void deleteById (Integer id);

}
