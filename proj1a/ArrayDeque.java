public class ArrayDeque<T> {
    private T[] array;

    //the index of front and last
    private int front, last;
    private int size;
    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        front = 0;
        last = 0;
    }
    public void addFirst(T x){
        if(size == array.length){
            resize(array.length*2);
            front = array.length-1;//since all the eg. first 8 fields are occupied, now front becomes 15
        }
        else if(isEmpty()){
            front = front;

        }
        else{
            front = front - 1;
            front = (front + array.length) % array.length;
            }

        array[front] = x;
        size = size + 1;

    }
    public void addLast(T x){

        if(size == array.length){
            resize(array.length*2);
            front = array.length-1;//since all the eg. first 8 fields are occupied, now front becomes 15
         }
        else if(isEmpty()){
            last = last;
        }
        else {
            last = last + 1;
            last = last % array.length;//to keep the last in the range
        }
        array[last] = x;
        size = size + 1;


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
        /*for(int i = 0; i < this.size(); i++){
            System.out.println(array[i]);
        }*/
        //for the first part
        for(int i = front; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println(array[0]);

        //for the last part
        for(int i = 1; i < last+1; i++){
            System.out.println(array[i]);
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T t =  array[front%array.length];
        array[front] = null;
        size = size - 1;
        if(!isEmpty()) {
            front = (front + 1) % array.length;
        }

        return t;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T t =  array[last];
        array[last] = null;
        size = size - 1;
        if(!isEmpty()) {
            last = last - 1;
            last = (last + array.length) % array.length;
        }

        return t;
    }
    public T get(int index){
        return array[index];
    }

    private void resize(int length){
        T[] a = (T[]) new Object[length];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

}
