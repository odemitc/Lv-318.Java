package app.classes;

public class Fibonacci {

    public static String execute(String n){
        return String.valueOf(fibonacci(Integer.valueOf(n)));
    }

    private static int fibonacci(int number){
        if (number <= 1) return number;
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i < number; i++) {
            int temp = f2;
            f2 += f1;
            f1 = temp;
        }
        return f2;
    }
}
