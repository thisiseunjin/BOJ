import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    //    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        for(int n:list){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}