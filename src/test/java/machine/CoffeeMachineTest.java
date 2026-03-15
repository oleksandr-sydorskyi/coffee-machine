package machine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {

    @Test
    void testEspressoDeductsCorrectResources() {
        CoffeeMachine machine = new CoffeeMachine(400, 500, 100, 5, 50);

        BuyResult result = machine.buy("1"); // 1 - espresso: 250 water, 16 beans, $4

        assertEquals(BuyResult.SUCCESS, result);
        assertEquals(150, machine.getWater()); // 400 - 250
        assertEquals(500, machine.getMilk());  // milk unchanged
        assertEquals(84, machine.getBeans());  // 100 - 16
        assertEquals(54, machine.getMoney());  // 50 + 4
    }

    @Test
    void testNotEnoughResources() {
        CoffeeMachine machine = new CoffeeMachine(100, 100, 100, 1, 0);

        BuyResult result = machine.buy("1"); // Потрібно 250 води

        assertEquals(BuyResult.NOT_ENOUGH_WATER, result);
        assertEquals(100, machine.getWater()); // Ресурси не змінилися
    }

    @Test
    void testCleaningLogic() {
        CoffeeMachine machine = new CoffeeMachine(5000, 5000, 5000, 100, 0);

        // Робимо 10 порцій
        for (int i = 0; i < 10; i++) {
            machine.buy("1");
        }

        assertEquals(BuyResult.NEEDS_CLEANING, machine.buy("1"));

        machine.clean();
        assertEquals(0, machine.getCupsMade());
        assertEquals(BuyResult.SUCCESS, machine.buy("1"));
    }
}
