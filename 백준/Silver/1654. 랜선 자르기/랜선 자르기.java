import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K;   //이미 가지고 있는 랜선의 개수
    static int N;   //추가로 필요한 랜선의 개수
    static long result = 0;
    static int[] cables;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        cables = new int[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cables);

        long left = 1;
        long right = cables[K - 1];
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            int cnt = getCount(mid);

            //만약에 개수가 크거나 같다? 길이를 늘려
            if (cnt >= N) {
                result = Math.max(result, mid);
                left = (mid + 1);
            } else {
                right = (mid - 1);
            }
        }

        System.out.println(result);
    }

    public static int getCount(long n) {
        //n의 길이로 랜선을 잘랐을 때 몇개의 랜선을 가질 수 있는가에 대해 반환
        int count = 0;
        for (int cable : cables) {
            count += (int) (cable / n);
        }

        return count;
    }
}