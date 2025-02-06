import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int d;
    static boolean[] isSelected;
    static int result = -1;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        isSelected = new boolean[d];
        selected = new int[d];

        calc(0);

//        System.out.println(Integer.toString(2022, d));
//        System.out.println(Integer.toString(result, d));

        System.out.println(result);
    }

    public static void calc(int cnt) {
        if (result != -1) {
            return;
        }

        if (cnt == d) {
//            System.out.println(Arrays.toString(selected));
            int sum = 0;
            for (int i = 0; i < d; i++) {
                sum += (int) Math.pow(d, i) * selected[d-1-i];
            }
            if (sum > N) {
                result = sum;
            }
            return;
        }

        for (int i = 0; i < d; i++) {
            if (cnt == 0 && i == 0) continue;
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selected[cnt] = i;
            calc(cnt + 1);
            isSelected[i] = false;
        }
    }

}