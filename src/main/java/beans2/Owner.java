package beans2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner {
    private Cat cat;

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
