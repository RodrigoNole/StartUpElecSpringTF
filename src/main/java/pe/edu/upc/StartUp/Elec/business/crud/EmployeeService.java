package pe.edu.upc.StartUp.Elec.business.crud;



import java.util.List;

import pe.edu.upc.StartUp.Elec.model.entity.Employee;




public interface EmployeeService extends CrudService<Employee, Integer>{
	
	public List<Employee> findByName(String name) throws Exception;
}
