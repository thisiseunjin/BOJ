#include <iostream>
#include <queue>
using namespace std;

int res = (int)1e9;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int dist[101][101];
int map[101][101];
int n,m;
int bfs();
bool inRange(int,int);

int main() {
    scanf("%d", &n);
    scanf("%d", &m);

    for(int i=0;i<n;i++){
       char input[m];
        scanf("%s",input);
        for(int j=0;j<m;j++){
            map[i][j] = input[j]-'0';
        }
    }

    int res = bfs();
    printf("%d", res);
    
}

int bfs(){
    queue<pair<int,int>> q;
    q.push({0,0});
    dist[0][0] = 1;

    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!inRange(nx,ny)) continue;
            if(dist[nx][ny]>0){
                continue;
            }
            if(map[nx][ny]==0) continue;
            if(nx==n-1 && ny ==m-1){
                return dist[x][y]+1;
            }
            dist[nx][ny] = dist[x][y]+1;
            q.push({nx,ny});
        }
    }

    return -1;
}

bool inRange(int x, int y){
    return x>=0 && y>=0 && x<n && y<m;
}
