import java.util.*;

class Solution {
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    public int[] solution(String[] operations) {
        int[]  result = new int[2];
        
        for(String operation : operations){
            String[] op =  operation.split(" ");
            if("I".equals(op[0])){
                // 삽입
                minQ.add(Integer.parseInt(op[1]));
                maxQ.add(Integer.parseInt(op[1]));
            }else if("D".equals(op[0]) && "1".equals(op[1])&& !maxQ.isEmpty()){
                // 최댓값을 삭제
                int max = maxQ.poll();
                minQ.remove(Integer.valueOf(max));
            }else if("D".equals(op[0]) && "-1".equals(op[1])&& !minQ.isEmpty()){
                // 최소값을 삭제
                int min = minQ.poll();
                maxQ.remove(Integer.valueOf(min));
            }
        }
        
        result[0] = maxQ.isEmpty()?0:maxQ.peek();
        result[1] = minQ.isEmpty()?0:minQ.peek();
        
        return result;
    }
}