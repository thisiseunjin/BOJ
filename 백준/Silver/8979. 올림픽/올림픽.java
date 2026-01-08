import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int K;
    static ArrayList<int[]> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new int[]{n,gold, silver, bronze});


        }

            Collections.sort(list, new Comparator<int[]>(){
               public int compare(int[] n1, int n2[]){
                   if(n1[1]!=n2[1]) return n2[1]-n1[1];
                   if(n1[2]!=n2[2]) return n2[2]-n1[2];
                   if(n1[3]!=n2[3]) return n2[3]-n1[3];
                   return n1[0]-n2[0];
               } 
            });

        int rank = 1;
        int sum=1;

        if(list.get(0)[0]==K){
            System.out.println(1);
            System.exit(0);
        }
        
        for(int i=1;i<list.size();i++){
            int[] tmp = list.get(i);
            int num = tmp[0];
            int gold = tmp[1];
            int silver = tmp[2];
            int bronze = tmp[3];

          

            int[] pre = list.get(i-1);
            if(gold==pre[1] && silver == pre[2] && bronze==pre[3]){
                sum++;
            }else{
                rank += sum;
                sum=1;
            }

              if(num==K){
                break;
            }
        }

        System.out.println(rank);
        
    }
}