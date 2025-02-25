import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> totalTime= new TreeMap<>();
    StringTokenizer st;
    int[] result;
    
    public int[] solution(int[] fees, String[] records) {
        for(String info : records){
            st = new StringTokenizer(info);
            int time = convertToMin(st.nextToken());
            String car = st.nextToken();
            String status = st.nextToken();
            
            if(status.equals("IN")){
                map.put(car, time);
            }else{
                int startTime = map.get(car);
                int t = time - startTime;
                totalTime.put(car, totalTime.getOrDefault(car,0)+t);
                map.remove(car);
            } 
        }
        
        for(String key : map.keySet()){
            int startTime = map.get(key);
            totalTime.put(key, totalTime.getOrDefault(key,0)+(1439-startTime));
        }
        return convertToArr(fees);
    }
    
    public int[] convertToArr(int[] fees){
        int[] result = new int[totalTime.size()];
        int idx =0;
        for(String key : totalTime.keySet()){
            int time = totalTime.get(key);
            System.out.println(key+"번의 차량은 "+time+"분 체류함.");
            result[idx++] = calc(time, fees);
        }
        
        return result;
    }

    
    public int convertToMin(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return (h*60)+m;
    }
    
    public int calc(int min, int[] fees){
        //fees[0] : 기본 시간
        //fees[1] : 기본 요금
        //fees[2] : 단위 시간
        //fees[3] : 단위 요금
        
        if(min<=fees[0]) return fees[1];
        int extra = (int) Math.ceil((double)(min - fees[0]) / fees[2]);
        
        return fees[1] + extra * fees[3];
    }
}