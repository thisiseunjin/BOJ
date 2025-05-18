import java.util.*;
import java.io.*;

public class Main {
    static Info[] infos;
    static int N; //전체 물건의 개수
    static int K; //준서가 버틸 수 있는 무게
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //물건의 개수
        K = Integer.parseInt(st.nextToken()); //견딜 수 있음

        infos = new Info[N+1];
        dp = new int[N+1][K+1];

        infos[0] = new Info(0,0);
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            infos[i] = new Info(w,v);
        }

        for(int i=1;i<N+1;i++){
            for(int w = 1;w<K+1;w++){
                dp[i][w] = -1;
            }
        }



        for(int k=1;k<K+1;k++){
            for(int i=1;i<N+1;i++){
                //지금 내 물건을 k에 넣을 수 없다면? 못넣는다
                int w = infos[i].w;
                int v = infos[i].v;

                if(w>k){
                    dp[i][k] = dp[i-1][k];
                }else{
                    //물건을 넣는게 최선인가?
                    dp[i][k] = Math.max(dp[i-1][k], v+dp[i-1][k-w]);
                }
            }
        }
        
        System.out.print(dp[N][K]);
    }

    static class Info{
        int w; //무게
        int v; //가치
        public Info(int w, int v){
            this.w = w;
            this.v = v;
        }
    }

    public static void print(){
        for(int i=0;i<N+1;i++){
            for(int j=0;j<K+1;j++){
                System.out.printf("%d\t", dp[i][j]);
            }
            System.out.println();
        }
    }
}