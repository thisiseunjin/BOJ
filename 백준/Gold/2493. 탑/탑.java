import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<int[]> stack = new Stack<>();
    static Stack<int[]> tmp = new Stack<>();
    static int N;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        result = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        stack.push(new int[]{1, Integer.parseInt(st.nextToken())});
        for (int i = 2; i < N + 1; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                //수신 탑을 찾을 때 까지 pop
                if (peek[1] < cur) {
                    stack.pop();
                    continue;
                }
                //수신 탑을 찾았다?
                result[i] = peek[0];
                break;
            }
            stack.push(new int[]{i, cur});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}