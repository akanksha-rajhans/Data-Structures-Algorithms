package linkedList;

public class DeleteNodesWithGreaterValueOnRight extends LinkedList{
	
	public static Node deleteGreaterOnRight(Node head){
		if(head==null || head.next==null)
			return null;
		
		while(head.next!=null && head.next.data>head.data)
			head=head.next;
		
		if(head!=null && head.next!=null){
			Node prev=head;
			Node temp=head.next;
			while(temp.next!=null){
				if(temp.next.data>temp.data){
					prev.next=prev.next.next;
					temp=prev.next;
				}
				else{
					temp=temp.next;
					prev=prev.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList.insertIntoList(60);
		LinkedList.insertIntoList(50);
		LinkedList.insertIntoList(40);
		LinkedList.insertIntoList(30);
		LinkedList.insertIntoList(20);
		LinkedList.insertIntoList(10);
		
		
		
		
		
		//LinkedList.insertIntoList(2);
		//LinkedList.insertIntoList(3);
		
		Node n=DeleteNodesWithGreaterValueOnRight.deleteGreaterOnRight(head);
		LinkedList.traverseList(n);
		
	}

}
