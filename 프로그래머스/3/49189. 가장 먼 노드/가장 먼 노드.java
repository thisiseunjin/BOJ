import java.util.*;
import java.io.*;
class Solution {
    //1번 노드에서 가장 멀리 떨어진 노드의 개수 찾는당 ㅇㅅㅇ
    int max=0;
    boolean[] isSelected;
    int result=0;
    ArrayList<Integer>[] list;
    int[] dp;
    public int solution(int n, int[][] edge) {
        isSelected = new boolean[n+1];   //해당 정점을 방문 했는지 저장할것임.
        dp = new int[n+1];
        Arrays.fill(dp, (int)1e9);
        
        list = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length;i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        bfs();
        System.out.println(Arrays.toString(dp));
        return result;
    } 
    
    public void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        isSelected[1] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int v = cur[0];
            int depth = cur[1];
            
            dp[v] = Math.min(dp[v], depth);
            if(max==dp[v]) result++;
            if(max<dp[v]) {
                max = dp[v];
                result=1;
            }
            //갈 수 있는 곳을 간다.
            for(int i=0;i<list[v].size();i++){
                int next = list[v].get(i);
                if(isSelected[next]) continue;
                isSelected[next] = true;
                q.add(new int[]{next, depth+1});
            }
        }
    }
}