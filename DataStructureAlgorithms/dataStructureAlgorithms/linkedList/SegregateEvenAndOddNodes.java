package linkedList;

public class SegregateEvenAndOddNodes extends LinkedList{
	
	public static Node segregateEvenOdd(Node head){
		if(head==null)
			return null;
		Node temp=head; 
		Node even=null; Node odd=null;
		Node eStart=null; Node oStart=null;
		
		while(temp!=null){
			if(temp.data%2==0){
				if(even==null){
					even=temp;
					temp=temp.next;
					eStart=even;
					even.next=null;
				}
				else{
					even.next=temp;
					temp=temp.next;
					even=even.next;
					even.next=null;
				}
			}
			else{
			if(temp.data%2!=0){
				if(odd==null){
					odd=temp;
					temp=temp.next;
					oStart=odd;
					odd.next=null;
				}
				else{
					odd.next=temp;
					temp=temp.next;
					odd=odd.next;
					odd.next=null;
				}
			}
		}
		}
		even.next=oStart;
		return eStart;
	}
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insertIntoList(l,17);
		l.insertIntoList(l,15);
		l.insertIntoList(l,8);
		l.insertIntoList(l,12);
		l.insertIntoList(l,10);
		l.insertIntoList(l,5);
		l.insertIntoList(l,4);
		l.insertIntoList(l,1);
		l.insertIntoList(l,7);
		l.insertIntoList(l,7);
		
		Node n=SegregateEvenAndOddNodes.segregateEvenOdd(l.head);
		l.traverseList(n);

	}

}
