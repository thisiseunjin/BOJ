import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  //A의 수
            int M = Integer.parseInt(st.nextToken());  //B의 수

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);


            for (int i = 0; i < N; i++) {
                int cnt = 0;  //나보다 작은 아이들의 개수를 저장할 변수
                for (int j = 0; j < M; j++) {
                    if (A[i] <= B[j]){
                       break;
                    }
                    cnt++;
                }
//                System.out.println(A[i]+"보다 작은 숫자들의 개수는 "+cnt+"개이다.");
                result +=  cnt;
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}