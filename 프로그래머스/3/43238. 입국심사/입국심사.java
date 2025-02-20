import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left =0L;
        long right = times[times.length-1]*(long)n;
        long result = 0L;
        while(left<=right){
            long mid = (left+right)/2;
            
            //mid라는 시간 내에 심사를 다 처리할 수 있는가?
            long count=0;
            for(int i=0;i<times.length;i++){
                count+=(mid/times[i]);
                if(count>n) break;
            }
            
            if(count<n){
                left = mid+1;
            }
            
            else{
                right = mid-1;
                result = mid;
            }
        }
        
        return result;
    }
}