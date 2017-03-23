package app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.db.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByEmail(String email);

}
