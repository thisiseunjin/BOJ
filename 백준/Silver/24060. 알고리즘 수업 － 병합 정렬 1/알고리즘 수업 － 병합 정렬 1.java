import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] origin;
    static int N;
    static int K;
    static int count = 0;
    static int[] tmp;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        origin = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(origin, 0, N - 1);

        System.out.println(result);


    }

    public static void mergeSort(int[] arr, int p, int r) {
        if (count > K) return;
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p,q,r);
        }

    }

    public static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = arr[i++];
        }

        while (j <= r) {
            tmp[t++] = arr[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            count++;

            if (count == K) {
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}