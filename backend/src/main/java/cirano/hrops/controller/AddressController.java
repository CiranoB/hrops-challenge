package cirano.hrops.controller;

import cirano.hrops.model.Address;
import cirano.hrops.repository.AddressRepository;
import cirano.hrops.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

    @Autowired
    private AddressService AddressService;

    @Autowired
    private AddressRepository addressRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Address> searchById(@PathVariable Long id){
        return addressRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Address> createAddress (@RequestBody Address address){
        return AddressService.registerAddress(address).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
