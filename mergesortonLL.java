import java.util.LinkedList;

public class mergesortonLL {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;

        }
    }
    static node head;
    static node tail;
    static int size;
    void display(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-> ");
           // System.out.println(temp.next+" ");
            temp=temp.next;

        }
        System.out.println("null");

    }
    void insertatbeigging(int data){
        node temp=new node(data);
        size++;
        if(head==null){
            head=temp;
            tail=temp;
        }
        else{
           temp.next=head;
           head=temp;

        }
    }
    void insertattheend(int data){
        node temp = new node(data);
        size++;
        if(head==null){
            head=temp;
            tail=temp;
            return;
        }
        tail.next=temp;
        tail=temp;
    }
    
     node midindex(node head){
        node slow=head;
        node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
           
        }
        return slow;

    }
   node merge(node head1,node head2){
        node mergedll = new node(-1);
        node temp=mergedll;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
                
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }

        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
            
        }
        while(head2!=null){
            temp.next=head2;
                head2=head2.next;
                temp=temp.next;

        }
        return mergedll.next;

}
    
    public node mergesort(node head){
        if(head==null|| head.next==null){
            return head;
        }
          node mid=midindex(head);

          node righthead=mid.next;
          mid.next=null;
       
        
        node newleft= mergesort(head);
        node newright= mergesort(righthead);
        return merge(newleft,newright);
    }
    public static void main(String[] args) {
       mergesortonLL ll = new mergesortonLL();
       ll.insertatbeigging(5);
       ll.insertattheend(3);
       ll.insertattheend(10);
       ll.insertatbeigging(20);
       ll.insertattheend(1);
       System.out.println("before sorting");
       ll.display();
       System.out.println("after sorting");
       ll.head =ll.mergesort(ll.head);
       ll.display();

    }
}
