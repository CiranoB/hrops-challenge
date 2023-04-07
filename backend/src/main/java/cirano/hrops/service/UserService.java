package cirano.hrops.service;

import cirano.hrops.model.User;
import cirano.hrops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
