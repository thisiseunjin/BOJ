import java.util.*;
import java.io.*;

class Solution {
    PriorityQueue<Process> q = new PriorityQueue<>();
    boolean[] isSelected;
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        isSelected = new boolean[n];
        
        int time=0;
        int cnt=0;
        int totalTime =0;
        while(cnt<n){
            //시간에 들어온 요청이 있는지 확인~!
            
            for(int i=0;i<n;i++){
                if(isSelected[i]) continue;
                if(jobs[i][0]>time) continue;
                isSelected[i] = true;
                q.add(new Process(jobs[i][0], jobs[i][1], i));
            }
           
            if(q.isEmpty()){
                time++;
                continue;
            }
            
            Process cur = q.poll();
            
            //이 작업이 끝나는 시간?
            int endTime = time+cur.adj;
            int returnTime = endTime - cur.time;
            
            time = endTime;
            totalTime += returnTime;
            cnt++;
        }
        
        return totalTime/n;
    }
    
    class Process implements Comparable<Process>{
        int adj;
        int time;
        int num;
        
        public Process(int time,int adj, int num){
            this.adj = adj;
            this.time = time;
            this.num = num;
        }
        
        public int compareTo(Process p){
           
            if(this.adj != p.adj){
                return this.adj-p.adj;
            }
            
            if(this.time!=p.time){
                return this.time-p.time;
            }

            return this.num-p.num;
        }
        
        public String toString(){
            return "time = "+this.time+", adj = "+this.adj+", num = "+this.num;
        }
    }
    
    public int calc(int time, Process p){
        //반환 시간 계산
        //요청 시간 - 반환 시간
        return time-p.time;
    }
}