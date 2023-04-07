package cirano.hrops.service;

import cirano.hrops.model.Address;
import cirano.hrops.model.User;
import cirano.hrops.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Optional<Address> registerAddress (Address address){
        return Optional.of(addressRepository.save(address));
    }

}
