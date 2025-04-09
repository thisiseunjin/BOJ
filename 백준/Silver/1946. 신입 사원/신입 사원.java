import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> list;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            list = new ArrayList<>();
            int cnt = 1;
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());

                list.add(new int[]{score1, score2});
            }

            list.sort(Comparator.comparing((int[] ints) -> ints[0]));
            int limit = list.get(0)[1];
            for (int i = 1; i < N; i++) {
                if (limit > list.get(i)[1]) {
                    cnt += 1;
                    limit = list.get(i)[1];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

}