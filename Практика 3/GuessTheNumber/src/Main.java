import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int value = new Random().nextInt(101);
        int attempt = 0;
        System.out.println("Попытайтесь угадать число от 1 до 100: ");

        do {
            attempt = new Scanner(System.in).nextInt();

            if ( attempt < value ) {
                System.out.println("Введенное число меньше загаданного!");
            } else if (attempt > value) {
                System.out.println("Введенное число больше загаданного!");
            } else {
                System.out.println("Вы угадали!");
            }
        } while (attempt != value);

    }
}

