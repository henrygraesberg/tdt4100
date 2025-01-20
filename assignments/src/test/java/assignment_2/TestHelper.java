package assignment_2;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestHelper {

    public static void checkIfFieldsPrivate(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            assertTrue(Modifier.isPrivate(field.getModifiers()),
                    "Expected field " + field.getName() + " to be private!");
        }
    }
}
