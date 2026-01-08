import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String pw = br.readLine();
            if(pw.equals("end")) break;

            //조건1. 모음(a,e,i,o,u) 하나를 반드시 포함해야한다.
            //조건2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
            //조건3. 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용한다.
            boolean flag1 = false;
            boolean flag2 = true;
            boolean flag3 = true;

            int status1=0, status2=0;

            char pre1 = pw.charAt(0);
            if(pre1 == 'a' || pre1 =='e' || pre1=='i' || pre1 =='o' || pre1 =='u'){
                flag1 = true;
                status1=1;
            }

            if(pw.length()==1){
               if(flag1 == false){
                    sb.append("<").append(pw).append(">").append( " is not acceptable.\n");
               }else{
                    sb.append("<").append(pw).append(">").append( " is acceptable.\n");
               }

                continue;
            }

            char pre2 = pw.charAt(1);
            if(pre2 == 'a' || pre2 =='e' || pre2=='i' || pre2 =='o' || pre2 =='u'){
                flag1 = true;
                status2=1;
            }

            if(pre2==pre1 && (pre1!='e'&&pre2!='o')){
                 sb.append("<").append(pw).append(">").append( " is not acceptable.\n");
                continue;
            }

            for(int i=2;i<pw.length();i++){
                char ch = pw.charAt(i);

                int status = 0;
                if(ch == 'a' || ch =='e' || ch=='i' || ch =='o' || ch =='u'){
                    flag1 = true;
                    status=1;
                }
                //조건2 확인
                if(status1==status2 && status2 == status){
                    //sb.append("<").append(pw).append(">").append( "is not acceptable");
                    flag2 = false;
                    break;
                }

                //조건 3확인
                 if(pre2==ch && (ch!='e'&&ch!='o')){
                     
                    flag3 = false;
                     break;
                }

                //2번째 전 : status1, pre1
                status1 = status2;
                pre1 = pre2;
                //1번째 전: status2, pre2;
                status2 = status;
                pre2 = ch;
            }


            if(flag1 && flag2 && flag3){
                sb.append("<").append(pw).append(">").append( " is acceptable.\n");
            }else{
                sb.append("<").append(pw).append(">").append( " is not acceptable.\n");
            }

            

            
        }
        System.out.println(sb);
    }
}