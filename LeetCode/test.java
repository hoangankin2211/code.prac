import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

class Solution {
     private ListNode addHead(ListNode head,ListNode newNode){
        if (head == null){
            return newNode;
        }
        
        newNode.next = head;
        return newNode;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head; 

        while (fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newList = null;
        ListNode temp = head;

        if (fast != null){
            while (temp != slow){
                newList = addHead(newList,new ListNode(temp.val,null));
                temp = temp.next;
            }
            temp = temp.next;
        }
        else {
            while (temp != slow){
                newList = addHead(newList,new ListNode(temp.val,null));
                temp = temp.next;
            }
        }
        while (temp!=null && newList!=null){
            if (temp.val != newList.val){
                return false;
            }
            temp = temp.next;
            newList = newList.next;
        }

        return true;
    }
}

class test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        final boolean result = (new Solution().isPalindrome(head));
        System.out.println(result);
    }
}