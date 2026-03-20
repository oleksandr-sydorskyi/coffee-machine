package machine;

record Coffee(int water, int milk, int beans, int price) {
    public static final Coffee ESPRESSO = new Coffee(250, 0, 16, 4);
    public static final Coffee LATTE = new Coffee(350, 75, 20, 7);
    public static final Coffee CAPPUCCINO = new Coffee(200, 100, 12, 6);
}
