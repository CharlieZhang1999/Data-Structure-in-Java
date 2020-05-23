public class ArrayDeque<T> {
    private T[] array;

    //the index of front and last
    private int front, last;
    private int size;
    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        front = 0;
        last = 1;
    }
    public void addFirst(T x){
        if(size == array.length){
            resize(array.length*2);
        }
        array[front] = x;
        size = size + 1;
        front = front - 1;
        if (front<0){
            front = front + array.length;
        }
    }
    public void addLast(T x){
         if(size == array.length){
             resize(array.length*2);
         }
        last = last % array.length;//to keep the last in the range
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
    public T removeFirst(){
        T t =  array[(front+1+array.length)%array.length];
        array[(front+1+array.length)%array.length] = null;
        front = (front + 1 + array.length) % array.length;
        size = size - 1;
        return t;
    }
    public T removeLast(){
        T t =  array[last-1];
        array[last-1] = null;
        last = (last - 1) % array.length;
        size = size - 1;
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
