#include <iostream>
using namespace std;
int main() {
    while(true){
        string str;

        getline(cin, str);
        if(str.empty()){
            break;
        }

        cout<<str<<endl;
    }
}