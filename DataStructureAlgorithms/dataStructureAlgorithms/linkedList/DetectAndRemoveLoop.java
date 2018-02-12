package linkedList;

public class DetectAndRemoveLoop{
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
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
	
	public void detectAndRemoveLoop(Node head){
		Node slow=head;
		Node fast=head.next;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next.next;
		}
		if(slow==fast){
			System.out.println("Loop Present.");
			slow=head;
			System.out.println("Working on it...");
			while(slow.next!=fast.next.next){
				System.out.println("Working on it...");
				slow=slow.next;
				fast=fast.next;
			}
			if(slow.next==fast.next.next){
				fast.next.next=null;
				System.out.println("Loop Removed.");}
		}
	}

	public static void main(String[] args) {
		DetectAndRemoveLoop obj=new DetectAndRemoveLoop();
		obj.head=obj.new Node(1);
		obj.head.next=obj.new Node(2);
		obj.head.next.next=obj.new Node(3);
		obj.head.next.next.next=obj.new Node(4);
		obj.head.next.next.next.next=obj.new Node(5);
		obj.head.next.next.next.next.next=obj.head.next.next.next;
		
		obj.detectAndRemoveLoop(obj.head);
		obj.traverseList(obj.head);
	}

}
