// Leetocde 19. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode check = head;
        int count = 0;

        while (check != null) {
            count++;
            check = check.next;
        }

        check = head;
        int i = 1;
        while (check != null) {
            if (count - n == 0) {
                head = check.next;
                break;
            } else if (i == count - n) {
                ListNode temp = check.next.next;
                check.next = temp;
                break;
            }
            check = check.next;
            i++;
        }
        return head;
    }
}