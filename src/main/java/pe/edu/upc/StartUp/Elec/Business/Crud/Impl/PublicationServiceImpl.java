package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.Publication;
import pe.edu.upc.StartUp.Elec.Model.Repository.PublicationRepository;
import pe.edu.upc.StartUp.Elec.Business.Crud.PublicationService;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;


    @Override
    public List<Publication> getAll() {

        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> findByName(String name) {

        return publicationRepository.findByName(name);
    }

    @Override
    public Publication save(Publication publication) {

        return publicationRepository.save(publication);
    }

    @Override
    public Publication update(Publication publication) {

        return publicationRepository.save(publication);
    }

    @Override
    public void deleteById(Integer id) {

        publicationRepository.deleteById(id);
    }

}
