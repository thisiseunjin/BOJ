import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int S;   //DNA문자열의 길이
    static int P;   //사용할 문자열의 길이
    static Map<Character, Integer> rule = new HashMap<>();
    static Map<Character, Integer> password = new HashMap<>();
    static String str;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        str = br.readLine();

        st = new StringTokenizer(br.readLine());
        rule.put('A', Integer.parseInt(st.nextToken()));
        rule.put('C', Integer.parseInt(st.nextToken()));
        rule.put('G', Integer.parseInt(st.nextToken()));
        rule.put('T', Integer.parseInt(st.nextToken()));

        //먼저 슬라이딩윈도우 시작
        for (int i = 0; i < P; i++) {
            char ch = str.charAt(i);
            password.put(ch, password.getOrDefault(ch, 0) + 1);
        }
        if (isPossible()) result++;


        for (int i = P; i < S; i++) {
            char cur = str.charAt(i);
            char pre = str.charAt(i - P);


            password.put(cur, password.getOrDefault(cur, 0) + 1);
            password.put(pre, password.getOrDefault(pre, 0) - 1);
            if (isPossible()) result++;
        }


        System.out.println(result);
    }

    public static boolean isPossible() {
        for (char key : rule.keySet()) {
            int required = rule.get(key);
            int count = password.getOrDefault(key, 0);
            if (count < required) return false;
        }

        return true;
    }
}