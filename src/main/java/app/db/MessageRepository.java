package app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mega- on 30.03.2017.
 */
@Transactional
public interface MessageRepository extends CrudRepository<Message, Long> {
    public Message findByTitle(String title);
}
