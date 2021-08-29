/*
Laicode 85. Determine If One String Is Another's Substring
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
 */

/*
Solution:
1. corner case: 1) large string cannot be shorter than small string, or return -1
                2) if small string length == 0 return 0
2. large string >= small string
    *need to iterate the pointer with index from [0, large length - short length]
    * at each pointer's position, iterate each element of short string, return false if not equal
 */
public class DetermineSubstring {
    public static int strstr(String large, String small){
        //corner case
        if (large.length() < small.length()){
            return -1;
        }
        //return 0 if small is empty
        if (small.length() == 0){
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++){
            if (equals(large, i, small)){
                return i;
            }
        }
        return -1;
    }

    public static boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        DetermineSubstring s = new DetermineSubstring();
        String al = "bcabc";
        String as = "ab";
        int res1 = s.strstr(al, as);
        System.out.println("long = bcabc and short = ab, return ");
        System.out.println(res1);
    }
}
