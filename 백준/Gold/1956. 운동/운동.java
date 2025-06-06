import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static int E;
    static int[][] adj;
    static int[][] dp;
    static int result = (int)1e9;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        adj = new int[V+1][V+1];
        dp = new int[V+1][V+1];
        for(int i=0;i<V+1;i++){
            Arrays.fill(adj[i], (int)1e9);
            Arrays.fill(dp[i], (int) 1e9);
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            adj[v1][v2] = a;
        }

        floydWarshall();

        for(int i=1;i<V+1;i++){
            result = Math.min(result, adj[i][i]);
        }
        System.out.println(result==(int)1e9?-1:result);
    }

    public static void floydWarshall(){
        //플로이드와샬 진행
        for(int k=1;k<V+1;k++){
            for(int i=1;i<V+1;i++){
                for(int j=1;j<V+1;j++){
                    // if(i==j) continue;
                    if(adj[i][k]==(int)1e9 || adj[k][j]==(int)1e9) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }
        
    } 
}