import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Largest_And_Second_Largest {
    //the element class will be used to store the original value
    //in the array and all the values compared to it
    static class Element {
        int value;
        List<Integer> comparedValues;

        Element(int value) {
            this.value = value;
            this.comparedValues = new ArrayList<>();
        }
    }

    /*
  1. convert array to Element array
  2. largerLength is the left partition's length containing the larger values
    *after each round of comparison
    *for each round, the comparison is still doing for each
    of the indices pairs (i, largerLength - 1- i)
    *So that the larger elements are always on the left side
    * and the largerLength will be cut in half each round
    * larger length is obviously initiated by the array's length

    3. we will terminate when there is only one element left on the larger partition,
      and it has to be the largest value
      the second largest value is the largest value in its compared values

    4. compare each of the indices pairs (i, largerLength - 1- i);
      swap the larger values on the left side if necessary
      and put the smaller value into the larger value's compare values list
    */
    public int[] largestAndSecond(int[] array) {
        //Assumptions: array is not null, array.length >= 2
        //convert the original array to Element array
        Element[] helper = convert(array);
        int largerLength = array.length;
        while (largerLength > 1){
            compareAndSwap(helper, largerLength);
            largerLength = (largerLength + 1) / 2;
        }
        return new int[] {helper[0].value, largest(helper[0].comparedValues)};

    }

    private Element[] convert(int[] array){
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++){
            helper[i] = new Element(array[i]);
        }
        return helper;
    }

    private void compareAndSwap(Element[] helper, int largerLength){
        for (int i = 0; i < largerLength / 2; i++){
            if (helper[i].value < helper[largerLength - 1 - i].value){
                swap(helper, i, largerLength - 1- i);
            }
            helper[i].comparedValues.add(helper[largerLength - 1 - i].value);
        }
    }

    private void swap(Element[] helper, int left, int right){
        Element tmp = helper[left];
        helper[left] = helper[right];
        helper[right] = tmp;
    }

    private int largest(List<Integer> list){
        //this is guaranteed to be O(1)
        int max = list.get(0);
        //using Iterator is guaranteed to be O(1) traversing each of the elements in the list
        for (int num : list){
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args){
        Largest_And_Second_Largest s = new Largest_And_Second_Largest();
        int[] array = {1,3,4,2,4,5,6};
        int[] result = s.largestAndSecond(array);
        System.out.println(Arrays.toString(result));
    }
}
