import java.util.*;
import java.io.*;

public class Main {
    static int H;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] res = convert(H,M);

        System.out.printf("%d %d", res[0], res[1]);
    }

    static int[] convert(int hour, int min){
        //내가 알림을 맞춰야할 시간은? 45분 전
        if(hour==0 && min-45<0){
            hour = 24;
        }
        //전체를 분으로 생각하기
        int totalMin = hour*60 + min;
        totalMin-=45;

        int resultH = totalMin/60;
        totalMin-=(resultH*60);

        return new int[]{resultH, totalMin};
    }
}