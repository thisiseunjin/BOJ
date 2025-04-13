import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map = new LinkedHashMap<>();
    static int[] nums;
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        int total = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
            map.put(n, map.getOrDefault(n, 0) + 1);
            total += n;
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(nums);
        int avg = Math.round((float) total / N);
        sb.append(avg).append("\n");

        int mid = 0;
        if (N % 2 == 0) {
            int idx1 = N / 2;
            int idx2 = (N / 2) + 1;
            mid = (nums[idx1] + nums[idx2]) / 2;
        } else {
            mid = nums[N / 2];
        }
        sb.append(mid).append("\n");

        int max = 0;
        list = new ArrayList<>();
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            if (max > cnt) continue;
            if (cnt > max) {
                max = cnt;
                list = new ArrayList<>();
                list.add(key);
            } else if (cnt == max) {
                list.add(key);
            }

        }

        Collections.sort(list);
        sb.append(list.size() > 1 ? list.get(1) : list.get(0)).append("\n");

        sb.append(nums[N - 1] - nums[0]).append("\n");


        System.out.println(sb);
    }
}