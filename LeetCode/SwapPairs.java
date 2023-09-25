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
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode beforeNode = null;

        while (temp != null && temp.next != null){
            ListNode node = temp.next;

            if (beforeNode == null){
                temp.next = node.next;
                node.next = temp;
            }
            else{
                beforeNode.next = node;
                temp.next = node.next;
                node.next = temp;
            }

            beforeNode = temp.next;
            temp = temp.next.next;
        }

        return head;
  }
}
public class SwapPairs {
  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    new Solution().swapPairs(head);
  }
}

