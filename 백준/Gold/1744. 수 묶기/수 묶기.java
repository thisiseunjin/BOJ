import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> positive;
    static PriorityQueue<Integer> negative;
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        positive = new PriorityQueue<>(Comparator.reverseOrder());
        negative = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                positive.add(n);
            } else if (n == 0) {
                zeroCount += 1;
            } else negative.add(n);
        }

        //양수끼리는 곱해줄 수 있을 때 까지 곱해준다.
        int sum = 0;
        while (positive.size() >= 2) {
            int n = positive.poll();
            int next = positive.peek();

            if (n == 1 || next == 1) {
                positive.add(n);
                break;
            } else {
                sum += (n * positive.poll());
            }
        }

        //남은 양수 다 더하기
        while (!positive.isEmpty()) {
            sum += positive.poll();
        }

        //음수 곱하면 양수가 되기 때문에 곱할 수 있을 때 까지 곱해준다
        while (negative.size() >= 2) {
            sum += (negative.poll() * negative.poll());
        }

        //남은 음수 다 더하기, 그런데 zero가 남아 있으면? 0로 곱해서 손실을 최소로 만들어주기
        while (!negative.isEmpty()) {
            if (zeroCount > 0) {
                negative.poll();
                zeroCount -= 1;
            } else {
                sum += negative.poll();
            }
        }

        System.out.println(sum);
    }
}