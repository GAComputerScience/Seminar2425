import java.util.Arrays;
public class AJList{
    private String[] arr;
    private int size; //logical

    public AJList(){
        this.arr = new String[10];
        this.size = 0;
    }

    public boolean add (String s){
        if(size + 1> this.arr.length){
            resize();
        }
        this.arr[size] = s; //what if all of them are filled
        this.size ++;
        return true;
    }

    //other add function

    public boolean add(int index, String s){
        if(size + 1> this.arr.length){
            resize();
        }
        for (int i = size; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[index] = s;
        this.size ++;
        return true;
    }

    public String get(int index){
        return this.arr[index];

    }
    public String set(int index, String s){
        String toRet = this.arr[index];
        this.arr[index] = s;
        return toRet;
    }

    public String remove(int index){
        String toRet = this.arr[index];
        for(int i = index; i<this.size-1; i++){
            arr[i] = arr[i+1];
        }
        this.arr[size -1] = null;
        size--;
        return toRet;
        //resize
    }
    public int indexOf(String s){
        for(int i = 0; i<this.size; i++){
            if (this.arr[i].equals(s)){
                return i;
            }
        }
        return -1;

    }
    public int size(){
        return this.size;
    }

    private void resize(){
        String[] arr1 = new String[this.arr.length+10];
        for(int i=0;i<this.size; i++){
            arr1[i] = this.arr[i];
        }
        this.arr = arr1;
    }

    public boolean contains(String s){
        for(int i=0;i<this.size;i++){
            if(this.arr[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return Arrays.toString(this.arr);
    }
}