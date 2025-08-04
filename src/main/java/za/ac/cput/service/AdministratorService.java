package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Administrator;
import za.ac.cput.repository.AdministratorRepository;

import java.util.List;
@Service
public class AdministratorService implements IAdministratorService {




    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }




    @Override
    public Administrator create(Administrator administrator) {
       return this.administratorRepository.save(administrator);
    }

    @Override
    public Administrator read(Long id) {
        return  administratorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrator update(Administrator administrator) {
        return administratorRepository.save(administrator);
    }
    @Override
    public List<Administrator> getAll() {
      return administratorRepository.findAll();
    }
}
