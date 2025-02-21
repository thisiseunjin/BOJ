import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            int value = numbers[i];
            int idx = i;
            
            while(!stack.isEmpty()){
                int[] min = stack.peek();
                if(min[0]>=value) break;
                
                result[min[1]] = value;
                stack.pop();
            }
            
            
            
            stack.push(new int[]{numbers[i],i});
        }
        
        
        return result;
    }
}