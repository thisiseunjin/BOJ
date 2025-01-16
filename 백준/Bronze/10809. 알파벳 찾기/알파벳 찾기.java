import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] memo;
    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        memo = new int[(int) 'z' - (int) 'a' + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < input.length(); i++) {
            if (memo[input.charAt(i) - 'a'] != -1) continue;
            memo[input.charAt(i) - 'a'] = i;
        }

        for (int n :
                memo) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}