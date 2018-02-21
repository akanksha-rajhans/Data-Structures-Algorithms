package linkedList;

public class ReverseSinglyLinkedList extends LinkedList{
	
	public static Node reverseList(Node head){
		if(head==null)
			return null;
		
		Node current=head;
		Node next=null;
		Node prev=null;
		
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}
	
	public static Node reverseInSize(Node head, int k){
		if(head==null)
			return null;
		
		Node current=head;
		Node next=null;
		Node prev=null;
		int count=0;
		
		while(count<k && current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		if(next!=null){
			head.next=reverseInSize(next, k);
		}
		return prev;
	}
	
	public static Node reverseAltKNodes(int k, Node head)
	{
		if(head==null)
			return null;
		Node current=head;
		Node prev=null;
		Node next=null;
		int count=0;
		
		while(count<k && current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		
		if(next!=null){
			head.next=current;
		}
		
		count=0;
		while(count<k-1 && current!=null){
			current=current.next;
			count++;
		}
		
		if(current!=null){
			current.next=reverseAltKNodes(k, current.next);
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LinkedList obj=new LinkedList();
		obj.insertIntoList(obj,1);
		obj.insertIntoList(obj,2);
		obj.insertIntoList(obj,3);
		obj.insertIntoList(obj,4);
		obj.insertIntoList(obj,5);
		obj.insertIntoList(obj,6);
		obj.insertIntoList(obj,7);
		
		//Node n=ReverseSinglyLinkedList.reverseList(head);
		//Node n=ReverseSinglyLinkedList.reverseInSize(head, 5);
		Node n=ReverseSinglyLinkedList.reverseAltKNodes(2, obj.head);
		obj.traverseList(n);
	}

}
