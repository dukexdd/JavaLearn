public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко", 40, 3, 3);
        basket.add("Яблоко", 10, 5, 1.3);
        basket.print("Milk");
        System.out.println("Общий вес корзины: " + basket.getTotalWeight() + " кг.");
    }
}

