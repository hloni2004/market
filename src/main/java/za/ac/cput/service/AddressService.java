package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
@Service
public class AddressService implements IAddressService{

    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return  addressRepository.save(address);
    }
    @Override
    public Address read(Long aLong) {
        return addressRepository.findById(aLong).orElse(null);

    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public boolean delete(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
       return addressRepository.findAll();
    }
}
