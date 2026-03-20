package machine;

class CoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private int cupsMade;

    private static final int CLEANING_THRESHOLD = 10;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.cupsMade = 0;
    }

    public BuyResult buy(String choice) {

        if (needsCleaning()) {
            return BuyResult.NEEDS_CLEANING;
        }

        Coffee coffee = getCoffeeByChoice(choice);

        if (coffee == null) {
            return BuyResult.INVALID_CHOICE;
        }

        if (water < coffee.water()) return BuyResult.NOT_ENOUGH_WATER;
        if (milk < coffee.milk()) return BuyResult.NOT_ENOUGH_MILK;
        if (beans < coffee.beans()) return BuyResult.NOT_ENOUGH_BEANS;
        if (cups < 1) return BuyResult.NOT_ENOUGH_CUPS;

        water -= coffee.water();
        milk -= coffee.milk();
        beans -= coffee.beans();
        cups--;
        money += coffee.price();

        cupsMade++;

        return BuyResult.SUCCESS;
    }

    private Coffee getCoffeeByChoice(String choice) {
        return switch (choice) {
            case "1" -> Coffee.ESPRESSO;
            case "2" -> Coffee.LATTE;
            case "3" -> Coffee.CAPPUCCINO;
            default -> null;
        };
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public int take() {
        int amount = money;
        money = 0;
        return amount;
    }

    public void clean() {
        cupsMade = 0;
        System.out.println("I have been cleaned!");
    }

    public boolean needsCleaning() {
        return cupsMade >= CLEANING_THRESHOLD;
    }

    public int getWater() { return water; }
    public int getMilk() { return milk; }
    public int getBeans() { return beans; }
    public int getCups() { return cups; }
    public int getMoney() { return money; }
    public int getCupsMade() { return cupsMade; }
}
