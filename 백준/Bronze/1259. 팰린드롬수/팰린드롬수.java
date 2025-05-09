import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
//            System.out.println("===================");
            String input = br.readLine();
            if (input.equals("0")) break;


            boolean flag = false;
            if (input.length() == 1) {
                flag = true;
            } else if (input.length() % 2 == 0) {
                flag = isPalindromeEven(input);
            } else {
                flag = isPalindromeOdd(input);
            }

            sb.append(flag ? "yes" : "no").append("\n");

        }

        System.out.println(sb);
    }

    public static boolean isPalindromeOdd(String str) {

        //0 1 2
        // 0까지 n/2
        for (int i = 0; i < (str.length()) / 2; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(str.length() - 1 - i);

//            System.out.printf("%c, %c 를 비교중임\n", ch1, ch2);

            if (ch1 != ch2) return false;
        }

        return true;

        //0 1 2 3
    }

    public static boolean isPalindromeEven(String str) {

        //0 1 2
        // 0까지 n/2
        for (int i = 0; i <= (str.length()) / 2; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(str.length() - 1-i);

//            System.out.printf("%c, %c 를 비교중임\n", ch1, ch2);

            if (ch1 != ch2) return false;
        }

        return true;

        //0 1 2 3
    }
}