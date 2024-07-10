package org.example;

import beans.MyBean;
import beans.MyBeanTwo;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

//Spring context = holds a collection of instances known and managed by Spring
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        This class AnnotationConfigApplicationContext refers to the application context - it's actually an implementation
        of int ApplicationContext, which allows us to configure the context with annotations

        This class will use ProjectConfig to get the configuration details

        You can configure the context with XML files (classic way) or annotations
         */
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            //request bean by type
            var b1 = context.getBean(MyBean.class);

            //request bean by name
            var b2 = context.getBean("myBean2", MyBean.class);
            var b3 = context.getBean("beanName3", MyBean.class);

            //bean created with @Component
            var b4 = context.getBean(MyBeanTwo.class);

            //This will throw NoSuchBeanDefinitionException if it's not defined in Configuration class
            // and there's no such bean in the context
            System.out.println(b1.getText());
            System.out.println(b2.getText());
            System.out.println(b3.getText());
            System.out.println(b4.getText());

            ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
            service.addSomeProducts();
        }
    }
}