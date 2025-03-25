import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число от 1 до 12 для вычисления его факториала:");

        int n = new Scanner(System.in).nextInt();
        int i;
        int factorial = 1;

        if (n >= 1 && n <= 12) {
            for (i = 1; i <= n; i = i + 1) {
                factorial = factorial * i;
            }
            System.out.println("Факториал числа " + n + " равен: " + factorial);
        } else {
            System.out.println("Введено не верное число!");
        }

    }
}
