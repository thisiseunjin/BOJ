import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static TreeSet<String> set = new TreeSet<>(Comparator.comparing(String::length).thenComparing(String::compareTo));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            set.add(w);
        }

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}