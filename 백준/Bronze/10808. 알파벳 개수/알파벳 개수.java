import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        memo = new int[(int) 'z' - (int) 'a'+1];

        for (char ch : input.toCharArray()
        ) {
            int idx = ch - 'a';
            memo[idx]++;
        }

        for (int n :
                memo) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}