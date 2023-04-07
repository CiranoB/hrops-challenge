package cirano.hrops.repository;

import cirano.hrops.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findAllByCityContainingIgnoreCase (String city);
}