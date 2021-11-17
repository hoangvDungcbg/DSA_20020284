#include <iostream>
#include <iomanip>
using namespace std;
int a[1000000];
int main(){
    int N;
    
    cin>>N;
    while(N>0){
        bool bl=false;
        int n;
        cin>>n;
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        int s1=0,s2=0;
        for(int i=0;i<n;i++){
            s2+=a[i];
        }
        for(int i=0;i<n;i++){
            s2-=a[i];
            if(s1==s2){
                bl=true;
            }
            s1+=a[i];
        }
       
        if(bl){
            cout<<"YES"<<endl;
        }
        else{
            cout<<"NO"<<endl;
        }
        N--;
    }
}
