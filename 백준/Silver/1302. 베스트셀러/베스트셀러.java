import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Iterator<String> it = map.keySet().iterator();
        String result = "";
        int max = 0;
        while (it.hasNext()) {
            String key = it.next();
            int value = map.get(key);

            if (max >= value) continue;

            max = value;
            result = key;

        }

        System.out.println(result);
    }
}