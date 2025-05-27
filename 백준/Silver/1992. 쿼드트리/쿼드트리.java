import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        compression(N, 0, 0);
        System.out.println(sb);

    }

    public static void compression(int size, int startX, int startY) {
        //지금 압축 가능한가?
        int compressed = isPossible(size, startX, startY);

        if (compressed != -1) {
            sb.append(compressed);
            return;
        }

        sb.append("(");
        //4등분
        compression(size / 2, startX, startY);
        compression(size / 2, startX, startY + (size / 2));
        compression(size / 2, startX + (size / 2), startY);
        compression(size / 2, startX + (size / 2), startY + (size / 2));

        sb.append(")");
    }

    public static int isPossible(int size, int startX, int startY) {
        int target = map[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (map[i][j] != target) return -1;
            }
        }
        return target;
    }


}