package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//needed for MyBean2, which is a Component
//with ComponentScan, the object will not be instantiated by default, so @PostConstruct needs to be used
@ComponentScan(basePackages = {"beans", "repositories", "services"})
public class ProjectConfig {

    //this annotation places the return value of the method in the context
    //only one method that returns type MyBean can exist, if there are no there will be a NoUniqueBeanDefinitionException
    @Bean
    @Primary //solves the NoUniqueBeanDefinitionException problem
    // if the object is not instantiated, it will instantiate the object by default and return the toString() value
    public MyBean myBean1() {
        var myBean = new MyBean();
        myBean.setText("Hello Spring 1!");
        return myBean;
    }

    @Bean
    public MyBean myBean2() {
        var myBean = new MyBean();
        myBean.setText("Hello Spring 2!");
        return myBean;
    }

    @Bean(name = "beanName3")
    public MyBean myBean3() {
        var myBean = new MyBean();
        myBean.setText("Hello Spring 3!");
        return myBean;
    }
}
