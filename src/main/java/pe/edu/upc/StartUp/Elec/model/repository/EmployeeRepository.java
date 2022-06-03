package pe.edu.upc.StartUp.Elec.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDni (Integer dni);
}
