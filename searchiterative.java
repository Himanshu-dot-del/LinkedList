public class searchiterative {
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
    int search(int key){
        node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;

            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    int helper(node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    int recursivesearch(int key){
        return helper(head, key);
    }

    public static void main(String[] args) {
        searchiterative ll= new searchiterative();
        ll.insertatbeigging(1);
        ll.insertattheend(2);
        ll.insertattheend(3);
        ll.insertattheend(4);
        ll.display();
        // System.out.println(ll.search(3));
        // System.out.println(ll.search(10));
        System.out.println(ll.recursivesearch(3));
        System.out.println(ll.recursivesearch(14));
       
        
    }
}
