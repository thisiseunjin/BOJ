import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int alpha=0;
    static int Alpha=0;
    static int blank=0;
    static int num=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        
        while(true){
            alpha=0;
            Alpha =0;
            blank=0;
            num=0;
            input = br.readLine();
            if(input==null || input.isEmpty()) break;
            
            for(int i=0;i<input.length();i++){
                char ch = input.charAt(i);

                if(ch>='a' && ch<='z') alpha++;
                else if(ch>='A' && ch<='Z') Alpha++;
                else if(ch>='0' && ch<='9') num++;
                else if(ch == ' ') blank++;
            }

            sb.append(alpha).append(" ").append(Alpha).append(" ").append(num).append(" ").append(blank).append("\n");
        }

        System.out.println(sb);

    }
}