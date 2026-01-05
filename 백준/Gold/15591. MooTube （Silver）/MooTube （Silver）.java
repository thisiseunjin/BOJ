import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,Q;
    static ArrayList<int[]>[] info;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        info = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            info[i] = new ArrayList<int[]>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            info[v1].add(new int[]{v2, adj});
            info[v2].add(new int[]{v1, adj});
        }

        for(int i=0 ; i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(bfs(v,k));
        }
    }

    public static int bfs(int v, int k){
        boolean[] isSelected = new boolean[N+1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int cnt=0;

        isSelected[v] = true;
        q.add(new int[]{v, (int)1e9});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int curPoint = tmp[0];
            int adj = tmp[1];

            if(adj>=k){
                cnt++;
            }

            //내가 갈 수 있는 곳을 탐색한다.
            for(int[] next : info[curPoint]){
                int nextPoint = next[0];
                int nextAdj = next[1];

                if(isSelected[nextPoint]) continue;
                
                isSelected[nextPoint] = true;
                q.add(new int[]{nextPoint, Math.min(nextAdj, adj)});
            }
        }

        return cnt-1;
    }
}