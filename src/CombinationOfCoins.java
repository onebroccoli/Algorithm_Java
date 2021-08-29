/*
73. Combinations Of Coins
Given a number of different denominations of coins
(e.g., 1 cent, 5 cents, 10 cents, 25 cents),
get all the possible ways to pay a target number of cents.

Arguments

coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99
Assumptions

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.
Return

a list of ways of combinations of coins to sum up to be target.
each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
Examples

coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
 */

import java.util.ArrayList;
import java.util.List;

/*
bfs
each combination is represented as a List<Integer> cur.
cur.get(i) = number of coins of coins[i]
all the combinations are stored in the result as List of List<Integer>
 */
public class CombinationOfCoins {
    //target: number of cents to reach
    //coins int[]: shows the coin value possibilities
    public List<List<Integer>> combinations(int target, int[] coins){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();  //temp stores one combination of current possibility
        helper(target, coins, 0, temp, result);
        return result;
    }

    private void helper(int target, int[] coins, int index, List<Integer> temp, List<List<Integer>> result){
        //when reach the end: 1. index = coins length -1, 2. no remain after divided by last coin value
        if (index == coins.length - 1){
            if (target % coins[coins.length - 1] == 0){
                temp.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            return;

        }

        //for coins[index] , we can pick 0, 1,2,3.... target/coins[index] coins
        //1. find max integer if divided by the current coin value
        //2. find remaining
        //3. call recursion function, target update to remaining value, index++
        //4. remember to modify the remaining cents for the next level
        int max = target / coins[index];
        for (int i = 0; i <= max; i++){
            temp.add(i);
            helper(target - i * coins[index], coins, index + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        CombinationOfCoins s = new CombinationOfCoins();
        int target = 99;
//        int[] coins = {1,5,10,25};
        int[] coins = {1,25};
        List<List<Integer>> result = s.combinations(target, coins);
        System.out.println(result);
    }
}
