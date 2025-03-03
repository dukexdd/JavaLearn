public class Main {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(42,78);
        System.out.println("Сумма двух чисел: " + arithmetic.sum());
        System.out.println("Произведение двух чисел: " + arithmetic.prod());
        System.out.println("Минимальное число: " + arithmetic.minNumber());
        System.out.println("Максимальное число: " + arithmetic.maxNumber());
    }
}
