import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isSelected = new boolean[9];
    static int[] nums = new int[9];
    static int sum = 0;
    static int target;
    static int[] selected = new int[2];
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        target = sum - 100;
        comb(0, 0, 0);

//        System.out.println(Arrays.toString(isSelected));
//        System.out.println(isFind);

//        for (int i = 0; i < 9; i++) {
//            if (isSelected[i]) continue;
//            System.out.println(nums[i]);
//        }
    }

    public static void comb(int cnt, int start, int sum) {
        if (isFind) return;
        if (sum > target) return;
        if (cnt == 2) {

            if (sum == target) {
                isFind = true;
                for (int i = 0; i < 9; i++) {
                    if (isSelected[i]) continue;
                    System.out.println(nums[i]);
                }

            }
            return;
        }

        for (int i = start; i < 9; i++) {
            isSelected[i] = true;
            comb(cnt + 1, i + 1, sum + nums[i]);
            isSelected[i] = false;
        }
    }
}