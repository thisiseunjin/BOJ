#include <iostream>
using namespace std;

int main(){
    int monthInfo[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    int month;
    int date;

    scanf("%d", &month);
    scanf("%d", &date);

    int totalDate =0;
    for(int i=0;i<month;i++){
        totalDate+=monthInfo[i];
    }
    totalDate+=date;

    switch(totalDate%7){
        case 1:
            printf("MON");
            break;
        case 2:
            printf("TUE");
            break;
        case 3:
            printf("WED");
            break;
        case 4:
            printf("THU");
            break;
        case 5:
            printf("FRI");
            break;
        case 6:
            printf("SAT");
            break;
        case 0:
            printf("SUN");
            break;
    }
}