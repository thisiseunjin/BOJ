import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> nums = new ArrayDeque<>();
    static ArrayDeque<Character> ops = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = (int) 1e9;
        st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {

            int tmp = 0;
            StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
            while (addition.hasMoreTokens()) {
                tmp += Integer.parseInt(addition.nextToken());
            }

            if (result == (int) 1e9) {
                result = tmp;
            } else {
                result -= tmp;
            }
        }

        System.out.println(result);

    }
}