import java.util.*;
import java.io.*;

public class Main {
    static int H;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(factorial(n));
    }

    static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }

        return n*factorial(n-1);
    }
}