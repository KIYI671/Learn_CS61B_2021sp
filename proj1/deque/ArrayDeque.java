package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size=0;
        nextFirst=items.length/2;
        nextLast=nextFirst+1;
    }

    public void addFirst(T item){
        if (size== items.length){
            resize(size*2);
        }
        items[nextFirst]=item;
        size+=1;
        if(nextFirst>0){
            nextFirst-=1;
        }else{
            nextFirst= items.length-1;
        }
    }

    public void addLast(T item){
        if (size==items.length){
            resize(size*2);
        }
        items[nextLast]=item;
        size+=1;
        if(nextLast== items.length-1){
            nextLast=0;
        }else{
            nextLast+=1;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i=1;i<=size;i++){
            int index=i+nextFirst;
            if(index>=items.length-1){
                index-= items.length;
            }
            System.out.printf(items[index].toString() + ' ');
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size<=0){
            return null;
        }
        if(items.length>=16 && size<= items.length/4 ){
            resize(items.length/4);
        }
        if(nextFirst== items.length-1){
            nextFirst=0;
        }else{
            nextFirst+=1;
        }
        size-=1;
        return items[nextFirst];
    }

    public T removeLast(){
        if(size<=0){
            return null;
        }
        if(items.length>=16 && size<= items.length/4){
            resize(items.length/4);
        }
        if(nextLast== 0){
            nextLast=items.length-1;
        }else{
            nextLast-=1;
        }
        size-=1;

        return items[nextLast];
    }

    public T get(int index){
        if (size<index){
            return null;
        }
        int i = nextFirst+1+index;
        if(i>= items.length){
            i-= items.length;;
        }
        return items[i];
    }

    private void resize(int capacity) {
        T[] t = (T[]) new Object[capacity];
        for(int i =0;i<size;i++){
            int j = nextFirst+i+1;
            if(j>=items.length){
                j-=items.length;
            }
            t[i]=items[j];
        }
        nextFirst=capacity-1;
        nextLast=size;
        items=t;
    }
}
