package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {

        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByDni(Integer dni) {
        return customerRepository.findByDni(dni);
    }

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {

        customerRepository.deleteById(id);
    }


}
