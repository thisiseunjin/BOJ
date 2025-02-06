import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] operations;
    static int[] nums;
    static int N;
    static int max = -(int) 1e9;
    static int min = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        operations = new int[4];
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);

        System.out.println(max + "\n" + min);
    }

    public static void dfs(int cnt, int pre) {
        if (cnt == N) {
            max = Math.max(max, pre);
            min = Math.min(min, pre);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] == 0) continue;
            if (i == 0) {
                //덧셈
                operations[i]--;
                dfs(cnt + 1, pre + nums[cnt]);
                operations[i]++;
            } else if (i == 1) {
                //뺄셈
                operations[i]--;
                dfs(cnt + 1, pre - nums[cnt]);
                operations[i]++;
            } else if (i == 2) {
                //곰셈
                operations[i]--;
                dfs(cnt + 1, pre * nums[cnt]);
                operations[i]++;
            } else {
                //나눗셈
                operations[i]--;
                dfs(cnt + 1, pre / nums[cnt]);
                operations[i]++;
            }
        }
    }
}