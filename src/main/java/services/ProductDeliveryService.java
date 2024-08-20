package services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductDeliveryService {

    //without any annotation, this instance is null because it is not taken from the Spring context
    @Autowired
    private ProductRepository productRepository;

    //another way of injecting the instance in the class
    //final should be used wherever possible - keep vars immutable
    private final ProductRepository productRepository2;

    @Transactional
            (noRollbackFor = RuntimeException.class,
            propagation = Propagation.REQUIRED) // this overwrites the default behaviour
    /*if explicit configuration class is used, @EnableTransactionManagement should also be added
   by default, the transaction is marked for roll back unchecked exceptions but not checked exceptions
   when they are propagated outside the method (meaning it's not caught inside the method)
   * */
    /*
    Propagation.REQUIRED is the default, it means the Transaction will propagate to any methods called inside this one
    Propagation.REQUIRES_NEW - you would add to a method b called inside another one a with transactional,
    when you want transaction a to be paused before going into b, and then b to create a new transaction to be commited before reaching a again,
    then transaction a is resumed
     */
    /*
    Propagation.MANDATORY/NEVER - the method must be called from another method that has a transaction associated,
    respectively, the method cannot be called from a transaction
     */
    public void addSomeProducts() {
        productRepository.add(); //without Autowired, productRepository is null and .add() will throw exception
        productRepository.add();
        //throw new RuntimeException("exp"); //transaction a is marked for rollback
        productRepository.add();
    } // commit everything if Propagation.REQUIRED

    public void showBeers() {
        for(var beer : productRepository.getBeers()) {
            System.out.println(beer);
        }
    }
}
