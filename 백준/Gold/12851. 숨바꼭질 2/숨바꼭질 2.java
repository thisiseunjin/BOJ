import java.util.*;
import java.io.*;

public class Main {
    static int minCnt=0;
    static int minTime=(int)1e9;
    static int N;
    static int K;
    static boolean[] isVisited = new boolean[100_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.printf("%d\n%d", minTime, minCnt);
    }
    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N,K,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int n = cur[0];
            int k = cur[1];
            int time = cur[2];

            isVisited[n] = true;

            //end condition
            if(n==k){
                //둘이 만났다!
                if(time>minTime){
                    continue;
                }else if(time==minTime){
                    minCnt++;
                    continue;
                }else{
                    minTime=time;
                    minCnt=1;
                }
            }

            //go!
            if(n+1<=100_000 && !isVisited[n+1]){
                q.add(new int[]{n+1, k, time+1});
            }

            if(n-1 >=0 && !isVisited[n-1]){
                q.add(new int[]{n-1, k, time+1});    
            }

            if(n*2<=100_000 && !isVisited[n*2]){
                q.add(new int[]{n*2, k, time+1});
            }
        }
        
    }
}