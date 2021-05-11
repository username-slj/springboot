package com.example.springboot.springboot.springbootmodel;

import com.example.springboot.springboot.SpringbootApplication;
import com.example.springboot.springboot.drools.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.StringJoiner;

/**
 * https://blog.csdn.net/tanglei6636/article/details/94845270?spm=1001.2014.3001.5502
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class DroolsTest {


    @Test
    public void test01(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //TODO 目前无法通过newKieSession动态指定drl文件，可以使用其他方式路径写死
        KieSession kieSession = kieContainer.newKieSession("ksession-person1");
        Person person = new Person();
        person.setAge(1);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }


    @Test
    public void test02() throws Exception{
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("package rules.rule2;");
        stringJoiner.add("import com.example.springboot.springboot.drools.entity.Person;");
        stringJoiner.add("dialect  \"mvel\"");
        stringJoiner.add("rule \"age2\"");
        stringJoiner.add("when");
        stringJoiner.add("$person : Person(age > 10 , age <= 20)");
        stringJoiner.add("then");
        stringJoiner.add("System.out.println(\"这个人的年龄属于11-20岁\");");
        stringJoiner.add("end");

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(stringJoiner.toString(), ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
        Person person = new Person();
        person.setAge(12);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
