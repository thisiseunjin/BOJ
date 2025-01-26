import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    남학생은 1
    여학생은 2
     */

    static int N;
    static boolean[] status;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        status = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int s = Integer.parseInt(st.nextToken());
            status[i] = s == 1;
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                boy(idx);
            } else {
                girl(idx);
            }
        }

        //마지막 스위치까지 한 줄에 20개씩 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(status[i] ? 1 : 0);
            if (i % 20 == 0) {
                sb.append("\n");
            } else if (i < N) {
                sb.append(" ");
            }
        }
        System.out.println(sb);


    }

    static void boy(int idx) {
        //배수를 바꾼다.
        for (int i = idx; i <= N; i += idx) {
            status[i] = !status[i];
        }
    }

    static void girl(int idx) {
        //지금 내 상태는 바꾼다.
        status[idx] = !status[idx];

        //이제 대칭 되는거 바꾼다.
        for (int i = 1; i < N + 1; i++) {
            //범위 내인가?
            int left = idx - i;
            int right = idx + i;

            if (left <= 0 || right >= N + 1) break;
            if (status[left] != status[right]) break;

            //둘이 같으면?
            status[left] = !status[left];
            status[right] = !status[right];
        }
    }
}