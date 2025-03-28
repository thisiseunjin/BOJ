import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int Q;
    static ArrayDeque<Integer> back = new ArrayDeque<>();
    static ArrayDeque<Integer> front = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'B') back();
            else if (op == 'F') front();
            else if (op == 'C') compress();
            else {
                int page = Integer.parseInt(st.nextToken());
                access(page);
            }
        }
        print();
    }


    public static void access(int n) {
        //1. 앞으로 가기 공간에 저장된 페이지 모두 삭제
        front.clear();

        int pre = current;
        //현재 페이지가 처음이 아니면? 뒤로 가기 공간에 추가한다.
        if (pre > 0) back.addFirst(pre);
        current = n;

/*        System.out.printf("%d번 페이지 방문\n", n);
        System.out.println("Back: " + back.toString());
        System.out.println("Front: " + front.toString());*/
    }

    public static void back() {
        //1. 뒤로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행
        if (back.isEmpty() || current == 0) return;
        //2. 현재 보고 있던 웹페이지를 앞으로 가기 공간에 저장
        front.addFirst(current);
        //3. 뒤로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 뒤로 가기 공간에서 삭제
        current = back.pollFirst();
    }

    public static void front() {
        //앞으로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행
        if (front.isEmpty() || current == 0) return;

        //2. 현재 보고 있던 페이지를 뒤로 가기 공간에 저장
        back.addFirst(current);
        //3. 앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속
        current = front.pollFirst();
    }

    public static void compress() {
        if (back.isEmpty()) return;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int pre = back.poll();
        q.add(pre);

        while (!back.isEmpty()) {
            int p = back.poll();
            if (p == pre) continue;
            pre = p;
            q.add(p);
        }

        back = q;
    }

    public static void print() {
        //현재 페이지 출력
        sb = new StringBuilder();
        sb.append(current).append("\n");
        //뒤로가기 페이지에서 최근 방문 순서대로 페이지 출력
        if (back.isEmpty()) {
            sb.append("-1");
        } else {
            while (!back.isEmpty()) {
                sb.append(back.pollFirst()).append(" ");
            }
        }
        sb.append("\n");

        if (front.isEmpty()) {
            sb.append("-1\n");
        } else {
            while (!front.isEmpty()) {
                sb.append(front.pollFirst()).append(" ");
            }
        }

        System.out.print(sb);

    }
}