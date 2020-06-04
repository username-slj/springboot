package com.example.springboot.springboot;

import com.example.springboot.springboot.drools.entity.Person;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    /**
     * drools基于规则文件
     */
    @Test
    void contextLoads() {
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");
        Person person = new Person();

        person.setAge(12);
        person.setName("zhangsan");

        statefulKieSession.insert(person);
        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();
    }

    /**
     * drools基于动态加载
     */
    @Test
    void test2() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("import com.example.springboot.springboot.drools.entity.Person;");
        stringBuffer.append("dialect  \"mvel\"\n");
        stringBuffer.append("rule \"age\"\n");
        stringBuffer.append("when\n");
        stringBuffer.append("$person : Person(age <16 || age>50)\n");
        stringBuffer.append("then\n");
        stringBuffer.append("System.out.println(\"这个人的年龄不符合要求！（基于动态加载）\");\n");
        stringBuffer.append("end\n");

        KieHelper helper = new KieHelper();

        helper.addContent(stringBuffer.toString(), ResourceType.DRL);

        KieSession ksession = helper.build().newKieSession();

        Person person = new Person();

        person.setAge(10);
        person.setName("lisi");

        ksession.insert(person);
        ksession.fireAllRules();
        ksession.dispose();
    }

}
