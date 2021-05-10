package com.example.springboot.springboot.springbootmodel;

import com.example.springboot.springboot.SpringbootApplication;
import com.example.springboot.springboot.drools.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class DroolsTest {

    @Test
    public void test01(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("person");
        Person person = new Person();
        person.setAge(1);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
