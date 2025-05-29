import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] mentionInfo;
    static int[] result;
    static Long avg = 0L;
    static boolean isMacro = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mentionInfo = new int[N];   //사람의 수
        result = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        Long sum = 0L;
        for (int i = 0; i < N; i++) {
            mentionInfo[i] = Integer.parseInt(st.nextToken());
            if (mentionInfo[i] >= 2) {
                //멘션을 2회 "이상"한 사람들의 멘션 평균을 구한다.
                tmp++;
                sum += mentionInfo[i];
            }
        }

        //2회 이상 멘션을 보낸 사람이 있는가?
        if (tmp > 0) {
            avg = sum / tmp;
        }

        //이제 답장을 보내본다
        for (int i = 0; i < N; i++) {
            int count = mentionInfo[i];
            //만약 평균 이하이면?
            if (count <= avg) {
                //각 멘션마다 1번부터 차례로 보낸다.
                if (count > M) {
                    isMacro = true;
                    break;
                }

                result[count]++;
            } else {
                //평균 초과히면?
                result[1]++;
            }
        }

        for (int i = M - 1; i > 0; i--) {
            result[i] += result[i + 1];
        }


        if (isMacro) {
            System.out.println(-1);
        } else {
           StringBuilder sb = new StringBuilder();
            for (int i = 1; i < M+1; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}