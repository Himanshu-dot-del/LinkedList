public class reverselinkedlist {
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
    void insertatanyindex(int data,int idx){
      
        if(idx==0){
            insertatbeigging(data);
            return;
        }
        node t = new node(data);
        size++;
        node temp=head;
        int i=0;
        while (i<idx-1) {
            temp=temp.next;
            i++;
            
        }
        t.next=temp.next;
        temp.next=t;
    }
    void reverse(){
        node prev=null;
        node curr=tail=head;
        node next;
        while(curr!=null){
            next=curr.next;
           curr.next=prev;
            prev=curr;
            curr=next;
        }
         head=prev;
    }
    public static void main(String[] args) {
      reverselinkedlist ll=new reverselinkedlist();
      ll.insertatbeigging(1);
      ll.insertattheend(2);
      ll.insertattheend(3);
      ll.insertattheend(4);
      System.out.println("original linked list");
      ll.display();
      System.out.println("linked list after reverse");
      ll.reverse();
      ll.display();
    }
}
