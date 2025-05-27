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

        System.out.println(compression(N, 0, 0));

    }

    public static String compression(int size, int startX, int startY) {
        //지금 압축 가능한가?
        int compressed = isPossible(size, startX, startY);

        if (compressed != -1) {
            return compressed + "";
        }


        //4등분
        String s1 = compression(size / 2, startX, startY);
        String s2 = compression(size / 2, startX, startY+ (size / 2));
        String s3 = compression(size / 2, startX+ (size / 2), startY );
        String s4 = compression(size / 2, startX + (size / 2), startY + (size / 2));

        if (s1.equals("0") && s2.equals("0") && s3.equals("0") && s4.equals("0")) return "0";
        if (s1.equals("1") && s2.equals("1") && s3.equals("1") && s4.equals("1")) return "1";
        else return "(" + s1 + s2 + s3 + s4 + ")";
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