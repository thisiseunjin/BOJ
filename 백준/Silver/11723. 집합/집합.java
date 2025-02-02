import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums = new int[21];
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("all")) {
                Arrays.fill(nums, 1);
                continue;
            }

            if (operation.equals("empty")) {
                Arrays.fill(nums, 0);
                continue;
            }

            n = Integer.parseInt(st.nextToken());
            if (operation.equals("add")) {
                nums[n] = 1;
                continue;
            }

            if (operation.equals("remove")) {
                nums[n] = 0;
                continue;
            }

            if (operation.equals("check")) {
                sb.append(nums[n] == 1 ? 1 : 0);
                sb.append('\n');
                continue;
            }

            if (operation.equals("toggle")) {
                nums[n] = nums[n] == 1 ? 0 : 1;
            }



        }
        System.out.print(sb);
    }
}