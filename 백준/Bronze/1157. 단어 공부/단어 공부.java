import java.util.*;
import java.io.*;

public class Main {
    static int maxCnt=0;
    static int result=0;
    static char maxCh;
    static Map<Character, Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();

        String str = br.readLine().toUpperCase();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char key : map.keySet()){
            int cnt = map.get(key);

            if(cnt<maxCnt){
                continue;
            }

            if(cnt == maxCnt){
                result++;
                continue;
            }

            maxCnt=cnt;
            maxCh = key;
            result=0;
        }

        System.out.println(result>0?"?":maxCh);
        
    }
}