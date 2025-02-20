import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] sizes) {
        int result=0;
        int maxH = 0;
        int maxL = 0;
        
        for(int i=0;i<sizes.length;i++){
            int l = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            maxH = Math.max(maxH, h);
            maxL = Math.max(maxL, l);
        }
        
        return maxH*maxL;
        
    }
}