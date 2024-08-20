package repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//still a stereotype annotation, but specifies the purpose of the class;
//can also use Component annotation
@Repository
public class ProductRepository {
    private List<String> beerList = new ArrayList<>();

    public void add() {
        beerList.add("beer");
        System.out.println("A new product was added");
    }

    public List<String> getBeers() {
        return beerList;
    }
}
