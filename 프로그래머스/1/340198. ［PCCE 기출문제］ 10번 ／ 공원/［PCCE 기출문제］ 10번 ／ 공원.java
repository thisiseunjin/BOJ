import java.util.*;
import java.io.*;
class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    int n=0;
    int m=0;
    int result = -1;
    
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        n = park.length;
        m = park[0].length;
        
        Arrays.sort(mats);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=mats.length-1 ; k>=0 ;k--){
                    int size = mats[k];
                   if(isPossible(i,j,size, park)){
                        result = Math.max(result, size);
                        break;
                   } 
                }
            }
        }
        
        return result;
    }
    
    public boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<=n-1 && y<=m-1;
    }
    
    public boolean isPossible(int x, int y, int size, String[][] park){
        //해당 위치에 크키가 size인 돗자리를 놓을 수 있는가?
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(!inRange(i,j)) return false;
                if(park[i][j].equals("-1")) continue;
                return false;
            }
        }
        
        return true;
    }
}