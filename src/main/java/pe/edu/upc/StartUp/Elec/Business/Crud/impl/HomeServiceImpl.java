package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.Home;
import pe.edu.upc.StartUp.Elec.Model.Repository.HomeRepository;
import pe.edu.upc.StartUp.Elec.Business.Crud.HomeService;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;


    @Override
    public List<Home> getAll() {
        return homeRepository.findAll();
    }

    @Override
    public Home save(Home home) {

        return homeRepository.save(home);
    }

    @Override
    public Home update(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public void deleteById(Integer id) {
        homeRepository.deleteById(id);
    }

    @Override
    public JpaRepository<Home, Integer> getJpaRepository() {
        // TODO Auto-generated method stub
        return this.homeRepository;
    }

}
