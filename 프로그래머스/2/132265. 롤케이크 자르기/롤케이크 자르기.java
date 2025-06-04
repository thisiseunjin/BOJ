import java.util.*;
import java.io.*;

class Solution {
    int result =0;
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    
    public int solution(int[] topping) {
        //1. 일단 map1에 모두 넣는다.
        for(int t : topping){
            map1.put(t, map1.getOrDefault(t,0)+1);
        }
    
        
        //2. map2에 넣는다
        for(int t : topping){
            int tCnt = map1.get(t);
            if(tCnt>1){
                map1.put(t, tCnt-1);
            }else{
                map1.remove(t);
            }
            
            map2.put(t, map2.getOrDefault(t,0)+1);
            
            if(map2.size()==map1.size()){
               result++;
            }

        }
        
        
        
        return result;
    }
}