import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        for(char ch : number.toCharArray()){
            
            if(cnt == k || stack.isEmpty()){   // 더이상 뺄 수 없음.
                stack.add(ch);
                continue;
            }
            
            // 만약 peek가 나보다 작다? 빼버릴것임
            while(!stack.isEmpty() && cnt<k){
                char peek = stack.peek();
                
                if(peek<ch){
                    stack.pop();
                    cnt++;
                }else{
                    break;
                }
            }
            
            stack.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        
        return sb.toString().substring(0, number.length()-k);
    }
}