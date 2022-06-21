package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Business.Crud.EmployeeService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;
import pe.edu.upc.StartUp.Elec.Model.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {

        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByDni(Integer dni) {
        return employeeRepository.findByDni(dni);
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public JpaRepository<Employee, Integer> getJpaRepository() {
        return this.employeeRepository;
    }

    @Override
    public Employee update(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {

        employeeRepository.deleteById(id);
    }

}
