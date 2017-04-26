package app.services;

import app.models.Project;
import app.models.Skill;
import app.models.User;
import app.repositories.SkillRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public List<User> findByName(String name){
        return this.userRepo.findByName(name);
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) { return this.userRepo.save(user);}

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }

    @Override
    public boolean authenticate(String username, String password){
        // Provide a sample password check: username == password
        return Objects.equals(username, password);
    }

    @Override
    public boolean register(String username, String password, String email){
        User user = new User(1L, username,  email);
        user.setPasswordHash(password);
        create(user);
        System.out.println("C'est passe par la");
        return true;
    }

    @Override
    public void save(User user) {
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        System.out.println("C'est passe par la");
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Skill> findAllSkill(){
        return this.skillRepository.findAll();
    }

    public Skill findOneSkill(long id){
        return this.skillRepository.findOne(id);
    }

    public User findOneUser(long id){
        return this.userRepo.findOne(id);
    }

    @Override
    public List<Project> findListProject(Long id){
        return this.userRepo.getProjectList(id);
    }
}
