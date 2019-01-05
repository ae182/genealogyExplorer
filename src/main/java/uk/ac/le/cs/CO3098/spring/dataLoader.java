package uk.ac.le.cs.CO3098.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;


@Component
public class dataLoader implements ApplicationRunner  {

    @Autowired
    private PersonRepository repod;
    
    
    //http://localhost:8070/GE/person/add?key=3&name=loop&dob=14830626&m=1&f=2&g=male
    @Override
    public void run(ApplicationArguments args) throws Exception {

        repod.save(new APerson("1", "bart", "14830626", "0", "0", "male"));
        repod.save(new APerson("2", "lisa", "14830626", "0", "0", "male"));
        repod.save(new APerson("4", "homer", "14830626", "1", "2", "male"));
        repod.save(new APerson("3", "ned", "14830626", "1", "2", "male"));
        repod.save(new APerson("5", "Apu", "14830626", "1", "2", "male"));
        repod.save(new APerson("6", "Nelson", "14830626", "1", "2", "male"));
        repod.save(new APerson("7", "Smithers", "14830626", "5", "6", "male"));
    }
    
}