import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] energy;
    static boolean[] isSelected;
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N];
        energy = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
            list.add(energy[i]);
        }

        getEnergy(0, 0);

        System.out.println(result);
    }

    public static void getEnergy(int cnt, int sum) {
        if (cnt == N - 2) {
            //종료 조건
            result = Math.max(result, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            //이미 선택 되었다면? 선택하지 못 한다.
            int e = list.get(i);
            int nextSum = sum + (list.get(i - 1) * list.get(i + 1));
            list.remove(i);
            getEnergy(cnt + 1, nextSum);
            list.add(i, e);
        }
    }
}