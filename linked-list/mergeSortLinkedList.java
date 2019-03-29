/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode one = head;
        ListNode mid = middle(head);
        ListNode two = mid.next;
        mid.next = null;
        one = sortList(one);
        two = sortList(two);
        return merge(one, two);
    }
    private ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(one != null && two != null){
            if(one.val <= two.val){
                cur.next = one;
                one = one.next;
            }
            else{
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if(one != null){
            cur.next = one;
        }
        else{
            cur.next = two;
        }
        return dummy.next;
    }
}