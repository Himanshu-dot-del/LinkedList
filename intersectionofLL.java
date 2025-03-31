import java.util.*;

public class intersectionofLL {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            
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
    int length(node head){
        node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;

        }
        return cnt;
    }
   
     node intersection(node head1,node head2){
        while(head2!=null){
            node temp=head1;
            while(temp!=null){
                if(temp==head2){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;

      

    }
    node optimizedintersection(node head1,node head2){
        node curr1=head1;
        node curr2=head2;
        int len1=length(head1);
        int len2=length(head2);
        int d=Math.abs(len1-len2);
        if(len1>=len2){
            while(d>0){
                curr1=curr1.next;
                d--;
            }
        }
        else{
            while(d>0){
                curr2=curr2.next;
                d--;
            }
        }
        boolean flag=false;
        while(curr1!=null && curr2!=null){
            if(curr1==curr2){
                flag=true;
                break;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return flag?curr1:null;
    }

    public static void main(String[] args) {
      intersectionofLL ll = new intersectionofLL();
      node head1,head2;
      head1=new node(10);
      head2=new node(3);
      node newnode =new node(6);
      head2.next=newnode;
      newnode = new node(9);
      head2.next.next=newnode;
      newnode=new node(15);
      head1.next=newnode;
      head2.next.next.next=newnode;
      newnode=new node(30);
      head1.next.next=newnode;
      head1.next.next.next=null;
    //   node ans=ll.intersection(head1, head2);
    //   if(ans==null){
    //     System.out.println("no intersection point");
    //   }
    //   else{
    //     System.out.println("intersection point ="+ans.data);
    //   }
    node ans=ll.optimizedintersection(head1, head2);
      if(ans==null){
        System.out.println("no intersection point");
      }
      else{
        System.out.println("intersection point ="+ans.data);
      }
    
      



    }
}
