import java.util.*;
import java.io.*;

public class Main {
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                push(x);
            }else if(op.equals("pop")){
                pop();
            }else if(op.equals("size")){
                size();
            }else if(op.equals("empty")){
                empty();
            }else if(op.equals("front")){
                front();
            }else back();
        }

        System.out.print(sb);
    }

    public static void push(int x){
        q.add(x);
    }

    public static void pop(){
        if(q.isEmpty()){
            sb.append(-1);
        }else{
            sb.append(q.poll());
        }

        sb.append("\n");
    }

    public static void size(){
        sb.append(q.size()).append("\n");
    }

    public static void empty(){
        if(q.isEmpty()){
            sb.append(1);
        }else{
            sb.append(0);
        }

        sb.append("\n");
    }

    public static void front(){
        if(q.isEmpty()){
            sb.append("-1");
        }else{
            sb.append(q.getFirst());
        }

        sb.append("\n");
    }

    public static void back(){
        if(q.isEmpty()){
            sb.append("-1");
        }else{
            sb.append(q.getLast());
        }
        sb.append("\n");
    }
    
}