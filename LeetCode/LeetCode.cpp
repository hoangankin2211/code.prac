#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
using namespace std;
void solve(vector<int> nums,int target){
    map<int,pair<int,int>> mp;

        
    for (int i=0;i<nums.size();i++){
        if (mp[nums[i]].second==1) {
            cout << "["<<mp[nums[i]].first<<","<<i<<"]";
            break;
        }
        mp[target - nums[i]].first = i;
        mp[target - nums[i]].second++;
    }
}

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

void addTail(ListNode*& list,ListNode* val){
    ListNode* temp = list;
    if (list==NULL){
        list=val;
        return;
    }
    while (temp->next != NULL){
        temp = temp ->next;
    }
    temp->next = val;
}

void printList(ListNode* head){
    for (auto i = head;i!=NULL;i=i->next){
        cout << i->val << " ";
    }
}

// class Solution {
// public:
//     ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//         ListNode* temp1 = l1;
//         ListNode* temp2 = l2;
//         int reminder = 0;
//         ListNode* res = NULL;

//         while (temp1!=NULL && temp2!=NULL){
//             int sum = temp1->val + temp2->val;
            
//             ListNode* temp = new ListNode((sum+reminder)%10);
//             addTail(res,temp);
            
//             if (sum >= 10){
//                 reminder = sum/10;
//             }
//             else reminder = 0;

//             temp1=temp1->next;
//             temp2=temp2->next;
//         }
        
//         while (temp1!=NULL){
//             int k = temp1->val + reminder;
//             if (k >= 10) reminder = k/10;
//             else reminder = 0;

//             ListNode* newNode= new ListNode(k);

//             addTail(res,newNode);
//         }

//         while (temp2!=NULL){
//             int k = temp2->val + reminder;
//             if (k >= 10) reminder = k/10;
//             else reminder = 0;

//             ListNode* newNode= new ListNode(k);

//             addTail(res,newNode);
//         }
//         return res;
//     }
// };

class Solution {
public:
    static int minOperations(vector<int>& nums, int x) {
        
    }
};




int main() {
    vector<int> test = {2,2,10,3};
    cout << Solution::minOperations(test,4);
    return 1;
}