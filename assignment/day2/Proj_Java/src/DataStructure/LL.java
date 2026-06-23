package DataStructure;

public class LL {
    Node head;
    Node tail;
    void pushBack(int data){
        Node n1 = new Node(data);
        if(head==null){
            head = n1;
            tail = n1;
        }else{
            tail.next = n1;
            tail=n1;
        }
    }
    void pushfront(int data){
        Node n1 = new Node(data);
        if(tail==null){
            tail = n1;
            head = n1;
        }else{
            n1.next = head;
            head = n1;
        }
    }
    void printforword(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    void search(int search){
        Node temp = head;
        boolean isfound = false;
        while(temp!=null){
            if(temp.data==search){
                isfound = true;
                break;
            }
            temp=temp.next;
        }
        if(isfound){
            System.out.println("found");
        }else{
            System.out.println("no found");
        }
    }
//    void printBackword(){
//        Node temp = tail;
//        while(temp!=null){
//            System.out.println(temp.data);
//            temp=temp.next;
//        }
//    }

    Node popfront(){
        head = head.next;
        return head;
    }


}
