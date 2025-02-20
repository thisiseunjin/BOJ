import java.util.*;
import java.io.*;
class Solution {
    int[] selected = new int[5];
    Set<Integer> set = new HashSet<Integer>();
    int result=0;
    public int solution(int n, int[][] q, int[] ans) {
        
        combination(n,0,1,q,ans);
        
        return result;
    }
    
    public void combination(int n, int cnt, int start, int[][] q, int[] ans){
        if(cnt==5){
            
            if(isPossible(q, ans)) {
                result++;
            }
            return;
        }
        
        for(int i=start;i<=n;i++){
            selected[cnt] = i;
            set.add(i);
            combination(n, cnt+1, i+1, q,ans);
            set.remove(i);
        }
    }
    
    public boolean isPossible(int[][] q, int[] ans){
        for(int i=0;i<ans.length;i++){

            int cnt=0;
            for(int j=0;j<5;j++){
                if(set.contains(q[i][j]))cnt++;
                
                if(cnt>ans[i]) return false;
            }
            
            if(cnt!=ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}