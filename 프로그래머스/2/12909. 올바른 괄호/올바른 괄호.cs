using System;
using System.Collections;

public class Solution {
    Stack stack = new Stack();   
    public bool solution(string s) {
        for(int i=0;i<s.Length;i++){
            char ch = s[i];
            
            if(ch=='('){
                stack.Push(ch);
                continue;
            }
            
            if(stack.Count==0){
                return false;
            }
            
            stack.Pop();
            
        }
        
        return stack.Count==0;
    }
}