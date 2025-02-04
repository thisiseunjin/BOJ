using System;

public class Solution {
    int result=0;
    bool[] isSelected;
    int N = 0;
    public int solution(int n, int[,] computers) {
        N = n;
        isSelected = new bool[N];
        
        for(int i=0;i<N;i++){
            if(isSelected[i]) continue;
            result++;
            isSelected[i] = true;
            dfs(i, computers);
        }
        
        return result;
    }
    
    void dfs(int v, int[,] status){
        //지금 내가 들어온 정점에 대하여 방문 체크 진행
        for(int i=0;i<N;i++){
            if(i==v) continue;
            //갈 수 없는 곳이면 못간다.
            if(status[v,i]==0) continue;
            
            //이미 가본 곳이면 안간다.
            if(isSelected[i]) continue;
            
            isSelected[i]=true;
            dfs(i, status);
        }
        
        
    }
}