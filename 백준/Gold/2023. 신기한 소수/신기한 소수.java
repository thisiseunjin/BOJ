import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int[] selected;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new int[N];

        permutation(0);

        //-- 정답 출력 부분
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }

    public static void permutation(int cnt) {
        if (cnt > 0) {
            int n = isPossible(cnt);
            if (n == -1) {
//                for (int i = 0; i < cnt; i++) {
//                    System.out.print(selected[i]);
//                }
//                System.out.println("은 소수가 아니다.");
                return;
            }

//            System.out.println(n + "은 소수이다.");

            if (cnt == N) {
                list.add(n);
                return;
            }
        }

        for (int i = 1; i < 10; i++) {
            selected[cnt] = i;
            permutation(cnt + 1);
        }
    }

    public static int isPossible(int cnt) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(selected[i]);
        }

        int num = Integer.parseInt(sb.toString());

        if (num == 2) return 2;
        if (num == 1) return -1;
        for (int i = 2; i <= (num / 2) + 1; i++) {
            if (num % i == 0) return -1;
        }

        return num;

    }

}