import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   //굴다리의 길이
    static int M;
    static int result = (int) 1e9;
    static int[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        info = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int left = info[0];
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                //줄여본다
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }


    public static boolean isPossible(int height){
        int left =0;

        for(int n : info){
            if(n-height>left) return false;
            left = n+height;
        }

        return left>=N;
    }
}