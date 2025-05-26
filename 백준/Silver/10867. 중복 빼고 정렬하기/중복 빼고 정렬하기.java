import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Set<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for(Object num:set.toArray()){
            sb.append(num).append(" ");
        }

        System.out.print(sb);

      
    }

}