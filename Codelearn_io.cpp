#include<iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<map>
using namespace std;

void swap(int &a,int &b){
    int temp=a;
    a=b;b=temp;
}

bool check(int a,int b){
    return (a<b)? true:false;
}

int maximizeSum(std::vector<int> &arr)
{
    sort(arr.begin(),arr.end(),check);

    vector<int> temp;
    for (int i=0;i<arr.size()/2;i++){
        temp.push_back(arr[i]);
        temp.push_back(arr[arr.size()-1-i]);
    }
    if (arr.size()%2!=0) temp.push_back(arr[arr.size()/2]);

    int res=0;
    for (int i=0;i<temp.size();i++){
        if (i==temp.size()-1){
            res+=abs(temp[i]-temp[0]);
            break;
        }
        res+=abs(temp[i]-temp[i+1]);
    }

    return res;
}

int maxMin(int k, vector<int> arr) {
    sort(arr.begin(),arr.end(),check);
    if (k>arr.size()) return -1;
    int min=arr[k-1]-arr[0];
    
    for(int i=1;i<arr.size();i++){
        if (i+k-1>=arr.size()) break;
        if (min>arr[i+k-1]-arr[i]) min=arr[i+k-1]-arr[i];
    }
    return min;
}

long long decorateRoom(long r, long g, long b){
    long x=max(r,max(g,b));
    long y=r+g+b-x;
    if (y<=x/2) return y;
    return (y+x)/3;
}
///////////////////////////////////////////////////////////////////
map<int,int> checkPos;
bool checkNegative = false;

int findNumOfSum(vector<int> arr,int sum){
    int count=0;
    for (int i=0;i<arr.size();i++){
        int t=0;
        for (int j=i;j<arr.size();j++){
            t+=arr[j];
            if (arr[j]==sum){
                count++;
                i=j;
                break;
            }
            if (t==sum) {
                count++;
                i=j;
                break;
            }
            else if (t>sum && !checkNegative){
                break;
            }
        }
    }
    return count;
}   

int numberOfSubArray(std::vector<int> arr){   
    int res=0;
    int sumMax=0;

    for (int i=0;i<arr.size();i++){
        if (arr[i]<0) {
            checkNegative=true;
            break;
        }
    }

    for (int i=0;i<arr.size();i++){
        int sum=0;
        for (int j=i;j<arr.size();j++){

            sum+=arr[i];    
            checkPos[sum]++;
            if (checkPos[sum]>1) continue; 
            int k=findNumOfSum(arr,sum);
            
            if (res==0) res=k;
            else 
                if (res<k) {
                    res=k;
                    sumMax = sum;
                }
        }
    }
    return res;
}

struct obj{
    int l,r,v;
    obj(int l=0, int r=0, int v=0){
        this->l=l;
        this->r=r;
        this->v=v;
    }

    bool operator < (obj const &o){
        if (v==o.v){
            if (r==o.r){
                return l<o.l;
            }
            else return r<o.r;
        }
        return v<o.v;
    }
};

void step1(vector<int> var, vector<obj> o, vector<obj> s){
    
}

int main(){
    cout<<findNumOfSum({1,2,1,4,1,4,3,5,5,4,3,2,4,5,2,3,4,4,3,5},5);
}