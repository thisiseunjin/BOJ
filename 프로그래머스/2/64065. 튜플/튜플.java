import java.util.*;
import java.io.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<int[]> list = new ArrayList<>();
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s,"{},");
        while(st.hasMoreTokens()){
            int key = Integer.parseInt(st.nextToken());
            map.put(key,map.getOrDefault(key, 0)+1);
            //System.out.println("key = "+key+", value = "+map.get(key));
        }
        
        for(int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }
        
        Collections.sort(list, 
            (a,b) ->{
                         if(a[1]==b[1]) return a[0]-b[0];
                else return b[1]-a[1];
        });
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i)[0];
        }
        return result;
    }
}