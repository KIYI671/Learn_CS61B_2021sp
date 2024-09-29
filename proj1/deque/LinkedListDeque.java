package deque;

public class LinkedListDeque<T> {
    private class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T t,IntNode n,IntNode p){
            item=t;
            next=n;
            prev=p;
        }
    }

    private int size;
    private IntNode sentinel;

    public LinkedListDeque(){
        sentinel = new IntNode(null, null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size = 0;
    }

    public void addFirst(T item){
        IntNode i= new IntNode(item,sentinel.next,sentinel);
        sentinel.next.prev=i;
        sentinel.next=i;
        size+=1;
    }

    public void addLast(T item){
        IntNode i=new IntNode(item,sentinel,sentinel.prev);
        sentinel.prev.next=i;
        sentinel.prev=i;
        size+=1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(size>0) {
            IntNode n=sentinel;
            while(n.next!=sentinel){
                System.out.printf(n.next.item+" ");
                n=n.next;
            }
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size>0){
            IntNode t = sentinel.next;
            sentinel.next=t.next;
            t.next.prev=sentinel;
            size-=1;
            return t.item;
        }else{
            return null;
        }
    }

    public T removeLast(){
        if(size>0){
            IntNode t = sentinel.prev;
            sentinel.prev=t.prev;
            t.prev.next=sentinel;
            size-=1;
            return t.item;
        }else{
            return null;
        }
    }

    public T get(int index){
        if(index>=size){
            return null;
        }
        IntNode n=sentinel.next;
        while(index>0){
            n=n.next;
            index-=1;
        }
        return n.item;
    }

    public T getRecursive(int index){
        if(index>=size){
            return null;
        }
        IntNode n=sentinel.next;
        return recursive(index,n);
    }

    private T recursive(int index, IntNode n) {
        if(index==0){
            return n.item;
        }
        return recursive(index-1,n.next);
    }
}
