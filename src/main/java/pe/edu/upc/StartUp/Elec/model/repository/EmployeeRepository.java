package pe.edu.upc.StartUp.Elec.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.StartUp.Elec.model.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByName(String name) throws Exception;

}
