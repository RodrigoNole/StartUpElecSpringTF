package pe.edu.upc.StartUp.Elec.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;
import pe.edu.upc.StartUp.Elec.Model.Repository.BenefitRepository;
import pe.edu.upc.StartUp.Elec.Service.BenefitService;

import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    private BenefitRepository benefitRepository;

    @Override
    public List<Benefit> getAll() {
        return benefitRepository.findAll();
    }

    @Override
    public List<Benefit> findByName(String name) {
        return benefitRepository.findByName(name);
    }

    @Override
    public Benefit save(Benefit benefit) {

        return benefitRepository.save(benefit);
    }

    @Override
    public Benefit update(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public void deleteById(Integer id) {
        benefitRepository.deleteById(id);
    }
}
