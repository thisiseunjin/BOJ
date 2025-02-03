using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] arr) {
        List<int> list = new List<int>();
        for(int i=0;i<arr.Length;i++){
            int n = arr[i];
            for(int j=0;j<n;j++){
                list.Add(n);
            }
        }
        return list.ToArray();
    }
}