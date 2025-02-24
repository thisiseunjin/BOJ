import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for (int n : nums) {
            sb.append(n).append("\n");
        }

        System.out.print(sb);
    }
}