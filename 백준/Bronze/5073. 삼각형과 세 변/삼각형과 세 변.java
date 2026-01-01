import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int a, b, c;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;

            if(a==b && b==c){
                sb.append("Equilateral\n");
                continue;
            }
            if(b>a && b>c){
                int tmp = a;
                a = b;
                b = tmp;
            }else if(c>a && c>b){
                int tmp = a;
                a=c;
                c=tmp;
            }
            //System.out.printf("%d %d %d \n", a,b,c);
            //1. 삼각형의 조건을 만족 하는가?
            if(a>=b+c){
                sb.append("Invalid\n");
            }else{
                if(a==b || b==c || c==a){
                    sb.append("Isosceles\n");
                }else{
                    sb.append("Scalene\n");
                }
            }
            
        }

        System.out.println(sb);
    }
}