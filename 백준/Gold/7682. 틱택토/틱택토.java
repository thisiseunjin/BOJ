import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            char[][] map = new char[3][3];
            int xCount = 0;
            int oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = input.charAt((3 * i) + j);
                    if (map[i][j] == 'X') xCount++;
                    if (map[i][j] == 'O') oCount++;
                }
            }

            boolean flagX = checkX(map);
            boolean flagO = checkO(map);

            if (flagX && !flagO && xCount == oCount + 1) sb.append("valid");
            else if (!flagX && flagO && xCount == oCount) sb.append("valid");
            else if(!flagX && !flagO && xCount==5 && oCount==4) sb.append("valid");
            else sb.append("invalid");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean checkX(char[][] map) {
        //조건2) X로 이루어진 틱텍토가 1개 있다.
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') return true;
            if (map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') return true;
        }

        //가로 확인
        if (map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') return true;
        if (map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X') return true;

        return false;
    }

    public static boolean checkO(char[][] map) {

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O') return true;
            if (map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') return true;
        }

        if (map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') return true;
        if (map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O') return true;

        return false;
    }
}