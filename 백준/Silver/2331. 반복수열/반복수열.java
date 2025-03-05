import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> set = new LinkedHashSet<>();
    static Set<Integer> duplicate = new LinkedHashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        set.add(pre);

        while (true) {
            int n = getNext(pre, P);
            pre = n;

            if (set.contains(n) && duplicate.contains(n)) {
                break;
            }

            if (set.contains(n) && !duplicate.contains(n)) {
                duplicate.add(n);
            } else set.add(n);
        }

        System.out.println(set.size()-duplicate.size());

    }

    public static int getNext(int n, int p) {
        int num = 0;
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); i++) {
            num += (int) Math.pow((str.charAt(i) - '0'), p);
        }

        return num;
    }
}