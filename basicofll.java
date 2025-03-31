public class basicofll {
    public static class   node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }

    }
    static node head;
    static node tail;
    public static void main(String[] args) {
        node a = new node(1);
        node b = new node(2);
        node c = new node(5);
        node d = new node(8);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        System.out.println(a.data);
        System.out.println(b.next.data);
        System.out.println(d.next);

        
    }
}
