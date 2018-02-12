package linkedList;

public class MergeTwoSortedLists extends LinkedList{
	
	public static Node mergeLists(Node l1, Node l2){
		Node start=null; Node temp=null;
		while(l1!=null || l2!=null){
			if(l1!=null && l2!=null && l1.data<l2.data){
				if(start==null)
					start=l1;
				if(temp==null)
					temp=l1;
				else{
					temp.next=l1;
					temp=temp.next;
				}
				l1=l1.next;
				temp.next=null;
			}
			else if(l1!=null && l2!=null){
				if(start==null)
					start=l2;
				if(temp==null)
					temp=l2;
				else{
					temp.next=l2;
					temp=temp.next;
				}
				l2=l2.next;
				temp.next=null;
			}
			else{
				if(l1==null && l2!=null){
					while(l2!=null){
						temp.next=l2;
						temp=temp.next;
						l2=l2.next;
						temp.next=null;
					}
					}
					if(l2==null && l1!=null){
						while(l1!=null){
							temp.next=l1;
							temp=temp.next;
							l1=l1.next;
							temp.next=null;
					}
				}
				
			}
		}
		
		return start;
	}

	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.insertIntoList(l1, 5);
		l1.insertIntoList(l1, 7);
		l1.insertIntoList(l1, 9);
		
		LinkedList l2=new LinkedList();
		l2.insertIntoList(l2, 4);
		l2.insertIntoList(l2, 6);
		l2.insertIntoList(l2, 8);
		l2.insertIntoList(l2, 10);
		l2.insertIntoList(l2, 11);
		
		Node n=MergeTwoSortedLists.mergeLists(l1.head, l2.head);
		l2.traverseList(n);
	}

}
