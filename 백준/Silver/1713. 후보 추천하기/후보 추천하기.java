import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Person> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
//            System.out.println(num + "을 추천했습니다.");

            //틀 안에 num을 가진 학생이 있는지 확인
            int idx = isIn(num);
            if (idx != -1) {
                //투표 수를 늘려 준다.
                list.get(idx).cnt++;
//                printCandidate();

                continue;
            }

            //없는데 list가 N개로 가득 찼다면?
            if (list.size() == N) {
                Collections.sort(list);
//                list.remove(0);
//                System.out.println("==== 정렬 결과 ====");
//                printCandidate();
//                System.out.println("==================");
                list.remove(0);

            }

            list.add(new Person(num, 1, 1));
//            printCandidate();
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Person p : list) {
            result.add(p.num);
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);

    }

    public static int isIn(int num) {
        //순환하면서 나이를 늘려 준다.
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            if (p.num == num) idx = i;
            p.age++;
        }

        return idx;
    }

    public static void printCandidate() {
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }

    public static class Person implements Comparable<Person> {
        int num;
        int cnt;
        int age;

        public Person(int num, int cnt, int age) {
            this.num = num;
            this.cnt = cnt;
            this.age = age;
        }

        public int compareTo(Person p2) {
            if (this.cnt == p2.cnt) {
//                return p2.age - this.age;
                return p2.age - this.age;

            } else {
//                return p2.cnt - this.cnt;
                return this.cnt - p2.cnt;
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "num=" + num +
                    ", cnt=" + cnt +
                    ", age=" + age +
                    '}';
        }
    }
}