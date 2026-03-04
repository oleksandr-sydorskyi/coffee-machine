package com.ssa.coffeeMachine;

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

    // Логіка купівлі тепер повертає Enum замість друку в консоль
    public BuyResult buy(String choice) {
        if (cupsMade >= CLEANING_THRESHOLD) {
            return BuyResult.NEEDS_CLEANING;
        }

        if ("back".equals(choice)) return BuyResult.SUCCESS;

        Coffee coffee = Coffee.fromChoice(choice);
        if (coffee == null) return BuyResult.INVALID_CHOICE;

        return makeCoffee(coffee);
    }

    private BuyResult makeCoffee(Coffee coffee) {
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

    public void fill(int addWater, int addMilk, int addBeans, int addCups) {
        this.water += addWater;
        this.milk += addMilk;
        this.beans += addBeans;
        this.cups += addCups;
    }

    public int take() {
        int amount = money;
        money = 0;
        return amount;
    }

    public void clean() {
        cupsMade = 0;
    }

    // Гетери для тестів
    public int getWater() { return water; }
    public int getMilk() { return milk; }
    public int getBeans() { return beans; }
    public int getCups() { return cups; }
    public int getMoney() { return money; }
    public int getCupsMade() { return cupsMade; }
    public boolean needsCleaning() { return cupsMade >= CLEANING_THRESHOLD; }
}
