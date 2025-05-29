import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L;
    static int N;
    static String[] words;
    static String[] selected;
    static boolean[] isSelected;
    static ArrayList<StringBuilder> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   //마방진의 크기
        N = Integer.parseInt(st.nextToken());   //문자열

        words = new String[N];
        selected = new String[L];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        permutation(0);

//        for (StringBuilder stringBuilder : list) {
//            System.out.println(stringBuilder);
//        }

        Collections.sort(list);
        if (list.isEmpty()) {
            System.out.println("NONE");
        } else {
            String result = list.get(0).toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= L * (L - 1); i += L) {
                sb.append(result, i, i + L);
                sb.append("\n");
            }

            System.out.println(sb);
        }

    }

    public static void permutation(int cnt) {
        if (cnt == L) {
            //정답 가능성 확인 -> list에 넣어주기
            if (isPossible()) {
                StringBuilder sb = new StringBuilder();
                for (String str : selected) {
                    sb.append(str);
                }
                list.add(sb);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selected[cnt] = words[i];
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static boolean isPossible() {
        Set<String> set = new HashSet<>(Arrays.asList(selected));

        for (int i = 0; i < L; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < L; j++) {
                sb.append(selected[j].charAt(i));
            }

            String candidate = sb.toString();
            if (!set.contains(candidate)) return false;
        }

        return true;
    }
}