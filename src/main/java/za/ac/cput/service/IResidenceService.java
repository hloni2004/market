package za.ac.cput.service;

import za.ac.cput.domain.Residence;

import java.util.List;

public interface IResidenceService extends IService<Residence, Long> {
    List<Residence> getAll();
}
