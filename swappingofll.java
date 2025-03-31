public class swappingofll {
    
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
    void swapping(int x,int y){
       if(x==y){
        return;
       }
       node currx=head;
       node prevx=null;
       while(currx!=null && currx.data!=x){
        prevx=currx;
        currx=currx.next;
       }
       node curry=head;
       node prevy=null;
       while(curry!=null && curry.data!=y){
        prevy=curry;
        curry=curry.next;
       }
       if(currx==null && curry==null){
        return;
       }
       if(prevx!=null){
        prevx.next=curry;
    }
       else{
        head=curry;
       }
       if(prevy!=null){
        prevy.next=currx;
       }
       else{
        head=currx;
       }
       node temp=currx.next;
       currx.next=curry.next;
       curry.next=temp;
 }
    public static void main(String[] args) {
        swappingofll ll = new swappingofll();
        ll.insertatbeigging(5);
        ll.insertattheend(7);
        ll.insertattheend(10);
        ll.insertattheend(15);
        ll.insertattheend(13);
        ll.insertattheend(11);
        ll.display();
        ll.swapping(10, 13);
        ll.display();
    }
}
