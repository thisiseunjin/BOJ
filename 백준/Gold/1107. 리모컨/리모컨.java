import java.util.*;
import java.io.*;

public class Main {
    static int target;
    static String N;
    static int M;
    static boolean[] isPossible = new boolean[10];
    static int result = (int)1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N =br.readLine();
        target = Integer.parseInt(N);
        M = Integer.parseInt(br.readLine());
        Arrays.fill(isPossible, true);

        if(M>0){
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int num = Integer.parseInt(st.nextToken());
                isPossible[num] = false;
            }
        }

        if(Integer.parseInt(N)==100){
            System.out.print("0");
            System.exit(0);
        }

        result = Math.abs(target-100);
        search2(0,"");

        System.out.print(result);
    }

    public static void search2(int depth, String str){
        if(!str.isEmpty()){
            int num = Integer.parseInt(str);
            int press = Math.abs(target-num)+str.length();
            result = Math.min(result, press);
        }

        if(depth>N.length()+1) return;

        for(int i=0;i<10;i++){
            if(isPossible[i]){
                search2(depth+1, str+i);
            }
        }
    }

    
}