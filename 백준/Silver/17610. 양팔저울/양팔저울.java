import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int S;
    static int[] weights;
    static boolean[] memo;
    static int[] isSelected;
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = Integer.parseInt(br.readLine());
        weights = new int[S];
        isSelected = new int[S];

        int totalWeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int w = Integer.parseInt(st.nextToken());
            weights[i] = w;
            totalWeight += w;
        }

        memo = new boolean[totalWeight + 1];

        put(0, 0, 0);

        System.out.println(getCount());
    }

    public static void put(int start, int left, int right) {
        memo[Math.abs(left - right)] = true;
        if (start > S - 1) {

            return;
        }


        for (int i = start; i < S; i++) {
            //추를 왼쪽에 놓는다.
            if (isSelected[i] != 0) continue;
            isSelected[i] = 1;
            put(i + 1, left + weights[i], right);
            isSelected[i] = 0;

            isSelected[i] = 2;
            put(i + 1, left, right + weights[i]);
            isSelected[i] = 0;
        }


    }

    public static int getCount() {
        int cnt = 0;
        for (boolean b : memo) {
            if (b) continue;
            cnt++;
        }

        return cnt;
    }
}