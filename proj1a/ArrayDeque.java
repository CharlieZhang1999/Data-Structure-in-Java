public class ArrayDeque<Heels> {
    private Heels [] array;

    //the index of front and last
    private int front, last;
    private int size;
    public ArrayDeque(){
        array = (Heels[]) new Object[8];
        size = 0;
        front = 0;
        last = 1;
    }
    public void addFirst(Heels x){
        if(size == array.length){
            resize(array.length*2);
        }
        array[front] = x;
        size = size + 1;
        front = front - 1;
    }
    public void addLast(Heels x){
         if(size == array.length){
             resize(array.length*2);
         }
         array[last] = x;
         size = size + 1;
         last = last + 1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for(int i = 0; i < this.size(); i++){
            System.out.println(array[i]);
        }
    }
    public Heels removeFirst(){
        front = front + 1;
        Heels heels = array[front];
        array[front] = null;
        size = size - 1;
        return heels;
    }
    public Heels removeLast(){
        last = last - 1;
        Heels heels = array[last];
        array[last] = null;
        size = size - 1;
        return heels;
    }
    public Heels get(int index){
        return array[index];
    }

    public void resize(int length){
        Heels[] a = (Heels[]) new Object[length];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }
}
