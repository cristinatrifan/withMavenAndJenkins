package beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Setter
//this is a stereotype annotation (like Controller, Service, Repository) - just the naming differs, basically they behave like Component
//Spring context does not search components by default, for this
//ComponentScan is needed in the Configuration class
//with Component you cannot create different instances of the class
@Component
public class MyBeanTwo {
    private String text;

    //method annotated with PostConstruct is called immediately after object instantiation
    //like this, you can initialize the object similar to how you create a method in Configuration class
    //only works within the Spring initialization, not when manually instantiating MyBeanTwo with new operator
    @PostConstruct
    private void init() {
        this.text = "PostConstruct";
    }
}
