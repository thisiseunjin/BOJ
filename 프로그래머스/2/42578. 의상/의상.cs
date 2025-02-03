using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string[,] clothes) {
        Dictionary<string, int> map = new Dictionary<string, int>();
        
        for(int i=0;i<clothes.GetLength(0);i++){
            string type = clothes[i, 1];
            if(!map.ContainsKey(type)){
                map[type]=1;
                continue;
            }
            map[type]++;   
        }
        
        int result =1;
        foreach(var cnt in map.Values){
            result*=(cnt+1);
        }
        
        // Console.WriteLine(result);
        return result-1;
    }
}