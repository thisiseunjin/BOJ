import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                idx = 0;
                sb.append(" ");
                continue;
            }
            if(idx%2==0){
                //짝수일 경우 대문자
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                 sb.append(Character.toLowerCase(s.charAt(i)));
            }
            idx++;
        }
        
        return sb.toString();
    }
}