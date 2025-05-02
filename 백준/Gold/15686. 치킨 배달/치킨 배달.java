import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> houses;
    static ArrayList<int[]> stores;
    static int minDist = (int) 1e9;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        houses = new ArrayList<>();
        stores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    stores.add(new int[]{i, j});
                }
            }
        }

        isSelected = new boolean[stores.size()];

        comb(0, 0);
        System.out.println(minDist);
    }

    public static void comb(int cnt, int start) {
        if (cnt == M) {
            calc();
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static void calc() {
        int sum = 0;
        for (int[] home : houses) {
            //각 집에서 가장 가까운 치킨 집을 찾는다
            int min = (int) 1e9;
            for (int i = 0; i < stores.size(); i++) {
                if (!isSelected[i]) continue;
                int[] store = stores.get(i);
                min = Math.min(min, getDist(home[0], home[1], store[0], store[1]));
            }
            sum += min;
            if (sum > minDist) return;
        }
        minDist = Math.min(sum, minDist);
    }

    public static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}