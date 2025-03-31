public class linkedlistiscycleoront {
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
    boolean iscycle(){
        node slow=head;
        node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    // REMOVE A CYCLE LINKEDLIST

    void removecycle(){
        //detect cycle
        node slow=head;
        node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;

            }
        }
        if(cycle==false){
            System.out.println("cycle not exist");
            return;

        }
        //find meeting point
        slow=head;
        node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;

        }
        // make lastidx next as null
        prev.next=null;
       
    }
    public static void main(String[] args) {
        linkedlistiscycleoront ll = new linkedlistiscycleoront();
        head=new node(1);
        node temp = new node(2);
        head.next=temp;
        head.next.next=new node(3);
        head.next.next.next=temp;
        //ll.display();
        System.out.println(ll.iscycle());
        System.out.println("ll after removal of cycle");
        ll.removecycle();
        System.out.println(ll.iscycle());

        
    }
}
