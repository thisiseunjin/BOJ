import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] info;
    static int N;
    static StringBuilder result = new StringBuilder();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(info[i], '.');
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            info[root][0] = left;
            info[root][1] = right;
        }
        preOrder(0);
        result.append("\n");
        inOrder(0);
        result.append("\n");
        postOrder(0);
        System.out.println(result);
    }

    public static void preOrder(int v) {
        result.append((char) (v + 'A'));
        for (int i = 0; i < 2; i++) {
            int next = info[v][i];
            if (!isAlphabet(next)) continue;
            preOrder(next);
        }
    }

    public static void inOrder(int v) {
        int left = info[v][0];
        int right = info[v][1];

        if (isAlphabet(left)) {
            inOrder(left);
        }
        result.append((char) (v + 'A'));
        if (isAlphabet(right)) {
            inOrder(right);
        }
    }

    public static void postOrder(int v){
        int left = info[v][0];
        int right = info[v][1];

        if(isAlphabet(left)){
            postOrder(left);
        }
        if(isAlphabet(right)){
            postOrder(right);
        }

        result.append((char) (v + 'A'));
    }


    public static boolean isAlphabet(int n) {
        return n >= 0 && n <= 25;
    }
}