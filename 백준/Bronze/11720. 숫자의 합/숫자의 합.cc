#include <iostream>
using namespace std;
int main() {
    int N;
    cin>>N;

    int sum=0;
    string input;
    cin>>input;

    for(int i=0;i<input.length();i++){
        int a = input.at(i)-'0';
        sum+=a;
    }

    cout<<sum;
}