import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //여2, 남1
        int teamCount = Math.min(N / 2, M);
        int leftCount = (N + M) - ((teamCount * 2) + (teamCount));

        while (leftCount < K) {
            teamCount-=1;
            leftCount += 3;
        }

        System.out.println(teamCount);
    }
}