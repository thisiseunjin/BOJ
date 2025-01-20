import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int S;
    static int[] nums;
    static int result=0;
    static int[] selected;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            comb(i, 0,0,0);
        }

        System.out.println(result);
        
    }

    static void comb(int size, int cnt, int start, int sum){
        if(cnt==size){
            if(sum==S) result++;
            return;
        }

        for(int i=start;i<N;i++){
            //넣고 간다
            comb(size, cnt+1, i+1, sum+nums[i]);
        }
    }
}