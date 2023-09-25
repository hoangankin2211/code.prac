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
  public ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null || head.next == null)
      return head;

    ListNode temp = head;
    int length = 0;
    while (head != null) {
      length++;
      temp = temp.next;
    }
    
    int rotateNum = length - (k % length);

    temp = head;
    ListNode headList = null;
    int count = 0;
    while (true) {
      if (temp.next == null) {
        temp.next = head;
        break;
      }
      count++;
      if (count == rotateNum) {
        ListNode node = temp;
        temp = temp.next;
        headList = temp;
        node.next = null;
      } else {
        temp = temp.next;
      }
    }

    return headList;
  }
}
public class RotateList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    new Solution().rotateRight(head, 2);
  }
}

