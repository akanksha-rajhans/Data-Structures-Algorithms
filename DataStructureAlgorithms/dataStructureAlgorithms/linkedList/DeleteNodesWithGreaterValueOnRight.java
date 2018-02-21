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
		LinkedList obj=new LinkedList();
		obj.insertIntoList(obj,60);
		obj.insertIntoList(obj,50);
		obj.insertIntoList(obj,40);
		obj.insertIntoList(obj,30);
		obj.insertIntoList(obj,20);
		obj.insertIntoList(obj,10);
		
		
		
		
		
		//LinkedList.insertIntoList(2);
		//LinkedList.insertIntoList(3);
		
		Node n=DeleteNodesWithGreaterValueOnRight.deleteGreaterOnRight(obj.head);
		obj.traverseList(n);
		
	}

}
