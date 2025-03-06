import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

//        int money = 0;
        int idx = N - 1;
        int count = 0;

        while (idx >= 0) {
            if (K == 0) break;
//            System.out.println(K);
            //만약에 coins[idx]가 K보다 크다면? 못쓴다
            if (K - coins[idx] < 0) {
//                System.out.printf("%d(coin)은 %d(K)보다 커서 안됨. \n", coins[idx], K);
                idx -= 1;
                continue;
            }

            K -= coins[idx];
            count++;
        }

        System.out.println(count);
    }

}