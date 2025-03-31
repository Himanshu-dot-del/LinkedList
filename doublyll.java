public class doublyll {
    public static class   node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }
    static node head;
    static node tail;
    static int size;
    void display(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<-> ");
            temp=temp.next;

        }
        System.out.println("null");

    }
    void addfirst(int data){
        node temp=new node(data);
        size++;
        if(head==null){
            head=temp;
            tail=temp;
           
            return;
        }
        temp.next=head;
        head.prev=temp;
        temp.prev=null;
        head=temp;
    }
    void addlast(int data){
        node temp = new node(data);
        size++;
        if(head==null){
            head=temp;
            tail=temp;
            return;
        }
        tail.next=temp;
        temp.next=null;
        temp.prev=tail;
        tail=temp;
    }
     
     int removefirst(){
        if(head==null){
            System.out.println("empty");
            return -1;
        }
         if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
            

        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
       
        
     }
    int removelast(){
        if(head==null){
            System.out.println("empty");
            return -1;

        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next.prev=null;
        prev.next=null;
        tail=prev;
        size--;
        return val;


    }
    void reverse(){
        node curr=head;
        node prev=null;
        node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
     public static void main(String[] args) {
        doublyll dll = new doublyll();
        dll.addfirst(2);
        dll.addfirst(5);
        dll.addfirst(3);
        dll.addlast(9);
        dll.addfirst(10);
        dll.addlast(50);
         dll.removelast();
          dll.removefirst();
        System.out.println("original ll");
        dll.display();
        dll.reverse();
        System.out.println("after reverse");
        dll.display();
        
     }

}
