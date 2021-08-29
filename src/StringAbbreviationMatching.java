/*
Laicode
292. String Abbreviation Matching

Word “book” can be abbreviated to 4, b3, b2k, etc.
Given a string and an abbreviation,
return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".
Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */
public class StringAbbreviationMatching {
    //Recursive
public boolean match(String input, String pattern){
    //assumption: input pattern are not null
    return helper(input, pattern, 0, 0);
}
private boolean helper(String s, String t, int si, int ti){ //s-original, t-target pattern
    //only when we run out of s and t at the same time, there is a match
    if (si == s.length() && ti == t.length()){
        return true;
    }
    //if we run out of one of s and t but there is still some
    //characters left for the other one, we cannot find the match
    if (si >= s.length() ||ti >= t.length()){
        return false;
    }
    //case 1. the current character in t is not a digit
    if (t.charAt(ti) < '0' || t.charAt(ti) >'9'){
        if (s.charAt(si) == t.charAt(ti)){
            return helper(s, t, si + 1, ti + 1);
        }
        return false;
    }
    //case 2: if the current character is a digit, need to find total number in the string
    int count = 0;
    while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9'){
        count = count * 10 + (t.charAt(ti) - '0');
        ti++;
    }
    return helper(s, t, si + count, ti);

}

    public static void main(String[] args){
        StringAbbreviationMatching s = new StringAbbreviationMatching();
        String a = "international";
        String target = "i3rna4al";
        boolean result = s.match(a, target);
        System.out.println(result);
    }
}
