import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main
{
    static int N;
    static int M;

    static int[] selected;
    static StringBuilder sb;
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];

        comb(1, 0);

        System.out.println(sb);
    }

    static void comb(int start, int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=N;i++){
            selected[cnt] = i;
            comb(i, cnt+1);
        }
    }
}