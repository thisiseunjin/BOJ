import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] nums;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;

            nums = new int[N];
            selected = new int[6];

            for(int i=0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            comb(0,0);

            sb.append("\n");
        }

        System.out.println(sb);
    
    }

    static void comb(int cnt, int start){
        if(cnt==6){
            for(int i=0;i<6;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            selected[cnt] = nums[i];
            comb(cnt+1, i+1);
        }
    }
}