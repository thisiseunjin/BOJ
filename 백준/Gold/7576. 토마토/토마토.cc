#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
int map[1001][1001];
queue<pair<int,int>> q;
int date=0;
int bfs();
bool isAllDone();
bool inRange(int, int);
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};

int main() {
    scanf("%d %d", &m,&n);
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d", &map[i][j]);
        }
    }
    
    //지금 익은 토마토의 위치를 q에 넣는다.
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(map[i][j]==1){
                 q.push({i,j});
            }
        }
    }
    date = bfs();

    if(isAllDone()){
        printf("%d", date);
    }else{
        printf("-1");
    }

}

int bfs(){
    int date =0 ;

    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        date = max(date, map[x][y]);
        q.pop();
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!inRange(nx,ny)) continue;
            //1. 비어 있는 곳은 갈 수 없다.
            if(map[nx][ny]==-1) continue;
            //2. 이미 익은곳은 가지 않는다
            if(map[nx][ny]>0) continue;

            map[nx][ny] = map[x][y]+1;
            q.push({nx,ny});
        }
    }

    return date-1;
}

bool inRange(int x, int y){
    return x>=0 && y>=0 && x<n && y<m;
}

bool isAllDone(){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(map[i][j]==0) return false;
        }
    }
    return true;
}