package beans2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner2 {

    /*because this bean is by default singleton
    meaning this instance will be used in the whole application
    we should make sure it is not randomly changed - so need to make it immutable/final
     */
    //can also be autowired, but then it's not final anymore
    private final Cat cat;

    //can use autowired on constructor
    @Autowired(required = true) // by default is required
    public Owner2(Cat cat) {
        this.cat = cat;
    }

    /*
    //Autowired - a setter can also be autowired
    @Qualifier("cat1")
    public void setCat(Cat cat) {
        this.cat = cat;
    }
     */
}
