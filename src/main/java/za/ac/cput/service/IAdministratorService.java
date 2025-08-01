package za.ac.cput.service;

import za.ac.cput.domain.Administrator;

import java.util.List;

public interface IAdministratorService extends IService<Administrator, Long> {
    List<Administrator> getAll();
}
