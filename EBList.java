public class EBList{
    private String[] array;
    //number of values (logical size)
    private int size;

    public EBList(){
        array = new String[10];
        size = 0;
    }

    public boolean add(String s){
        if (array.length>size){
            array[size] = s;
            size++;
            return true;
        }else{
            array = resize(array);
            array[size+1] = s;
            size++;
            return true;
        }
    }

    public boolean add (int index, String s){
        //if the index is too big return false
        //Otherwise, add at specified index and shift everything else to the right
        if (size<array.length){
            for (int i =index; i<size;i++){
                array[index+1] = array[index];
            }
            array[index] = s;
            size++;
            return true;
        }else{
            array= resize(array);
            for (int i =index; i<size;i++){
                array[index+1] = array[index];
            }
            array[index] = s;
            size++;
            return true;
        }

    }

    public String get(int index){
        if (index<size){
            return array[index];
        }else{
            return "This index is out of bounds";
        }
    }

    public String set (int index, String s){
        array[index] = s;
        return s;
    }

    public String remove (int index){
        String removed = array[index];
        if (index>-1 && index<=size){
            for (int i=index; i<size-1;i++){
                array[index] = array[index+1];
            }
            size--;
            return removed;
        }else{
            return "This index is out of bounds";
        }
    }

    public int indexOf(String s){
        for (int i =0; i<size;i++){
            if (array[i]!= null && array[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return size;
    }

    private String[] resize(String[] x){
        String[] add = new String[x.length+5];
        for (int i =0; i<x.length;i++){
            add[i] = x[i];
        }
        return add;
    }

    public boolean contains(String x){
        for (int i =0; i <size; i++ ){
            if (array[i].equals(x)){
                return true;
            }
        }
        return false;
    }

}