#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int bfs(int, int);
bool isPossible(int, int);

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m;
bool isVisited[501][501];
int map[501][501];

int main() {

    scanf("%d", &n);
    scanf("%d", &m);


    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d", &map[i][j]);
        }
    }

    int maxSize=0;
    int cnt=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(isVisited[i][j]) continue;
            if(map[i][j]==0) continue;
            cnt++;
            maxSize = max(maxSize, bfs(i,j));
        }
    }

    printf("%d\n%d", cnt, maxSize);

    return 0;
}

int bfs(int startX, int startY){
    queue<pair<int,int>> q;
    int size=0;
    isVisited[startX][startY] = true;
    q.push({startX, startY});

    while(!q.empty()){
        size++;
        int x = q.front().first;
        int y = q.front().second;

        q.pop();

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(!isPossible(nx,ny)){
                continue;
            }
            if(isVisited[nx][ny]) continue;
            if(map[nx][ny]==0){
                continue;
            }

            isVisited[nx][ny] = true;
            q.push({nx,ny});

        }
    }
    
    return size;
}

bool isPossible(int x, int y){
    return x>=0 && x<n && y>=0 && y<m;
}