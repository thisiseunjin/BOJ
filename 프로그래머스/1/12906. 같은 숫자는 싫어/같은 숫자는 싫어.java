import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        boolean[] isSelected = new boolean[arr.length];
        int pre = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            int cur = arr[i];
            if(cur==pre) continue;
            pre = cur;
            list.add(cur);
        }
        
        int[] result = new int[list.size()];
        int idx=0;
        for(int n:list){
            result[idx++] = n;
        }
        
        return result;
    }
}