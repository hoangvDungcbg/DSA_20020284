#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
using namespace std;
int main(){
    vector<int> a;
    int n,k;
    int count=0;
    cin>>n>>k;
    
    for(int i=0;i<n;i++){
        int x;
        cin>>x;
        a.push_back(x);
    }
    sort(a.begin(),a.end());
    for(int i=0;i<n;i++){
        if(binary_search(a.begin(),a.end(),a[i]+k)){
            count++;
        }
        
    }
        
        cout<<count<<endl;
}
