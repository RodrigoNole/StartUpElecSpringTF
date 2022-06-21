package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;
import pe.edu.upc.StartUp.Elec.Model.Repository.TypeCardRepository;
import pe.edu.upc.StartUp.Elec.Business.Crud.TypeCardService;

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

	@Override
	public JpaRepository<TypeCard, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.typeCardRepository;
	}
}
