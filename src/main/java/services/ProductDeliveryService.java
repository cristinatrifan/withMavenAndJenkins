package services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductDeliveryService {

    //without any annotation, this instance is null because it is not taken from the Spring context
    @Autowired
    private ProductRepository productRepository;

    //another way of injecting the instance in the class
    //final should be used wherever possible - keep vars immutable
    private final ProductRepository productRepository2;

    public void addSomeProducts() {
        productRepository.add(); //without Autowired, productRepository is null and .add() will throw exception
        productRepository.add();
    }
}
