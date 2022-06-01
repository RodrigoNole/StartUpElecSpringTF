package pe.edu.upc.StartUp.Elec.business.crud.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.StartUp.Elec.business.crud.EmployeeService;
import pe.edu.upc.StartUp.Elec.model.entity.Employee;
import pe.edu.upc.StartUp.Elec.model.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Override
	public JpaRepository<Employee, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.employeeRepository;
	}

	@Override
	public List<Employee> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return this.employeeRepository.findByName(name);
	}

}
