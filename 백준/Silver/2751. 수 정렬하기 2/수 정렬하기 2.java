import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int N;
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            sb.append(q.poll()).append("\n");
        }
        System.out.print(sb);
    }
}