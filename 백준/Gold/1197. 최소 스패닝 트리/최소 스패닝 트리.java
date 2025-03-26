import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static int[] parents;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        list = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            parents[i] = i;
        }
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list.add(new int[]{adj, v1, v2});
        }
        int result = 0;
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        for (int[] info : list) {
            int adj = info[0];
            int v1 = info[1];
            int v2 = info[2];

            if (!union(v1, v2)) continue;
            result += adj;
        }

        System.out.println(result);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
        return true;
    }


    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

}