import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        //System.out.println("대문자 = "+(int)'A'+" ~ "+(int)'Z');
         //System.out.println("대문자 = "+(int)'a'+" ~ "+(int)'z');
        for(int i=0;i<s.length();i++){
            int x = (int)s.charAt(i);
            //case1: 공백일 경우 -> 그냥 공백
            if(s.charAt(i)==' '){
                sb.append(" ");
            }
            //case2: 대문자일 경우
            else if(x >=65 && x <=90){
                x+=n;
                if(x>90){
                    x-=26;
                }
                sb.append((char)x);
            }
            //case3: 소문자일 경우
            else{
                x+=n;
                if(x>122){
                    x-=26;
                }
                sb.append((char)x);
            }
            
            //System.out.printf("지금의 나 = %c, 새로운 나 = %c\n", s.charAt(i), (char)x);
        }
        
        return sb.toString();
    }
}