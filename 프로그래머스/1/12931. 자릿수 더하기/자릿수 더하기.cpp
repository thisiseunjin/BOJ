#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0;
    string str = to_string(n);
    printf("%s\n", str.c_str());
    for(int i=0;i<str.length();i++){
        answer+=(str.at(i)-'0');
    }

    return answer;
}