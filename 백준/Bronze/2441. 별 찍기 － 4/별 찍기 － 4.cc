#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int n=0;
    scanf("%d", &n);
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            printf(" ");
        }

        for(int j=i;j<n;j++){
            printf("*");
        }
        printf("\n");
    }
}