import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str;
        Stack<Character> stack;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            stack = new Stack<>();

            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') {
                    stack.push('(');
                    continue;
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                    continue;
                }

                flag = false;
                break;

            }

            if (flag && stack.isEmpty()) {
                sb.append("YES");
            } else {
                sb.append("NO");

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}