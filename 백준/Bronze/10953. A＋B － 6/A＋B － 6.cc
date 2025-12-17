#include <iostream>
using namespace std;
int main() {
    int T;
    int a,b,c;
    char comma;

    cin>>T;
    for(int i=0;i<T;i++){
        scanf("%d,%d", &a,&b);
        cout<<a+b<<endl;
    }
}