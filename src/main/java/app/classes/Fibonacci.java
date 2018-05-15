package app.classes;

public class Fibonacci {

    public static String execute(String n){
        return String.valueOf(fibonacci(Integer.valueOf(n)));
    }

    private static int fibonacci(int n){
        int f [] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            f[i] = f[i-2] + f[i-1];
        }
        return f[n];

     }
}
