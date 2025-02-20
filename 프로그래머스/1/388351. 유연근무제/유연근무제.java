import java.util.*;
import java.io.*;

class Solution {
    int result=0;
    int N;
    boolean[] isPossible;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        N = schedules.length;   //직원의 수
        isPossible = new boolean[N];
        Arrays.fill(isPossible, true);
        
        startday-=1;
        
        for(int i=0;i<7;i++){
            if(startday%7==5 || startday%7==6){
                startday++;
                continue;   //주말은 이벤트에 포함되지 않으므로 넘어간다.
            }
            
            //직원들이 제시간에 도착 했는지 확인한다.
            for(int p=0;p<N;p++){
                if(!isPossible[p]) continue;
                if(isSuccess(timelogs[p][i], schedules[p])) {
                    continue;
                }
                isPossible[p] = false;
            }
            startday++;
        }
        
        
        return getCount();
    }
    
    public int getCount(){
        int count=0;
        for(int i=0;i<N;i++){
            if(!isPossible[i]) continue;
            count++;
        }
        
        return count;
    }
    
    public boolean isSuccess(int time, int goal){
        // System.out.println("목표: "+goal+", 도착: "+time);
        //도착 시간 내에 도착을 했는가?
        int tH = time/100;
        int tM = (time-(tH*100));
        
        int gH = goal/100;
        int gM = (goal-(gH*100));
        
        // System.out.println(tH+"시 "+tM+"분이 도착 시간임");
        // System.out.println(gH+"시 "+gM+"분이 목표 시간임");
        
        //만약 내가 도착한 시간이 목표 시간보다 빠르다면?
        if(tH<gH) return true;
        tM += (tH-gH)*60;
        
        if(tM-gM<=10) {
            // System.out.println(tM-gM+"분 안에 도착 했음!");
            return true;
        }
        return false;
    }
}