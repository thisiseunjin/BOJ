import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.print(String.format("%.3f", a)+"\n"+String.format("%.3f", b)+"\n"+String.format("%.3f", c));
    }
}