package repositories;

import org.springframework.stereotype.Repository;

//still a stereotype annotation, but specifies the purpose of the class;
//can also use Component annotation
@Repository
public class ProductRepository {

    public void add() {
        System.out.println("A new product was added");
    }
}
