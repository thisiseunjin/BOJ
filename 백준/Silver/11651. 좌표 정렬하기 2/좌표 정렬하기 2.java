 import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Point[] points;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x,y);
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(points[i].x+" "+points[i].y).append("\n");
        }

        System.out.print(sb);
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p){
            if(p.y==this.y){
                return this.x-p.x;
            }else{
               return this.y - p.y;
            }
        }
        
       
    }
}