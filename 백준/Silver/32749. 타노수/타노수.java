import java.util.*;
import java.io.*;

public class Main {
    static long result = -1L;
    static int N;
    static int T;
    static String origin;
    static ArrayList<String> candidates = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        origin = br.readLine();

        thanos(origin.length(),0,0);

        Collections.sort(candidates);
        System.out.println(candidates.get(candidates.size()-1));
    }

    public static void thanos(int length, int start, int depth){
        if(depth==T){
            String now = origin.substring(start, start+length);
            candidates.add(now);
            return;
        }

        //아직 덜 나눴다 ㄱ
        thanos(length/2, start, depth+1);
        thanos(length/2, start+length/2, depth+1);
    }
}