package beans;

/*
Beans are instances of a class that will be placed in the Spring context
They need to be configured in Configuration class
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyBean {
    private String text;
}
