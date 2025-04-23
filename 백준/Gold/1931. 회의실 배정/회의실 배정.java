import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Meeting[] meets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meets = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meets[i] = new Meeting(start, end);
        }

        Arrays.sort(meets, Comparator.comparing((Meeting m) -> m.end)
                .thenComparing(m -> m.start));

        int cur = meets[0].end;
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            Meeting m = meets[i];

            if (m.end == m.start) {
                cnt++;
                continue;
            }

            //지금 시간에 진행할 수 있는 회의인가?
            if (m.start < cur) {
                //지금 시간보다 이르게 시작해야한다? 시작 못한다~!~!~!
                continue;
            }

            cur = m.end;
            cnt++;
        }

        System.out.println(cnt);
    }

    public static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}