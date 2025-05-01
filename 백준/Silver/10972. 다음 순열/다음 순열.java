import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] origin;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        origin = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        //뒤에서 부터 탐색하면서 오른차 순이 깨지는 idx1을 확인한다.
        int idx1 = -1;
        int pre = origin[origin.length - 1];
        for (int i = origin.length - 2; i >= 0; i--) {
            if (origin[i] < pre) {
                idx1 = i;
                break;
            } else {
                pre = origin[i];
            }
        }

        if (idx1 == -1) {
            System.out.print("-1");
            System.exit(0);
        }

        int target = origin[idx1];
        int idx2 = -1;
        //다시 뒤에서 탐색하면서 idx1의 값보다 큰 첫번째 인덱스를 확인한다.
        for (int i = origin.length - 1; i >= 0; i--) {
            int n = origin[i];
            if (n > target) {
                idx2 = i;
                break;
            }
        }

        if (idx2 == -1) {
            System.out.print("-1");
            System.exit(0);
        }

//        System.out.printf("idx1= %d, idx2 = %d\n", idx1, idx2);
        swap(idx1, idx2);
        sorting(idx1);

        StringBuilder sb = new StringBuilder();
        for (int n : origin) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);


    }

    public static void swap(int idx1, int idx2) {
        int tmp = origin[idx1];
        origin[idx1] = origin[idx2];
        origin[idx2] = tmp;
    }

    public static void sorting(int idx1) {
        //a+1부터 끝까지 오름 차순 정렬
        int[] sub = Arrays.copyOfRange(origin, idx1 + 1, origin.length);
        Arrays.sort(sub);
        for (int i = 0; i < sub.length; i++) {
            origin[idx1 + i + 1] = sub[i];
        }
    }
}