import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        long res = (long)Math.sqrt(n);
        
        if(Math.sqrt(n)%1==0){
            return (long)Math.pow(res+1,2); 
        }else{
            return -1;
        }
    }
}