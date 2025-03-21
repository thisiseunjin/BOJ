import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int P;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        P = Integer.parseInt(br.readLine());
        for (int i = 1; i < P + 1; i++) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int test = Integer.parseInt(st.nextToken());
            sb.append(test).append(" ");

            int totalCount = 0;
            for (int n = 0; n < 20; n++) {
                int h = Integer.parseInt(st.nextToken());
                totalCount += getCount(h);
            }
            sb.append(totalCount).append("\n");
        }
        System.out.println(sb);
    }

    public static int getCount(int h) {
        //모두 정렬 되어 있다고 가정해야함.
        if (list.isEmpty()) {
            list.add(h);
            return 0;
        }
        int behind = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int pre = list.get(i);
            if (pre < h) {
                break;
            }
            //내 뒤에서 걸음을 뒤로 물러나야할 사람들의 수
            behind += 1;
        }
        list.add(h);
        Collections.sort(list);
        return behind;
    }
}