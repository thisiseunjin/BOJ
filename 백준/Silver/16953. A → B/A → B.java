import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int count = 1;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else {
                if(B%10!=1){
                    break;
                }else B/=10;
            }
//            System.out.println(B);

            count++;
        }

        System.out.println(B == A ? count : -1);
    }
}