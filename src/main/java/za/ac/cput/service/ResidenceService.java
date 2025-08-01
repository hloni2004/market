package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Residence;
import za.ac.cput.repository.ResidenceRepository;

import java.util.List;
@Service
public class ResidenceService implements IResidenceService{

    private final ResidenceRepository residenceRepository;

    @Autowired
    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }


    @Override
    public Residence create(Residence residence) {
      return residenceRepository.save(residence);
    }

    @Override
    public Residence read(Long id) {
        return residenceRepository.findById(id).orElse(null);

    }

    @Override
    public Residence update(Residence residence) {
        return residenceRepository.save(residence);
    }
    @Override
    public List<Residence> getAll() {
       return residenceRepository.findAll();
    }
}
