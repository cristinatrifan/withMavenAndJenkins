package config;

import beans2.Cat;
import beans2.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"beans2", "repositories", "services", "aspects"})
@EnableAspectJAutoProxy // it enables aspects
public class ProjectConfig2 {

    @Bean
    @Qualifier("cat1")
    public Cat cat() {
        var cat = new Cat();
        cat.setName("Tom");
        return cat;
    }

    @Bean
    public Owner owner() {
        var owner = new Owner();
        owner.setCat(cat()); //the Cat bean is used
        return owner;
    }

/*
    @Bean
    public Owner owner2(Cat cat) {
        var owner = new Owner();
        owner.setCat(cat); //the Cat bean is used
        return owner;
    }

 */


}
