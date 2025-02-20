import java.util.*;
import java.io.*;

class Solution {
    String[] nums;
    boolean[] isSelelcted;
    int count=0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        nums = new String[numbers.length()];
        isSelelcted = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++){
            nums[i] = Character.toString(numbers.charAt(i));
        }
        
        permutation(new StringBuilder());
        
        for(int i:set){
            System.out.println(i);
            if(isDecimal(i)) count++;
        }
        
        return count;
    }
    
    public void permutation(StringBuilder sb){
        if(sb.length()>0){
            int n = Integer.parseInt(sb.toString());
            set.add(n);
        }
        
        if(sb.length()==nums.length){
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(isSelelcted[i]) continue;
            
            isSelelcted[i] = true;
            permutation(sb.append(nums[i]));
            isSelelcted[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public boolean isDecimal(int num){
        
        if(num==0||num==1) return false;
        if(num==2) return true;
        
        for(int i=2;i<(num/2)+1;i++){
            if(num%i ==0) return false;
        }
        
        return true;
    }
}