import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Stack<Integer> stack;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stack = new Stack<>();
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                push(x);
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("size")) {
                size();
            } else if (op.equals("empty")) {
                empty();
            } else top();

            
        }
        System.out.println(sb);
    }

    public static void push(int x) {
        stack.push(x);
    }

    public static void pop() {
        if (stack.isEmpty()) {
            sb.append(-1).append("\n");
            return;
        }

        sb.append(stack.pop()).append("\n");
    }

    public static void size() {
        sb.append(stack.size()).append("\n");
    }

    public static void empty() {
        sb.append(stack.isEmpty() ? 1 : 0).append("\n");
    }

    public static void top() {
        if (stack.isEmpty()) {
            sb.append(-1).append("\n");
            return;
        }

        sb.append(stack.peek()).append("\n");
    }
}