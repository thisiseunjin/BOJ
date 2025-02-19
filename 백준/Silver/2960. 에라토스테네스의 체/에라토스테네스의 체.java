import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int count = 0;
    static boolean[] isRemoved;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isRemoved = new boolean[N + 1];


        for (int i = 2; i < N + 1; i++) {
            if (isRemoved[i]) continue;  //이미 지워진 수라면? 그냥 넘어간다.
            if (!isPossible(i)) continue;
            remove(i);
            if (result != -1) break;
        }

        System.out.println(result);
    }

    public static boolean isPossible(int n) {
        //소수인지 확인해본다.
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n * i == 0) return false;
        }

        return true;
    }

    public static void remove(int n) {
        for (int i = 1; i < N; i++) {
            int num = n * i;
            if (num > N) break;

            if (isRemoved[num]) continue;
            //지운다.
            isRemoved[num] = true;
            count++;
            if (count == K) {
                result = num;
                return;
            }
        }
    }
}