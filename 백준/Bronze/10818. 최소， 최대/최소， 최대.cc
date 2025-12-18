#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int n=0;
    scanf("%d", &n);
    int* arr = new int[n];
    for(int i=0;i<n;i++){
        scanf("%d", &arr[i]);
    }

    sort(arr, arr+n);
    printf("%d %d", arr[0], arr[n-1]);
}