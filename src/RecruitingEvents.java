import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: capital letter for universities
Output: all possible schdeuls

Example:
Input: "ABC"
Output: ABC, ABxC, AxBC, AxBxC
 */
/*
Solution:
length n
level: n-1
how many different stats should we try to put on this level? 2, either yes or not

 */
public class RecruitingEvents {
    public List<String> events(String a){
        List<String> result = new ArrayList<String>();
        char[] arraySet = a.toCharArray();
        int len = arraySet.length;
        char[] tmp = new char[2*len];
        tmp[0] = arraySet[0];
        helper(arraySet, tmp,1,1,len, result);
        return result;

    }
    private void helper(char[] arraySet, char[] tmp, int i, int j, int len,List<String> result){
        if (i == len){
            result.add(String.valueOf(tmp));
            return;
        }


        //no space
        tmp[j] = arraySet[i];
        helper(arraySet, tmp, i + 1, j + 1, len, result);

        //with space
        tmp[j] = 'x';
        tmp[j + 1] = arraySet[i];
        helper(arraySet, tmp, i + 1, j + 2, len, result);
    }

    public static void main(String[] args) {
        RecruitingEvents s = new RecruitingEvents();
        String a = "abc";
        System.out.println("input is: " + a);
        List<String> result1 = s.events(a);
        System.out.println(result1);
    }
}
