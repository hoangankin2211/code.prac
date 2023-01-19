#include<iostream>
#include<math.h>
#include<vector>
#include<sstream>
#include<algorithm>
using namespace std;

/////Weight for weight - [04/25/2022] 
class WeightSort
{
public:
    static string orderWeight(const std::string &str);
    static bool checkStr(string a,string b);
    static int sumStr(string val);
};

int WeightSort::sumStr(string val){
    int result=0;
    for (int i=0;i<val.size();i++){
        result+=val[i]-48;
    }
    return result;
}

bool WeightSort::checkStr(string a, string b){
    if (sumStr(a)<sumStr(b)){
        return true;
    }
    else if (sumStr(a)>sumStr(b)){
        return false;
    }
    int i=0, j=0;
    do
    {
        if (a[i]<b[j]) return true;
        else if (a[i]>b[j]) return false;
        i++;j++;
    } while (i<a.size() && j<b.size());
    return true;
}

string WeightSort::orderWeight(const string& str){
    if (str.empty()) return "";
    string temp = str;
    stringstream ss(temp);
    vector<string> listOfNum;
    string numStr="";
    while (ss>>numStr){
        listOfNum.push_back(numStr);
    }

    for (int i=0;i<listOfNum.size()-1;i++){
        for (int j=i+1;j<listOfNum.size();j++){
            if (!checkStr(listOfNum[i],listOfNum[j])){
                string temp = listOfNum[j];
                listOfNum[j] = listOfNum[i];
                listOfNum[i] = temp;
            }
        }
    }

    string res;
    for (int i=0;i<listOfNum.size();i++){
        res+=listOfNum[i]+" ";
    }
    res.pop_back();
    return res;
}

int main(){
    string test = "2000 10003 1234000 44444444 9999 11 11 22 123";
    string res = WeightSort::orderWeight(test);
    cout<<res;
    return 0;
}