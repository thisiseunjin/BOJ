import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : numlist){
            list.add(num);
        }

        Collections.sort(list, (o1, o2) -> {
            int dist1 = Math.abs(o1-n);
            int dist2 = Math.abs(o2-n);
            
            if(dist1 == dist2) return o2-o1;
            return dist1-dist2;
        });
        
        for(int i=0;i<list.size();i++){
            numlist[i] = list.get(i);
        }
        
        return numlist;
    }
}