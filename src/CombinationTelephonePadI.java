/*
laicode
272. Combinations For Telephone Pad I
Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.

{0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}


Assumptions:

The given number >= 0
Examples:

if input number is 231, possible words which can be formed are:

[ad, ae, af, bd, be, bf, cd, ce, cf]
 */

/*

ABC        A__          B__           C__
        /  |  \       /  |  \       /  |  \
DEF   AD_ AE_ AF_   BD_ BE_ BF_   CD_ CE_ CF_
      /|\        /  |  \       /  |  \
GHI  ADG ADH ADI

Time: O(4^n) 取最差的4个字母的作为upperbound
Space:
 */
//public class CombinationTelephonePadI {
//
//
//
//    public static void main(String[] args){
//        CombinationTelephonePadI s = new CombinationTelephonePadI();
//        String[] result = s.combinations(234);
//        System.out.println(Arrays.toString(result));
//    }
//}
