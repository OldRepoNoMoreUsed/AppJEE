package app;


import app.models.Skill;
import app.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer implements CommandLineRunner{
    @Autowired
    SkillRepository skillRepository;

    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        Skill javascript = new Skill("Javascript", "Javascript skills");
        Skill cpp = new Skill("Cpp", "C++ Skills");
        Skill ruby = new Skill("ruby", "Ruby language skill");
        Skill emberjs = new Skill("emberjs", "Emberjs framework");
        Skill angularjs = new Skill("angularjs", "Angularjs framework");

        skillRepository.save(javascript);
        skillRepository.save(cpp);
        skillRepository.save(ruby);
        skillRepository.save(emberjs);
        skillRepository.save(angularjs);
    }
}
