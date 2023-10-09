import java.util.Scanner;
class Remove_specificNode
{
   static Node head;
    int size;
    Remove_specificNode()
        {
            size = 0;
        }

    public class Node{
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

      public static void main(String[] args){   
          Remove_specificNode o = new Remove_specificNode();
        Scanner sc = new Scanner(System.in);

        // Delete all nodes which have values greater than 25.
        System.out.print("Enter the value to delete the nodes greater"); 
        int val = sc.nextInt();

         // Taking input from user
    // System.out.println("Enter the number of elements");
    // int n = sc.nextInt();
    // System.out.println("Enter the elements");
    // for(int i=0; i<n; i++)
    // {
    //     int s = sc.nextInt();
    //     o.add(s);
    // }
    // o.printList();
//----------------------------------------------------------------

    // Searching for an element in the Linked_List

    // System.out.println("Enter the element to be searched");
    // String s = sc.next();
    // o.search(s);

         o.add(1);
         o.add(5);
         o.add(7);
         o.add(3);
         o.add(8);
         o.add(2);
         o.add(3);
         System.out.println("Input Linked List");
          o.printList();
      
      //  Deleting all the nodes with value Greater than 25
    Node del=head;
while(del != null)
{
    if(del.data > val)
    { o.remove(del);
    //   o.printList();
    //   return;
    }
    
    del=del.next;
}

   
   System.out.println("\nOutput : ");
o.printList();
sc.close();
    }
}
