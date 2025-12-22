import java.util.*;
import java.io.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String s) {
        int[] res = new int[s.length()];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.get(ch)==null){
                res[i] = -1;
                map.put(ch, i);
                continue;
            }
            
            //나랑 얼마 차이남?
            int diff = i-map.get(ch);
            res[i] = diff;
            map.put(ch, i);
        }
        
        return res;
    }
}