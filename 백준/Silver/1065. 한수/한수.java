import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Math.min(999, Integer.parseInt(br.readLine()));

        System.out.println(calc());
    }

    static int calc() {
        if (N < 111) return Math.min(N, 99);

        int cnt = 99;
        //이제 3자리 숫자이다.
        for (int i = 111; i <= N; i++) {
            //백의 자리 빼기 1의 자리
            int h = i / 100;
            int t = i / 10 % 10;
            int o = i % 10;

            if (h - t != t - o) continue;
            cnt++;
        }

        return cnt;
    }

}