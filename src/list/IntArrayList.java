package list;

import exeptions.OutIndex;

import java.util.Arrays;
import java.util.Objects;

public class IntArrayList implements IntList {
    private Integer[] data;
    private int size;
    public IntArrayList(){
        data = new Integer[6];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void check(){
        if (size >= data.length){
            this.data = Arrays.copyOf(this.data, (int)(size * 1.5));
        }
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

    private void check_index(int index){
        if (index < 0 || index >= this.size){
            throw new OutIndex();
        }
    }

    @Override
    public void add(Integer item) {
        check();
        this.data[size] = item;
        size++;
    }

    @Override
    public void add(int index, Integer item){
        check();
        check_index(index);
        shift_up(index);
        this.data[index] = item;
        size++;
    }

    @Override
    public Integer get(int index){
        check_index(index);
        return this.data[index];
    }


    @Override
    public void set(int index, Integer item){
        check_index(index);
        this.data[index] = item;
    }

    @Override
    public void remove(int index){
        check_index(index);
        shift_down(index);
        size --;
    }

    @Override
    public boolean contains(Integer item){
        for (int i = 0; i < size; i++){
            if (Objects.equals(this.data[i], item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item){
        for (int i = 0; i < size; i++){
            if (Objects.equals(this.data[i], item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item){
        for (int i = size - 1; i >= 0; i--){
            if (Objects.equals(this.data[i], item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void clear(){
        this.data = new Integer[6];
        size = 0;
    }

    @Override
    public boolean equals(IntList otherList){
        for (int i = 0; i < size; i++){
            if (!this.data[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer[] toArray(){
        return Arrays.copyOf(this.data, this.size);
    }

    private IntList helpSort(IntList list){
        if (list.size() < 2){
            return list;
        }

        Integer temp = list.get(0);
        IntList maxList = new IntArrayList();
        IntList minList = new IntArrayList();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= temp){
                maxList.add(list.get(i));
            }
            if (list.get(i) < temp){
                minList.add(list.get(i));
            }
        }

        maxList = helpSort(maxList);
        minList = helpSort(minList);
        IntList sortedList = new IntArrayList();
        for (int i = 0; i < minList.size(); i++) {
            sortedList.add(minList.get(i));

        }
        sortedList.add(temp);
        for (int i = 0; i < maxList.size(); i++) {
            sortedList.add(maxList.get(i));
        }

        return sortedList;
    }

    @Override
    public void sort(){
        this.data = helpSort(this).toArray();
    }

    private IntList helpSortPaste(IntList list){
        for (int j = 0; j < list.size(); j++) {
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i = j; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                    index = i;
                }
            }
            Integer temp = list.get(j);
            list.set(j, min);
            list.set(index, temp);
        }
        return list;
    }

    @Override
    public void sortPaste(){
        data = helpSortPaste(this).toArray();

    }

    @Override
    public int binarySearch(Integer element){
        int low = 0;
        int high = this.size - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (this.data[mid] < element){
                low = mid + 1;
            }else if (this.data[mid] > element){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
