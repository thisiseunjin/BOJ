import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int result=0;
        int n = arr.length;
        
        if(n==1) return arr[0];
        
        int r = gcd(arr[0], arr[1]);
        result = (arr[0]*arr[1])/r;
        
        if(n>2){
            for(int i=2;i<n;i++){
                r = gcd(result, arr[i]);
                result = (result*arr[i])/r;
            }
        }
        return result;
    }
    
    int gcd(int a, int b){
        int r = a%b;
        if(r==0) return b;
        return gcd(b,r);
    }
}