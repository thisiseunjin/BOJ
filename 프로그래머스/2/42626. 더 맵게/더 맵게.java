import java.util.*;
class Solution {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int cnt=0;
    public int solution(int[] scoville, int K) {
        int n = scoville.length;
        for(int i=0;i<n;i++){
            q.add(scoville[i]);
        }
        
        while(!q.isEmpty()){
            int s1 = q.poll();
            if(s1>=K){
                break;
            }
            
            if(q.size()==0){
                cnt=-1;
                break;
            }
            
            int s2 = q.poll();
            int s3 = s1+(s2*2);
            q.add(s3);
            cnt++;
        }
        
        return cnt;
    }
}