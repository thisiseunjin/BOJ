import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static int cnt = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int left = 1_000 - N;
        while (true) {
            if (left <= 4) {
                cnt += left;
                break;
            }

            if (left >= 500) {
                int minus = left / 500;
                cnt += minus;
                left -= (minus * 500);
                continue;
            }

            if (left >= 100) {
                int minus = left / 100;
                cnt += minus;
                left -= (minus * 100);
                continue;
            }

            if(left>=50){
                int minus = left / 50;
                cnt += minus;
                left -= (minus * 50);
                continue;
            }
            if(left>=10){
                int minus = left / 10;
                cnt += minus;
                left -= (minus * 10);
                continue;
            }

            if(left>=5){
                int minus = left / 5;
                cnt += minus;
                left -= (minus * 5);
            }
        }

        System.out.println(cnt);
    }
}