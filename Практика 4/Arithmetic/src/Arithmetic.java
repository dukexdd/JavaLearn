public class Arithmetic {
    int firstNumber;
    int secondNumber;

    public Arithmetic(int first, int second) {
        this.firstNumber = first;
        this.secondNumber = second;
    }

    public int sum() {
        return firstNumber + secondNumber;
    }

    public int prod() {
        return firstNumber * secondNumber;
    }

    public int minNumber() {
        if (firstNumber < secondNumber){
            return firstNumber;
        } else return secondNumber;
    }

    public int maxNumber() {
        if (firstNumber > secondNumber){
            return firstNumber;
        } else return secondNumber;
    }
}
