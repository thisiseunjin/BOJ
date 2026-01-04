import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        
        for(int i=0;i<n;i++){
            int merge = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(merge);
            
            if(binary.length()<n){
                binary = "0".repeat(n-binary.length())+binary;
            }
            
            //System.out.println(binary);
            
            StringBuilder sb = new StringBuilder();
            for(int j=0 ; j<n;j++){
                sb.append(binary.charAt(j)=='1'?"#":" ");
            }
            
            result[i] = sb.toString();
        }
        
        return result;
    }
}