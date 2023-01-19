class ListNode {
  int val;
  ListNode? next;
  ListNode([this.val = 0, this.next]);
}

class Solution {
  static ListNode? addTwoNumbers(ListNode? l1, ListNode? l2) {
    ListNode? result = null;
    ListNode? resultHead = null;
    int remember = 0;

    while (l1 != null || l2 != null) {
      int sum =
          remember + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
      int temp = 0;
      if (sum > 9) {
        remember = 1;
        temp = sum % 10;
      } else {
        remember = 0;
        temp = sum;
      }

      if (result != null) {
        ListNode tempNode = ListNode(temp);
        result.next = tempNode;
        result = result.next;
      } else {
        ListNode tempNode = ListNode(temp);
        result = tempNode;
        resultHead = result;
      }

      l1 = l1?.next;
      l2 = l2?.next;
    }

    if (remember == 1) {
      result?.next = ListNode(1);
    }

    return resultHead;
  }
}

void main() {
  ListNode? l1 = ListNode(2, ListNode(4, ListNode(3)));
  ListNode? l2 = ListNode(5, ListNode(6));

  ListNode? result = Solution.addTwoNumbers(l1, l2);

  while (result != null) {
    print(result.val);
    result = result.next;
  }
}
