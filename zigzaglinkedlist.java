import java.util.LinkedList;

public class zigzaglinkedlist {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
           // this.next=null;
        }
    }
    static node head;
    static node tail;
    static int size;
    void display(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
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
  static  node findmid(node haed){
        node slow=head;
        node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
   static void zigzg(){
        //find mid (last elemnt of 1st half)
        node mid=findmid(head);
        //reverse the 2nd half
        node curr=mid.next;
        mid.next=null;
        node prev=null;
        node next;
        
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //alternate merging
        node lh=head;
        node rh=prev;
        node nextl;
        node nextr;
        while(lh!=null && rh!=null){
            nextl=lh.next;
            lh.next=rh;
            nextr=rh.next;
            rh.next=nextl;
            lh=nextl;
            rh=nextr;
        }
    }
    public static void main(String[] args) {
       zigzaglinkedlist ll = new zigzaglinkedlist();
       ll.insertatbeigging(5);
       ll.insertatbeigging(9);
       ll.insertatbeigging(4);
       ll.insertatbeigging(10);
       ll.insertatbeigging(15);
       ll.insertatbeigging(7);
       System.out.println("original ll");
       ll.display();
       System.out.println("zig zag ll");
       zigzg();
       ll.display();
      

    }
}
