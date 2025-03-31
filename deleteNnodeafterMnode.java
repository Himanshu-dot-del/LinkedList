public class deleteNnodeafterMnode {
   
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
        void customdelete(int n,int m){
            node curr=head;
            node prev=null;
            int countm=m;
            int countn=n;
            node str1=null;
            boolean flag=true;//here true means no delteting storing
            while(curr!=null && n>0){
                if(countm==0){
                    flag=false;//false means deleting
                    countm=m;
                    str1=prev;
                }
                if(countn==0){
                    flag=true;
                    countn=n;
                    str1.next=curr;

                }
                if(flag){
                    countm--;
                }
                else{
                    countn--;
                }
                prev=curr;
                curr=curr.next;
            }
            if(countn!=n){
                str1.next=null;
            }
        }
        public static void main(String[] args) {
            deleteNnodeafterMnode ll = new deleteNnodeafterMnode();
            ll.insertatbeigging(5);
            ll.insertattheend(7);
            ll.insertattheend(9);
            ll.insertattheend(4);
            ll.insertattheend(10);
            ll.insertattheend(17);
            ll.display();
            ll.customdelete(2, 2);
            ll.display();
        }
    }

