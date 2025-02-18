import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sum;
    static int[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new int[N];
        sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            adj[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(adj);
        sum[0] = adj[0];

        for (int i = 1; i < N; i++) {
            //내 앞사람이 걸린 시간 + 내가 지금 걸리는 시간
            sum[i] = sum[i - 1] + adj[i];
        }

        int result = 0;
        for (int time : sum) {
            result += time;
        }

//        System.out.println(Arrays.toString(sum));
        System.out.println(result);
    }
}