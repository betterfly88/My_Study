package com.spring;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void applicationContext_Bean등록(){
        // IoC 컨테이너 생성. 생성과 동시에 컨테이너 역할
        StaticApplicationContext sac = new StaticApplicationContext();

        // Hello 클래스를 'HelloBean' 이름의 싱글톤 빈으로 컨테이너에 등록
        sac.registerSingleton("HelloBean", Hello.class);

        // IoC 컨테이너에 등록한 빈을 생성했는지 확인
        Hello hello1 = sac.getBean("HelloBean", Hello.class);
        assertTrue(hello1 != null);


        /**
         * BeanDefinition_Bean_등록
         */
        // 빈 메타정보를 담은 오브젝트 생성. Bean Class 는 <Hello.class>
        // xml에서 <bean class ="com.spring.Hello"/> 에 해당하는 메타 정보
        BeanDefinition def = new RootBeanDefinition(Hello.class);


        // Bean의 name에 등러갈 값 지정
        // <property name="name" value="betterFLY"/> 에 해당하는 메타 정보
        def.getPropertyValues().addPropertyValue("name", "betterFLY");

        // 앞에서 생성한 빈 메타정보를 'HelloBean2' 이름을 가진 빈으로 등록
        // <bean id="HelloBean2" />
        sac.registerBeanDefinition("HelloBean2", def);

        Hello hello2 = sac.getBean("HelloBean2", Hello.class);
        assertThat(hello2.sayHello(), is("Hello betterFLY"));

        // 처음 등록한 빈과 두번째 등록한 빈을 비교
        assertTrue(hello1 != hello2);
//        assertThat(hello1, is(not(hello2)));

        assertThat(sac.getBeanFactory().getBeanDefinitionCount(), is(2));
    }

    @Test
    public void registerBeanWithDependency(){
        StaticApplicationContext ac = new StaticApplicationContext();

        // StringPrinter Class 를 <printer> 라는 이름으로 빈 등록
        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "betterFLY");

        // bean id = 'printer' 의 빈에 reference를 property로 등록해버림
        helloDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));

        ac.registerBeanDefinition("hello", helloDef);

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        // Hello Class의 print() 메소드는 DI된 Printer 타입의 오브젝트를 참조하여 메시지가 출력됨
        // 이 결과를 String으로 저장해두는 printer 빈을 통해 확인
        assertThat(ac.getBean("printer").toString(), is("Hello betterFLY"));
    }

    @Test
    public void DI_Test(){
        StringPrinter printer = new StringPrinter();
        HelloDependency h = new HelloDependency(printer);
        h.printMessage("aa");
    }
}