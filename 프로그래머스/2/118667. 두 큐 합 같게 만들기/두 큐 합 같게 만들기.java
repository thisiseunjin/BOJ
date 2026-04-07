import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long q1Sum = 0L;
        for(int i : queue1){
            q1.add(i);
            q1Sum+=i;
        }
        
        long q2Sum = 0L;
        for(int i : queue2){
            q2.add(i);
            q2Sum+=i;
        }
        
        int maxCnt = (q1.size() + q2.size())*2+1;
        int cnt=0;
        boolean isPossible = true;
        
        while(true){
            if(cnt>maxCnt){
                isPossible = false;
                break;
            }
            
            if(q1Sum == q2Sum){
                break;
            }
            
            // q1에서 빼서 q2로 넣는 경우? => 지금 내 q1Sum이 q2Sum보다 크다.
            if(q1Sum>q2Sum){
                int tmp = q1.poll();
                q2.add(tmp);
                q1Sum-=tmp;
                q2Sum+=tmp;
            }else{
                int tmp = q2.poll();
                q1.add(tmp);
                q1Sum+=tmp;
                q2Sum-=tmp;
            }
            cnt++;
        }
        
        return isPossible?cnt : -1;
    }
}