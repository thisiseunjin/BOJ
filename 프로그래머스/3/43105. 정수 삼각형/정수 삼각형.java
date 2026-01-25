import java.util.*;
import java.io.*;

class Solution {
    int h=0;
    int max = 0;
    public int solution(int[][] triangle) {
        h = triangle.length;
        System.out.println(h);
        
        int[][] dp = new int[h][h];
        //dp[0][0] = triangle[0][0];  //꼭대기 값 채워넣기
            
//         for(int i=1;i<h;i++){   //2층부터 시작할것임
            
//             for(int j=0;j<i;j++){   //층수 개수만큼 반복작업 진행
//                 //내 입장에서 바로 위 아니면 왼쪽거 더해서 내려옴
                
//             }
//         }
        
        //아래에서 부터 올라가볼게~!
        for(int i=0;i<h;i++){
            dp[h-1][i] = triangle[h-1][i];
        }
        

        //올라가본다
        for(int i=h-2;i>=0;i--){
            //아래 층 부터 시작
            for(int j=0;j<=i;j++){
                //내 바로 아래 혹은 아래+1번째
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
            
//         for(int i=0;i<h;i++){
//             System.out.println(Arrays.toString(dp[i]));
//         }
        
        return dp[0][0];
    }
}