import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums);
        for(int n:nums){
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}