import java.util.*;

public class Two_sum_in_pairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        //assumption: array is not null and length >=2
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //key: number, value: list of all possible indices
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < array.length; i++){
            List<Integer> indices = map.get(target - array[i]);
            //if target - array[i] is in the map
            //we can get all the pairs (j, i), with i as the larger index
            if (indices != null){
                for (int j : indices){
                    result.add(Arrays.asList(j, i));
                }
            }
            //add current index i to all the possible indices for value of array[i]
            if (!map.containsKey(array[i])){
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Two_sum_in_pairs s = new Two_sum_in_pairs();
        int[] array = {1, 2, 3, 4, 5, 6};
        int target = 5;
        List<List<Integer>> result = s.allPairs(array, target);
        System.out.println(result);
    }
}