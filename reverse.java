import java.util.*;
class reverse {
   
    static Node head;
    static int size;
    reverse(){
        size=0;
    }
     class Node{
        int data;
        Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
        size++;
    }

}

public void add(int data){       // add or addlast is same 
    Node newnode = new Node(data);
    if(head == null)
 {   head = newnode;
    return;
 }

    Node n = head;
    while(n.next != null){
        n=n.next;
    }

    n.next = newnode;

}

public void printList(){
    Node c = head;
    if(head == null)
    System.out.println("Empty list");

    while(c != null){
        System.out.print(c.data + " -> ");
        c=c.next;
    }
    System.out.println("null");
}

void LL_reverse(Node h){
    if(head == null || head.next == null)
    return;

    Node prev=h, curr=h.next, nex=curr.next;
    while(curr.next != null){
        curr.next=prev;
        
        //Update
        prev=curr;
        curr=nex;
        nex=nex.next;
    }
        curr.next=prev;
        h.next=null;
        head=curr;
}



public static void main(String[] args){   
    Scanner sc = new Scanner(System.in);
    reverse o = new reverse();
    o.add(1);
    o.add(5);
    o.add(7);
    o.add(30);
    o.add(8);
    o.add(2);
    o.add(3);
     o.printList();
   
o.LL_reverse(head);
     o.printList();

    //  LinkedList<Integer> list = new LinkedList<Integer>();
    //  list.add(1);
    //  list.add(5);
    //  System.out.println(list);
    //  Collections.reverse(list);
    // System.out.println(list);
sc.close();
}
}