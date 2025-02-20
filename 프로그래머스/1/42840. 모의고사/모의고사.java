import java.util.*;
class Solution {
    int[] s1 = {1,2,3,4,5};
    int[] s2 = {2,1,2,3,2,4,2,5};
    int[] s3 = {3,3,1,1,2,2,4,4,5,5};
    int[] scores = new int[3];
    int maxScore=0;
    public int[] solution(int[] answers) {
        int idx1=0;
        int idx2=0;
        int idx3=0;
        
        for(int i=0;i<answers.length;i++){
            
            //각각의 수포자가 어떤 답을 찍는가?
            int a1 = s1[idx1++%(s1.length)];
            int a2 = s2[idx2++%(s2.length)];
            int a3 = s3[idx3++%(s3.length)];
            
            int a = answers[i];
            if(a1==a) scores[0]++;
            if(a2==a) scores[1]++;
            if(a3==a) scores[2]++;
            
            maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(scores[i]<maxScore) continue;
            list.add(i+1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}