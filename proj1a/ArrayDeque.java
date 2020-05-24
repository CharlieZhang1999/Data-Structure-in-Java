public class ArrayDeque<T> {
    private T[] array;

    //the index of front and last
    private int nextFirst, nextLast;
    private int size;
    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int minusOne(int index){
        if(index==0){
            return array.length-1;
        }
        return index - 1;
    }

    private int plusOne(int index){
        if(index == array.length - 1){
            return 0;
        }
        return index + 1;
    }

    public void addFirst(T x){
        if(size == array.length){
            resize(size*2);
        }
        array[nextFirst] = x;
        size = size + 1;
        nextFirst = minusOne(nextFirst);

    }
    public void addLast(T x){

        if(size == array.length){
            resize(size*2);
         }


        array[nextLast] = x;
        size = size + 1;
        nextLast = plusOne(nextLast);

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
        int index = this.plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(array[index] + " ");
            index = this.plusOne(index);
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T item =  array[plusOne(nextFirst)];
        nextFirst = plusOne(nextFirst);
        size = size - 1;
        if(size < array.length/4 & array.length > 16){
            resize(size * 2);
        }
        return item;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T item =  array[minusOne(nextLast)];
        nextLast = minusOne(nextLast);
        size = size - 1;
        if(size < array.length/4 & array.length > 16){
            resize(size * 2);
        }
        return item;
    }
    public T get(int index){
        if (index >= size) {
            return null;
        }
        int pos = plusOne(nextFirst);
        for(int i = 0; i < index; i++){
            pos = plusOne(pos);
        }
        return array[pos];
    }

    private void resize(int length){
        T[] a = (T []) new Object[length];
        int pos = this.plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = array[pos];
            pos = this.plusOne(pos);
        }
        nextLast = size;
        nextFirst = length - 1;
        array = a;

    }

}
