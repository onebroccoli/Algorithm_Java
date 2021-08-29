/*
String Encoding / compressing
Given a string, replace adjacent, repeated characters with the character
followed by the number of repeated occurrences.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

Examples

“abbcccdeee” → “a1b2c3d1e3”
 */
public class CompressStringII {
    public String compress(String input){
        if (input == null |input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] input){
        //step 1: deal with the cases where the adjacent occurrence of the letters >= 2.
        int slow = 0; //left of slow record the characters that have been processed
        int fast = 0; //
        int newLength = 0;
        //set begin pointer, move fast to the end of the same character
        while (fast < input.length){
            int begin = fast;
            while (fast < input.length && input[fast] == input[begin]){
                fast++;
            }
            input[slow] = input[begin];
            slow++;
            //case 1: handle one character
            if (fast - begin == 1){ //if character only appear 1 time
                newLength += 2; // expand length 扩容
            } else {
                int len = copyDigits(input, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }
        //step2: deal with cases where adjacent occurence of the letters == 1
        //notice: if it is required to do this in place, usually the input array is a sufficient large one,
        //you will not need to allocate a new array. This solution is only for demonstration.
        char[] result = new char[newLength];
        fast = slow - 1; //move fast pointer to the end of processed character
        slow = newLength - 1;
        while (fast >= 0){
            if (Character.isDigit(input[fast])) {
                while (fast >= 0 && Character.isDigit(input[fast])) {
                    result[slow] = input[fast];
                    slow--;
                    fast--;
                }

            } else {
                result[slow] = '1';
                slow--;
            }
            result[slow] = input[fast];
            slow--;
            fast--;
        }
        return new String(result);
    }


    //copy "count" as digits into "input", starting at "index". 13
    //return length, and modify input array.
    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for (int i = count; i > 0; i /= 10){
            index++;
            len++;
        }
        for (int i = count; i > 0; i /= 10){
            int digit = i % 10;
            input[--index] = (char)('0' + digit);
        }
        return len;
    }

    public static void main (String[] args){
        CompressStringII s = new CompressStringII();
//        String a = "abbcccdeee";
        String a = "abcd";
        String res = s.compress(a);
        System.out.println(res);
    }
}
