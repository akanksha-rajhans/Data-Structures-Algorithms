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
		LinkedList obj=new LinkedList();
		obj.insertIntoList(obj,1);
		obj.insertIntoList(obj,2);
		obj.insertIntoList(obj,3);
		obj.insertIntoList(obj,4);
		obj.insertIntoList(obj,5);
		obj.insertIntoList(obj,6);
		obj.insertIntoList(obj,7);
		
		DeleteLinkedListRecursively.deleteRecursively(obj.head);
		
		
	}

}
