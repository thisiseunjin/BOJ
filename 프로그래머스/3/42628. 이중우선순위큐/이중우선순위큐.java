import java.io.*;
import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    StringTokenizer st;
    
    public int[] solution(String[] operations) {
        for(String operation:operations){
            st = new StringTokenizer(operation);
            char op = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            
            if(op=='I'){
                list.add(n);
                continue;
            }
            
            if(list.size()==0){
                continue;
            }
            Collections.sort(list);
            if(n==1){
                //최댓값을 삭제한다.
                list.remove(list.size()-1);
            }else{
                 list.remove(0);
            }
            
            
        }
        
        if(list.size()==0){
            return new int[]{0,0};
        }else{
             Collections.sort(list);
            return new int[]{list.get(list.size()-1), list.get(0)};
        }
    }
}