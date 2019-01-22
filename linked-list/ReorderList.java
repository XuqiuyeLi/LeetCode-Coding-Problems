/** N1 -> N2 -> N3 -> N4 -> N5 -> N6 ->... ->Nn -> NULL
 *  convert to
 *  N1 -> Nn -> N2 -> Nn-1 -> .... -> NULL
 */


// Step 1: Find the middle node of the linked list and spilt it into two halves
// Step 2: Reverse the 2nd half of the Linked List
// Step 3: Merge two linked lists


public class ReorderList {
	public ListNode reorder(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode one = head;
		ListNode mid = middle(head);
		ListNode two = reverse(mid.next);
		// de-link to two lists from middle point
		mid.next = null;

		return merge(one, two);
	}

	private ListNode middle(ListNode head){
		// assume no null cases 
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private ListNode merge(ListNode one, ListNode two){
		// assume no null cases
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while(one != null && two != null){
			current.next = one;
			one = one.next;
			current.next.next = two;
			two = two.next;
			current = current.next.next;
		}
		if(one == null){
			current.next = two;
		}
		else{
			current.next = one;
		}
		return dummy.next;
	}
}