import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число, и программа найдет все пары положительных целых чисел, произведение которых равно этому числу:");
        int val = new Scanner(System.in).nextInt();

        for (int n = 1; n <= val; n = n + 1) {
            for (int m = 1; m <= val; m = m + 1) {
                if (n * m == val) {
                    System.out.println("Числа: " + n + " и " + m);
                }
            }
        }

    }
}