public class Main {
    public static void main(String[] args) {
        double weightKg = 70;
        double heightCm = 190;
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        System.out.println("индекс - " + userIndex);
    }

}
