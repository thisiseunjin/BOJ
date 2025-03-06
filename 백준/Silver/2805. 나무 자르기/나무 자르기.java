import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;   //필요한 나무
    static int N;
    static long[] trees;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(trees);

        long left = 0L;
        long right = trees[N - 1];

        long mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;

            long h = getHeight(mid);

            //만약에 h가 우리의 목표를 만족시킨다면? h를 줄인다.
            if (h >= M) {

                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    public static long getHeight(long h) {
        long sum = 0;
        for (long tree : trees) {
            long left = tree - h;
            sum += Math.max(0, tree - h);
        }

        return sum;
    }
}