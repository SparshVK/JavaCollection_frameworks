import java.util.Scanner;
class LinkedList_scratch
{
    Node head;
    int size;
    LinkedList_scratch()
        {
            size = 0;
        }

    public class Node{
        String data;
        Node next;
    
        Node(String data){
        this.data=data;
        this.next=null;
        size++;
        }
    
    }

    

    public void addFirst(String data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

    public void addLast(String data){
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

    public void insert(int i, String data){   
      if(i<0 || i>size){
      System.out.println("Invalid size");
      return;  
    }

    size++;
      if(i == 0){
        addFirst(data);
        return;
       }

    Node newnode = new Node(data);
       Node n = head;
       for(int j=0; j<i-1; j++)
       {
        n=n.next;
       }
       newnode.next = n.next;
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

    public void removeFirst(){
 
        if(head == null)
        return;

        head = head.next;
        size--;
    
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
  public static void main(String[] args){   
    Scanner sc = new Scanner(System.in);
    LinkedList_scratch o = new LinkedList_scratch();
    o.addFirst("qwerty");
    o.addFirst("asdfgh");
    o.printList();
    o.insert(1,"f");
    //o.removeFirst();
    //o.removeLast();
    o.printList();


    sc.close();
  }
}