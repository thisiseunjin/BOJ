import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(isTrue(N)?1:0);
    }

    public static boolean isTrue(int n){
        //윤년은 4의 배수, 100의 배수가 아닐때
        if(n%4==0 && n%100!=0){
            return true;
        }

        if(n%400==0){
            return true;
        }

        return false;
    }
}