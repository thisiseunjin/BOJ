import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] nums;
    static int[] selected;
    static Set<String> set;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);


        comb(0,0);

        for(String str:set){
            st = new StringTokenizer(str);
            for(int i=0;i<M;i++){
                sb.append(Integer.parseInt(st.nextToken())).append(" ");
            }
            sb.append("\n");
        }
      
        System.out.println(sb);
    }

    public static void comb(int cnt, int start){
        if(cnt==M){
            StringBuilder res = new StringBuilder();
            for(int i=0;i<M;i++){
                res.append(selected[i]).append(" ");
            }

            set.add(res.toString());
            return;
        }

        for(int i=start;i<N;i++){
            selected[cnt] = nums[i];
            comb(cnt+1, i+1);
        }
    }
}