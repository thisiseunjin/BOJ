import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;   //남극의 단어 개수
    static int K;   //가르칠 수 있는 숫자의 개수
    static int result = 0;
    static boolean[] isSelected;
    static String[] words;
    static char[] basic = {'a', 't', 'n', 'i', 'c'};
    static boolean[] isExist;
    static char[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        isSelected = new boolean[26];
        isExist = new boolean[26];
        for (int i = 0; i < 5; i++) {
            int idx = basic[i] - 'a';
            isSelected[idx] = true;
        }
        words = new String[N];
        selected = new char[K];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }


        comb(0, 0);

        System.out.println(result);

    }

    public static void comb(int cnt, int start) {

        if (cnt == K - 5) {
            //각 단어가 배운 알파벳으로 가능한가?
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = isPossible(words[i]);
                if (!flag) continue;
                count++;
            }

            result = Math.max(count, result);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static boolean isPossible(String str) {
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (isSelected[ch]) continue;
            return false;
        }

        return true;
    }
}