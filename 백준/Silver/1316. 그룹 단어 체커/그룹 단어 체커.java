import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int result = 0;
    static int N;
    static boolean[] isSelected = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char pre = input.charAt(0);
            Arrays.fill(isSelected, false);
            isSelected[(int) pre - 'a'] = true;
            boolean flag = true;
            for (int j = 1; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == pre) continue;
                if (isSelected[ch - 'a']) {
                    flag = false;
                    break;
                }
                isSelected[ch - 'a'] = true;
                pre = ch;
            }
            if (flag) result++;
        }

        System.out.println(result);
    }
}