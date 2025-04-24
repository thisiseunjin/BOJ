import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int n, int[][] results) {
        
        int[][] info = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    info[i][j] = 0;
                }else{
                    info[i][j] = 101;
                }
            }
        }
        
        for(int i=0;i<results.length;i++){
            int winner = results[i][0];
            int looser = results[i][1];
            
            info[winner-1][looser-1] = 1;
            info[looser-1][winner-1] = -1;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(info[i][k]==1 && info[k][j]==1){
                        info[i][j] = 1;
                        info[j][i] = -1;
                    }
                }
            }
        }
        int result=0;
        for(int i=0;i<n;i++){
            boolean isPossible = true;
            for(int j=0;j<n;j++){
                if(info[i][j]==101){
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) result++;
        }
        
        
        return result;
    }
}