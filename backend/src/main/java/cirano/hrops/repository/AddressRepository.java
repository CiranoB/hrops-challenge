package cirano.hrops.repository;

import cirano.hrops.model.Address;
import cirano.hrops.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findAllByCityContainingIgnoreCase (String city);

    public Optional<Address> findByUser(String user);

}