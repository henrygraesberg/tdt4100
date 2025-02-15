package assignment_4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {
  private CoffeeCup emptyCoffee, coffee;

  @BeforeEach
  public void setup() {
    emptyCoffee = new CoffeeCup();
    coffee = new CoffeeCup(10, 2);
  }

  @Test
  @DisplayName("Test constructor")
  void constructorTest() {
    assertEquals(0, emptyCoffee.getCapacity());
    assertEquals(0, emptyCoffee.getCurrentVolume());

    assertEquals(10, coffee.getCapacity());
    assertEquals(2, coffee.getCurrentVolume());

    assertEquals(true, "[CoffeeCup capacity=10.00, currentVolume=2.00]".equals(coffee.toString()));

    assertThrows(IllegalArgumentException.class, () -> coffee = new CoffeeCup(1, 10));
    assertThrows(IllegalArgumentException.class, () -> coffee = new CoffeeCup(-10, 2));
    assertThrows(IllegalArgumentException.class, () -> coffee = new CoffeeCup(10, -2));
  }

  @Test
  @DisplayName("Test increaseCupSize")
  void testIncreaseCupSize() {
    coffee.increaseCupSize(5);
    assertEquals(15, coffee.getCapacity());

    coffee.increaseCupSize(-10);
    assertEquals(15, coffee.getCapacity());

    emptyCoffee.increaseCupSize(10);
    assertEquals(10, emptyCoffee.getCapacity());
  }

  @Test
  @DisplayName("Test drink and fill")
  void testChangeVolume() {
    coffee.drinkCoffee(1);
    assertEquals(1, coffee.getCurrentVolume());

    coffee.fillCoffee(9);
    assertEquals(10, coffee.getCurrentVolume());

    coffee.drinkCoffee(2);

    assertThrows(IllegalArgumentException.class, () -> coffee.drinkCoffee(100));
    assertThrows(IllegalArgumentException.class, () -> coffee.drinkCoffee(9));
    assertThrows(IllegalArgumentException.class, () -> coffee.fillCoffee(100));
  }
}
