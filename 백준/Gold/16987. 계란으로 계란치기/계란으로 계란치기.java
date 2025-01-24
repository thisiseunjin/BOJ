import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }

        breakEggs(0);

        System.out.println(result);

    }

    static void breakEggs(int idx) {

        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i].s > 0) continue;
                cnt++;
            }
            result = Math.max(cnt, result);
            return;
        }

        if (eggs[idx].s <= 0) {
            breakEggs(idx + 1);
            return;
        }

        boolean isAllBroken = true;

        for (int i = 0; i < N; i++) {
            if (eggs[i].s < 0) {
                continue;
            }
            if (i == idx) continue;    //지금 내가 쥐도 있는 것이면? 그냥 넘어 간다.

            isAllBroken = false;
            //내구도를 깎는다.
            eggs[i].s -= eggs[idx].w;
            eggs[idx].s -= eggs[i].w;

            breakEggs(idx + 1);

            eggs[i].s += eggs[idx].w;
            eggs[idx].s += eggs[i].w;
        }

        if (isAllBroken) {
            breakEggs(N);
        }
    }

    static class Egg {
        int s;  //내구도
        int w;  //무게

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        @Override
        public String toString() {
            return "{ 내구도=" + s + ", 무게=" + w + "}";
        }
    }
}