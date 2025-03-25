public class Main {
    public static void main(String[] args) {

        int volume = 1200;
        int fillingSpeed = 30;
        int devastationSpeed = 10;
        int time = 0;
        int currentVolume = 0;

        while (currentVolume < volume) {
            currentVolume = currentVolume + fillingSpeed - devastationSpeed;
            time = time + 1;
        }
        System.out.println("Время наполнения бассейна составляет: " + time + " минут");
    }
}
