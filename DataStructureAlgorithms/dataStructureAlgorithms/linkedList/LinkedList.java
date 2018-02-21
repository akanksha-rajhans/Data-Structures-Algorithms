package linkedList;

public class LinkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public boolean insertIntoList(LinkedList obj,int val){
		Node n = new Node(val);
		if(obj.head==null){
			obj.head=n;
			n.next=null;
			return true;
		}
		else{
			Node current=obj.head;
			while(current.next!=null){
				current=current.next;
			}
			current.next=n;
			n.next=null;
			return true;
		}
	}
	
	public void traverseList(Node head){
		if(head==null)
			return;
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
}
