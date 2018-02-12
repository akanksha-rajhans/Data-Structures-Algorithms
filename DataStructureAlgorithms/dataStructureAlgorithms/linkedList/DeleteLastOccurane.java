package linkedList;

public class DeleteLastOccurane extends LinkedList{
	
	public static void deleteLastOccuranceOfElement(Node head, int x){
	Node temp=head;
	Node lastOccurance=null;
	while(temp.next!=null){
		if(temp.data==x)
			lastOccurance=temp;
		temp=temp.next;
	}
	if(lastOccurance.data==temp.data){
		while(lastOccurance.next!=temp)
			lastOccurance=lastOccurance.next;
	}
	else
		lastOccurance.data=lastOccurance.next.data;
	lastOccurance.next=lastOccurance.next.next;
	}
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insertIntoList(l,1);
		l.insertIntoList(l,2);
		l.insertIntoList(l,3);
		l.insertIntoList(l,5);
		l.insertIntoList(l,2);
		l.insertIntoList(l,10);
		
		//null pointer
		DeleteLastOccurane.deleteLastOccuranceOfElement(l.head, 10);
		l.traverseList(l.head);

	}

}
