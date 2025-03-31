public class linkedlistispalindrome {
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
    void remove(int newidx){
        if(newidx==0){
            head=head.next;
        }
        node temp=head;
        for(int i=1;i<newidx-1;i++){
            temp=temp.next;}
            temp.next=temp.next.next;
            tail=temp;

    }
    static node findmid(node head){
        node slow=head;
        node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    boolean ispalidrome(){
        if(head==null && head.next==null){
            return true;

        }
        //find mid
        node mid=findmid(head);
        //reverse 2nd half of ll
        node curr=mid;
        node prev=null;
        node next;
        while(curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;

        }
        node right=prev;//right half head
        node left=head;//left half head
        //check left half right half
        while( right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;

        }
        return true;
    }
    public static void main(String[] args) {
        linkedlistispalindrome ll= new linkedlistispalindrome();
        ll.insertatbeigging(1);
        ll.insertattheend(2);
        ll.insertattheend(2);
        ll.insertattheend(1);
        ll.display();
        System.out.println(ll.ispalidrome());
    }
}
