public class functionsofll {
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
    // void size(){
    //     node temp=head;
    //     int cnt=0;
    //     while(temp!=null){
    //         cnt++;
    //         temp=temp.next;
    //     }
    //     System.out.println("size of linked list is :"+cnt);
    // }

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
    int removefirst(){
        if(size==0){
            System.out.println("ll is empty");
            return -1;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    int removelast(){
        if(size==0){
            System.out.println("ll is empty");
            return -1;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        node prev=head;
       for(int i=0;i<size-2;i++){
       prev=prev.next;
       }
       int val=prev.next.data;
       prev.next=null;
       tail=prev;
       size--;
       return val;

        
    }
    void deleteAt(int idx){
        if(idx==0){
            head=head.next;
        }
        node temp=head;
        for(int i=1;i<=idx-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        tail=temp;
    }

        
    
    public static void main(String[] args) {
        functionsofll ll = new functionsofll();
        ll.display();
        ll.insertatbeigging(1);
        ll.insertattheend(5);
        ll.insertatbeigging(10);
        ll.insertatanyindex(9, 3);
        System.out.println("before deletion");
        ll.display();
       // ll.removefirst();
       // ll.removelast();
       ll.deleteAt(2);
        System.out.println("after deletion");
        ll.display();
        System.out.println("size of linked list : "+" " +size);
        //ll.size();
        
    }
    
}
