import java.util.ArrayList;
import java.util.List;

/*
laicode 404. Factor Combinations
Given an integer number, return all possible
combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.

 */
public class FactorCombinations {
    public List<List<Integer>> combinations(int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(target, 2, cur, result);
        return result;
    }
    private void helper(int target, int start, List<Integer> cur, List<List<Integer>> result){
        for (int i = start; i * i <= target; i++){
            if (target % i == 0) {
                cur.add(i);
                cur.add(target / i);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                helper(target / i, i, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
 /*
 //laicode solution 看不懂
    public List<List<Integer>> combinations(int target){
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 1){
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(target, factors, 0, cur, result);
        return result;
    }

    private void helper(int target, List<Integer> factors, int index, List<Integer> cur, List<List<Integer>> result){
        if (index == factors.size()){
            if (target == 1){
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(target, factors, index + 1, cur, result);
        int factor = factors.get(index);
        int size = cur.size();
        while (target % factor == 0){
            cur.add(factor);
            target /= factor;
            helper(target, factors, index + 1, cur, result);
        }
        //remove the added element
        cur.subList(size, cur.size()).clear();
    }
    //find all factors of a number
    //如果寻找所有的factors, 只需要从2开始遍历，到integer的半数即可
    private List<Integer> getFactors(int target){
      List<Integer> factors = new ArrayList<>();
      for (int i = target / 2; i > 1; i--){
          if (target % i == 0){
              factors.add(i);
          }
      }
      return factors;
    }
*/
    public static void main(String[] args){
        FactorCombinations s = new FactorCombinations();
        int target = 24;
        List<List<Integer>> result = s.combinations(target);
        System.out.println(result);
    }
}
