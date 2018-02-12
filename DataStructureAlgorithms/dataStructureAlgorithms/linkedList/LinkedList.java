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
	
	/*public static boolean insertIntoList(int val){
		LinkedList linkedList=new LinkedList();
		Node n = new Node(val);
		if(linkedList.head==null){
			linkedList.head=n;
			n.next=null;
			return true;
		}
		else{
			Node current=linkedList.head;
			while(current.next!=null){
				current=current.next;
			}
			current.next=n;
			n.next=null;
			return true;
		}
	}
	*/
	public boolean insertIntoList(LinkedList obj,int val){
		//LinkedList linkedList=new LinkedList();
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
