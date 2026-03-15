package machine;

record Coffee(int water, int milk, int beans, int price) {

    public static Coffee fromChoice(String choice) {
        return switch (choice) {
            case "1" -> new Coffee(250, 0, 16, 4);
            case "2" -> new Coffee(350, 75, 20, 7);
            case "3" -> new Coffee(200, 100, 12, 6);
            default -> null;
        };
    }
}
