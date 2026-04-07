import java.util.*;


class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int cnt=0;
    public int solution(int[] ingredient) {
        for(int num : ingredient){
            list.add(num);
            
            if(list.size()>=4){
                int size = list.size();
                if(list.get(size-4) == 1 && list.get(size-3)==2 && list.get(size-2)==3 && list.get(size-1)==1){
                    for(int i=1;i<=4;i++){
                        list.remove(size-i);
                    }
                    cnt++;
                }
                
            }
        }    
        
        return cnt;
    }
}