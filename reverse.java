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

public void removeLast(){
    if(head == null)
    return;

    size--;
    if(head.next == null)
    head = null;

    else{
        Node prev = head;
        Node n = head.next;
        while(n.next != null){
            prev = n;
            n=n.next;
            //prev=prev.next;
        }
        prev.next = null;
  }
}

public Node removeNthFromEnd(Node head, int n) {
    // Best Approach
            Node fast = head, slow = head;
            for (int i = 0; i < n; i++) fast = fast.next;
            if (fast == null) return head.next;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
}

// OKKKK Approach

//     if((head == null) || (head.next == null && n == 1) )
//         return null;
   
//         Node rn =head;
//         int s = 0;
//         while (rn != null){
//             rn=rn.next;
//             s++;
//         }
   
   
//   if(n > s)
//   return head;
//   else
//   {
//      int pos = s-n+1; // position of node from starting
//     if(s == n){
//     head = head.next;
//     return head;
// }
  
//     Node prev=head;
//     rn = head.next;
//     for(int i=1;i<pos-1; i++)
//     {
//         prev=rn;
//         rn=rn.next;
//     }
  
//     prev.next = rn.next;
    
     
// }
//  return head;
// }

//  public Node swapPairs(Node head) {
//         if(head == null || head.next == null)
//         return head;
        
//         Node prev=head, curr = head.next;
//         int temp;
//         while(curr != null && prev != null)
//          {
//             temp = curr.data;
//             curr.data = prev.data;
//             prev.data = temp;

//             // updation
//             prev =curr.next;
//             if(prev != null)
//             curr = prev.next;
//             else 
//             return head;
//         }

//        return head;
//     }

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

public void remove(Node n){     // removing a specific node
    if(head == null)
        return;

        size--;
        if(head == n){
        head=n.next;
        return;}

        else{
            Node prev = head;
            Node curr = head.next;
            while(curr.data != n.data && curr.next != null){
                prev = curr;
                curr=curr.next;
         }
      if(curr.data == n.data && curr.next == null){
        prev.next = null;
        return;
      }
      else{
      prev.next = curr.next;
      curr = curr.next;
      }
      
    }

  }


public static Node reverseBetween(Node head, int left, int right) {
    if(head == null || head.next == null)
    return head;


    Node c = head; int siz=0;
    while(c!=null){
        c=c.next;
        siz++;
    }

    if(left == 1 && right == siz){
        Node prev=head, curr=head.next, nex=curr.next;
    while(curr.next != null){
        curr.next=prev;
        
        //Update
        prev=curr;
        curr=nex;
        nex=nex.next;
    }
        curr.next=prev;
        head.next=null;
        head=curr;
        return head;
    }


    if(left == 1)
    {
        Node prev = head, curr=head.next,nex=curr.next;
    
        while(left<right)
        {
            curr.next =prev;

            //Updation
            prev = curr;
            curr = nex;
            nex = nex.next;
            left++;
        }

         head.next = curr;
         head = prev;
        return head;
    }

   if(left == right && left == siz)
        return head;

    if(left < right)
        {
            Node n=head;int i;
    for(i=1;i<left-1;i++) n=n.next;
   
    // Initializing it initially only because later on when we change the node's next value ....... the next values will keep on fluctuating
    Node s = n.next,newx=s.next,nex=newx.next;

    //     if(s == null || s.next == null)
    //     {
    //         newx = null;
    //         nex =null;
    //     }
    // }
    // else{
    
    

    Node n1=head;
    for(i=1;i<right;i++)n1=n1.next;
  
    (n.next).next = n1.next; //5->8
    n.next = n1; //1->30
    
//    1 -> 30 -> 8 -> null
//    1 -> 30|| -> 7 -> ||5 -> 8  -> null

     for(i = left; i <right; i++)
     {
        newx.next = s;
        // updation when nex.next == null   
        if(nex == null || nex.next == null){
                s = newx;
                newx = nex;
            }
        //Update
        else{
        s = newx;
        newx = nex;
        nex = nex.next;
        }
     }
    }
    else
    System.out.println("\nRight value must be grater than left value.....Thus No changes in the list. \n ");
 return head;
}


public static void main(String[] args){   
    Scanner sc = new Scanner(System.in);
    reverse o = new reverse();
    o.add(1);
    o.add(5);
    o.add(7);
    // o.add(30);
    // o.add(8);
    // o.add(2);
    // o.add(3);
    // o.add(5);
     o.printList();
     head = reverseBetween(head,2,3);
//    head = o.removeNthFromEnd(head, 1);
    //  o.swapPairs(head);
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