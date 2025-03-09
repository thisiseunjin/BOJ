import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static Map<Integer, Integer> order = new HashMap<>();
    static int[] sortedNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        sortedNums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sortedNums = nums.clone();

        Arrays.sort(sortedNums);

        int idx = 1;
        order.put(sortedNums[0], 0);
        int pre = sortedNums[0];
        for (int i = 1; i < N; i++) {
            int n = sortedNums[i];
            if (pre == n) continue;
            order.put(sortedNums[i], idx++);
            pre = sortedNums[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(order.get(n)).append(" ");
        }
        System.out.println(sb);
//        System.out.println(order.toString());
    }
}