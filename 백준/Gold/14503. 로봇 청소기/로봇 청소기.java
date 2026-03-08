import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map;
    static int N,M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] robot = new int[3];
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 1=벽, 0=청소되지 않은 빈칸, 2=청소한 빈칸
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            robot[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning(robot[0], robot[1], robot[2]);

        System.out.println(cnt);
    }

    public static void cleaning(int x, int y, int dir){
        // 1. 지금 내 위치가 청소하지 않은 곳이면? 청소한다.
        if(map[x][y]==0){
            cnt+=1;
            map[x][y] = 2;
        }

        // 3. 4방향 중 청소되지 않은 칸이 있는 경우
        // 3-1. 반시계 방향으로 90도 회전한다.
        // 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        // 3-3. 1번으로 돌아간다.
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (inRange(nx, ny) && map[nx][ny] == 0) {
                cleaning(nx, ny, dir);
                return; // 이동했으면 즉시 종료
            }
        }

        // 2. 4방향 중 청소되지 않은 칸이 없는 경우
        // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        if(!flag){
            int nx = x+dx[dir]*-1;
            int ny = y+dy[dir]*-1;
            if(inRange(nx, ny) && map[nx][ny]!=1){
                cleaning(nx, ny, dir);
            }
        }
    }

    public static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }
}