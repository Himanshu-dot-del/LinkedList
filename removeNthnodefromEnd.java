public class removeNthnodefromEnd {
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
    void removeNthnodefromlast(int idx){
        int newidx=(size-idx+1);
        remove(newidx);
        size--;

    }
    public static void main(String[] args) {
        removeNthnodefromEnd ll = new removeNthnodefromEnd();
        ll.insertatbeigging(1);
        ll.insertattheend(2);
        ll.insertattheend(3);
        ll.insertattheend(4);
        ll.insertattheend(5);
        ll.display();
        System.out.println("size before deletion" +" "+size);
        ll.removeNthnodefromlast(3);
        System.out.println("after deletion");
       
        ll.display();
        System.out.println("size after deletion"+" " +size);
        
    }
}
