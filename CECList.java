import java.util.Arrays;
public class CECList{
    private String[] arr;
    private int size; //logical size

    public CECList(){
        arr = new String[10];
        size = 0;
    }
    public boolean add(String s){
        if(size >= arr.length){
            arr = resize(arr);
        }
        arr[size] = s;
        size++;
        return true;  // Should always return true
    }

    public boolean add(int index, String s){
        if(index > size || index < 0){  // make sure the index is valid
            return false;
        }
        if(size >= arr.length){
            arr = resize(arr);
        }
        //Shift elements to the right to make space for the new element
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = s;
        size++;
        return true;
    }

    public String get(int index){ //returns what is at the given index
        String toRet = arr[index];
        return toRet;
    }

    public String set(int index, String s){ //returns what was just removed
        String toRet = arr[index];
        arr[index] = s;
        return toRet;
    }

    public String remove(int index){ //returns what was just removed
        String toRet = arr[index];
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i+1]; //shift everything left
        }
        size--;
        return toRet;
    }

    public int indexOf(String s){
        int index = -1;
        for(int i = 0; i < size; i++){
            if(arr[i] == s){
                index = i;
            }
        }
        return index;
    }

    public int size(){ //just a getter
        return size;
    }

    public String toString(){ //overridden toString method, bc original toString() deals with actual arrays, not these unique array list objects
        String result = "["; // opening bracket
        for(int i = 0; i < size; i++){
            result += arr[i];
            if(i < size - 1){ //add comma
                result += ", ";
            }
        }
        result += "]"; // closing bracket
        return result;
    }

    private String[] resize(String[] x){
        String[] add = new String[x.length + 5];
        for(int i = 0; i < x.length; i++){
            add[i] = x[i];
        }
        return add;
    }
}