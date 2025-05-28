import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result =0;
        if(N==1){
            result = 0;
        }else if(N%2==0){
            //짝수이다?
            result = (N*N)/2;
        }else{
            result = (N/2)*N+(N/2)+1;
        }

        System.out.print(result);
    }
}