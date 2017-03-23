package app.db;

/**
 * Created by nicolas on 16.03.17.
 */

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
