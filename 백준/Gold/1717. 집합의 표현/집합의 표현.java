import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] parents;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        sb = new StringBuilder();

        for(int i=0;i<N+1;i++){
            parents[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op==0){
                union(a,b);
            }else{
                if(find(a)==find(b)){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa<pb){
            parents[pb] = pa;
        }else{
            parents[pa] = pb;
        }
    }

    public static int find(int a){
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }
}