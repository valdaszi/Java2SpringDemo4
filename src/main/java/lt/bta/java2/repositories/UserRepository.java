package lt.bta.java2.repositories;

import lt.bta.java2.model.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

}
