import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static String N;
    static Character[] nums;
    static boolean hasZero = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        nums = new Character[N.length()];
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            nums[i] = N.charAt(i);
            sum += (nums[i] - '0');

            if (nums[i] == '0') hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(nums, Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N.length(); i++) {
                sb.append(nums[i]);
            }

            System.out.println(sb);
        }


    }
}