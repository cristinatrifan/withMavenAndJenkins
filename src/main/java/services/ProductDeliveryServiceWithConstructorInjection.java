package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

@Service
public class ProductDeliveryServiceWithConstructorInjection {
    private final ProductRepository productRepository;

    //the same thing by using @AllArgsConstructor
    //forces you to have final instance;
    //you can visually see when the dependencies become too many
    //you can control how the instance of this class is created, because you write the constructor
    @Autowired
    public ProductDeliveryServiceWithConstructorInjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
