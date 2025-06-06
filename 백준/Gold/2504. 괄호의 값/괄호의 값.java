import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Object> stack;
    static boolean isPossible = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                boolean flag = isPossible('(', 2);
                if (!flag) {
                    isPossible = false;
                    break;
                }
            } else if (ch == ']') {
                boolean flag = isPossible('[', 3);
                if (!flag) {
                    isPossible = false;
                    break;
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (!(obj instanceof Integer)) {
                isPossible = false;
                break;
            }

            result += (int) obj;
        }

        if (!isPossible) {
            System.out.println(0);
        } else System.out.println(result);

    }

    public static boolean isPossible(char open, int adj) {
        //이제 뽑아줄 차례이다~!
        int tmp = 0;
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof Integer) {
                tmp += (int) obj;
                continue;
            }

            //숫자가 아니라 이제 문자이다? 닫는건가?
            if (obj instanceof Character && (char) obj == open) {
                stack.push(tmp == 0 ? adj : tmp * adj);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}