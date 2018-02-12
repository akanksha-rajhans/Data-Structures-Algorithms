package linkedList;

public class DeleteLinkedListRecursively extends LinkedList{
	
	public static void deleteRecursively(Node head){
		if(head==null)
			return;
		if(head.next!=null){
			deleteRecursively(head.next);
		}
		System.out.print("Deleting: "+head.data);
		head=null;
		if(head==null)
			System.out.println();
		
	}

	public static void main(String[] args) {
		LinkedList.insertIntoList(1);
		LinkedList.insertIntoList(2);
		LinkedList.insertIntoList(3);
		LinkedList.insertIntoList(4);
		LinkedList.insertIntoList(5);
		LinkedList.insertIntoList(6);
		LinkedList.insertIntoList(7);
		
		DeleteLinkedListRecursively.deleteRecursively(head);
		//head=null;
		//LinkedList.traverseList(head);
		
	}

}
