#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
int main(){
    int min=9999999;
    int a[1000000];
    int n;
    int Min;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    sort(a,a+n);
    for(int i=0;i<n;i++){
        Min=abs(a[i+1]-a[i]);
        if(Min<min){
            min=Min;
            }
        }
    for(int i=0;i<n;i++){
        if(abs(a[i+1]-a[i])==min){
            cout<<a[i]<<" "<<a[i+1]<<" ";
        }
    }
    
}
