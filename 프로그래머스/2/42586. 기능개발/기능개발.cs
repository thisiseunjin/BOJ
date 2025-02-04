using System;
using System.Collections;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<int> result = new List<int>();
        
        int time=0;
        int idx=0;
        
        int cnt=0;
        while(true){
            if(idx==progresses.Length){
                if(cnt>0) result.Add(cnt);
                break;
            }
            
            //지금 내가 배포를 할 수 있는 상황인가?
            int progress = progresses[idx];
            int speed = speeds[idx];
            
            //지금 나의 진행 상황을 계산한다.
            int curProgress = progress + (speed*time);
            
            //만약 내가 배포할 수 없는 상황이라면?
            if(curProgress<100){
                
                if(cnt>0){
                    result.Add(cnt);
                    cnt=0;
                }
                
                time++;
                continue;
            }
            
            cnt++;
            idx++;
        }
        
        return result.ToArray();
    }
}