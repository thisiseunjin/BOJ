import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        for(int i=1;i<food.length;i++){
            left.append(String.valueOf(i).repeat(food[i]/2));
        }
        res.append(left).append(0).append(left.reverse());
        
        
        return res.toString();
    }
}