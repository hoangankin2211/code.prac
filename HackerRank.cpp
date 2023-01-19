#include<iostream>
#include<math.h>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

bool isSymmetry(string res,int l,int r){
    int size=r-l+1;
    int k = size/2+l;
    int t=0;
    for (int i=l;i<k;i++){
        if (res[i]!=res[r-t]) return false;
        t++;
    }
    return true;
}

///////////////////////////////////////////////////
bool check(int a,int b){
    return (a<b)? true:false;
}

int getMinimumCost(int k, vector<int> c) {
    int sum=0;
    sort(c.begin(),c.end(),check);
    for (int i=c.size()-1;i>=c.size()-k;i--){
        sum+=c[i];
    }
    
    return sum; 
}
///////////////////////////////////////////////////
int main(){
    vector<int> c={5,4,2,43,6,3};
    cout<<getMinimumCost(3,c);
}