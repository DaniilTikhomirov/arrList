package list;

import exeptions.OutIndex;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringArrayList implements StringList{
    private String[] data;
    private int size;

    public StringArrayList(){
        data = new String[6];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void check(){
        if (size >= data.length){
            this.data = Arrays.copyOf(this.data, size + 6);
        }
    }

    private void check_index(int index){
        if (index < 0 || index >= this.size){
            throw new OutIndex();
        }
    }


    @Override
    public String add(String item) {
        check();
        this.data[size] = item;
        size++;
        return item;
    }

    private void shift_up(int index){
        for (int i = this.size; i > index; i--){
            this.data[i] = this.data[i - 1];
        }
    }

    private void shift_down(int index){
        for (int i = index; i < size; i++){
            this.data[i] = this.data[i + 1];
        }
    }

    @Override
    public String add(int index, String item){
        check();
        check_index(index);
        shift_up(index);
        this.data[index] = item;
        size++;
        return item;
    }

    @Override
    public String get(int index){
        check_index(index);
        return this.data[index];
    }

    @Override
    public String set(int index, String item){
        check_index(index);
        this.data[index] = item;
        return item;
    }

    @Override
    public String remove(String item){
        for (int i = 0; i < size; i++){
            if (this.data[i].equals(item)){
                shift_down(i);
                size --;
                return this.data[i];
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public String remove(int index){
        check_index(index);
        shift_down(index);
        size --;
        return this.data[index];
    }

    @Override
    public boolean contains(String item){
        for (int i = 0; i < size; i++){
            if (this.data[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item){
        for (int i = 0; i < size; i++){
            if (this.data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item){
        for (int i = size - 1; i >= 0; i--){
            if (this.data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(StringList otherList){
        for (int i = 0; i < size; i++){
            if (!this.data[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void clear(){
        this.data = new String[6];
        size = 0;
    }

    @Override
    public String[] toArray(){
        return Arrays.copyOf(this.data, this.size);
    }
}
