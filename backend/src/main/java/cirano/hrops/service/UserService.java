package cirano.hrops.service;

import cirano.hrops.model.Address;
import cirano.hrops.model.User;
import cirano.hrops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Optional<User> registerUser (User user){
        if (userRepository.findByName(user.getName()).isPresent())
            return Optional.empty();

        return Optional.of(userRepository.save(user));
    }

    public Optional<User> updateUser (User user){
        if(userRepository.findById(user.getUserId()).isPresent()){
            Optional<User> searchUser = userRepository.findByName(user.getName());

            if(((searchUser.isPresent())) && (searchUser.get().getUserId() != user.getUserId()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist!", null);

            return Optional.ofNullable(userRepository.save(user));
        }

        return Optional.empty();
    }

    public List<Address> getUserAddress (User user){
        if(userRepository.findById(user.getUserId()).isPresent()){
            List<Address> searchUserAddress = userRepository.findById(user.getUserId()).get().getAddresses();

            return searchUserAddress;
        }

        return null;
    }
}
