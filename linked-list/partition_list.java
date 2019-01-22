/*
 * Given a linked list and a target value T, partition it such that all nodes less than * T are listed before the nodes larger than or equal to target value T. 
 * The original relative order of the nodes in each of the two partitions should be  
 * preserved.
 */

public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        // assume x is valid
        ListNode smallDummy = new ListNode(0), small = smallDummy;
        ListNode bigDummy = new ListNode(0), big = bigDummy;
        ListNode curr = head;
        while (curr != null){
            // nodes less than x
            if(curr.value < x){
                small.next = curr;
                small = small.next;
            }
            // greater or equal than x
            else{
                big.next = curr;
                big = big.next;   
            }
            curr = curr.next;
        }
        // finish partinioning all the nodes in the list
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;     
    }