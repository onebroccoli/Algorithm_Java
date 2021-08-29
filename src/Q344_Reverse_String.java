/*
Write a function that reverses a string. The input string is given as an array of characters s.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


Follow up: Do not allocate extra space for another array.
You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Q344_Reverse_String {
    //Solution 1: Iterative
    //O(m*n)
    public void reverseString1(char[] s){
        if (s == null || s.length <= 1){
            return;
        }
       // char[] array = s.toCharArray();
        for (int left = 0, right = s.length - 1; left < right; left++,right--){
            swap(s, left, right);
        }

    }
    public void swap(char[] s, int left, int right){
        if (left >= right) return;
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }

    public static void main(String[] args){
        //test
        Q344_Reverse_String s = new Q344_Reverse_String();
        String a1 = "Hello World";
        char[] a = a1.toCharArray();
        s.reverseString1(a);
        System.out.println(a);
    }
}
