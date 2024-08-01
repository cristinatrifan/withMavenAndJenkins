package beans2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat {
    private String name = "comp";

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
