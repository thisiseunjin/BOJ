using System;
using System.Collections.Generic;

class Solution {
    int N=0;
    int M=0;
    int result = -1;
    bool[, ]isSelected;
    public int solution(int[,] maps) {
        N = maps.GetLength(0);
        M = maps.GetLength(1);
        
        isSelected = new bool[N,M];
        
        bfs(maps);
        return result;
    }
    
    void bfs(int[,]map){
        //(0,0) -> (N-1, M-1)까지
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        
        Queue<(int x, int y, int depth)>q = new Queue<(int x, int y, int depth)>();
        isSelected[0,0] = true;
        q.Enqueue((0,0,1));
        
        while(q.Count>0){
            (int x, int y, int depth) cur = q.Dequeue();
            if(cur.x == N-1 && cur.y==M-1){
                result = cur.depth;
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                if(!inRange(nx, ny)) continue;
                if(map[nx,ny]==0) continue; 
                if(isSelected[nx,ny]) continue;
                
                isSelected[nx, ny] = true;
                q.Enqueue((nx,ny, cur.depth+1));
            }
        }
    }
    
    bool inRange(int x, int y){
        if(x<0 || y<0 || x>N-1 || y>M-1) return false;
        return true;
    }
}