import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(Long.toString(n));
        sb.reverse();
        
        int[] result = new int[sb.length()];
        for(int i=0;i<sb.length();i++){
            int tmp = sb.charAt(i)-'0';
            result[i] = tmp;
        }
        
        return result;
    }
}