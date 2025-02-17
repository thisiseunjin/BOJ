import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (q.size()>=2) {
            int n1 = q.poll();
            if (q.size() == 1) {
                break;
            }
            int n2 = q.poll();
            q.add(n2);
        }

        System.out.println(q.peek());
    }


}