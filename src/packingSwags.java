import java.util.Arrays;

/*
use dp
n    0 1 2 3 4 5
M[n] 0 1 2 3 1 2

base M[0] = 0. M[1] = 1
induction rule:
Recursive Rule: dp[i] =min(dp[i - sqrt(i)] to dp[i - 1]) + 1M[i] = 1+M[i - 1]
 */
public class packingSwags {
    public int minBoxes(int num){
        int[] M = new int[num + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0; //when M[0] appears in induction rule, it means M[i] as a whole can be put into one single box
        for (int i = 1; i <= num; i++){
            for (int j = 1; j * j <= i; j++){//j*j as each 右小段
                M[i] = Math.min(M[i],M[i - j * j] + 1);
            }
        }
        return M[num];

    }

    public static void main(String[] args){
        packingSwags s = new packingSwags();
        int n = 10;
        int result = s.minBoxes(n);
        System.out.println(result);
    }
}
