package cirano.hrops.controller;

import cirano.hrops.model.Address;
import cirano.hrops.model.User;
import cirano.hrops.repository.AddressRepository;
import cirano.hrops.repository.UserRepository;
import cirano.hrops.service.AddressService;
import cirano.hrops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchById(@PathVariable Long id){
        return userRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getUserAddresses(@PathVariable Long id){
        return (ResponseEntity<Address>) userService.getUserAddress(userRepository.findByUserId(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser (@RequestBody User user){
        return userService.registerUser(user).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User user){
        return userService.updateUser(user)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
