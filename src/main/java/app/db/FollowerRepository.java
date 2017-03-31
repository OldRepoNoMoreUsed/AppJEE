package app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mega- on 30.03.2017.
 */
@Transactional
public interface FollowerRepository extends CrudRepository<Follower, Long> {

}
