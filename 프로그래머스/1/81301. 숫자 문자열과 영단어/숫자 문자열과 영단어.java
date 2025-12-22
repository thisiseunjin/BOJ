import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int solution(String s) {
        init();
        
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //1. 숫자이다?
            if(Character.isDigit(ch)){
                if(word.length()>0){
                    sb.append(map.get(word.toString()));
                    word.setLength(0);
                }
                sb.append(ch);
            }else{
                //만약 ch를 append하기 전 문자열이 완벽하다면?
                if(map.get(word.toString())!=null){
                    sb.append(map.get(word.toString()));
                    word.setLength(0);
                }
                word.append(ch);
            }
            
        }
        if(word.length()>0){
            sb.append(map.get(word.toString()));
        }
        return Integer.parseInt(sb.toString());
        
    }
    public void init(){
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two",2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight",8);
        map.put("nine", 9);
    }
}