package pe.edu.upc.StartUp.Elec.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;
import pe.edu.upc.StartUp.Elec.Model.Repository.TypeCardRepository;
import pe.edu.upc.StartUp.Elec.Service.TypeCardService;

import java.util.List;

@Service
public class TypeCardServiceImpl implements TypeCardService {

    @Autowired
    private TypeCardRepository typeCardRepository;


    @Override
    public List<TypeCard> getAll() {
        return typeCardRepository.findAll();
    }

    @Override
    public TypeCard save(TypeCard typeCard) {

        return typeCardRepository.save(typeCard);
    }

    @Override
    public TypeCard update(TypeCard typeCard) {
        return typeCardRepository.save(typeCard);
    }

    @Override
    public void deleteById(Integer id) {
        typeCardRepository.deleteById(id);
    }
}
