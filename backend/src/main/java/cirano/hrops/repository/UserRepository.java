package cirano.hrops.repository;

import cirano.hrops.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByName(String name);
    public List<User> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
