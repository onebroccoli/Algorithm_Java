import java.util.ArrayList;
import java.util.List;

/*
laicode 147. Restore IP Addresses

Given a string s containing only digits,
return all possible valid IP addresses that can be obtained from s.
You can return them in any order.

A valid IP address consists of exactly four integers,
each integer is between 0 and 255,
separated by single dots and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and
"0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.


 */

/*
goal:
find 4 valid subsetions,
valid IP address:
1. no leading zero
2. each number is between [1, 255]

use recursion and backtracking
1. taking snipets , 1-3 digits long, validating each of the snipet before moving on

 */
public class Q93_Restore_IP_Addresses {
    public List<String> Restore(String ip){
        List<String> result = new ArrayList<String>();
        if (ip == null || ip.length() == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(ip.toCharArray(), 0, 0, sb, result);
        return result;
    }

    private void helper(char[] ip, int level, int index, StringBuilder sb, List<String> result){
        //termination
        if (level == 4){
            if (sb.length() == ip.length + 4){
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        //case1: 1 digit
        if (index < ip.length){
            helper(ip, level + 1, index + 1, sb.append(ip[index]).append('.'), result);
            sb.delete(sb.length() - 2, sb.length());
        }
        //case 2: 2 digits
        if (index + 1 < ip.length){
            char a = ip[index];
            char b = ip[index + 1];
            if (a != '0'){
                helper(ip, level + 1, index + 2,sb.append(a).append(b).append('.'), result);
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        //case 3: 3digits
        if (index + 2 < ip.length){
            char a = ip[index];
            char b = ip[index + 1];
            char c = ip[index + 2];
            //符合条件的数字：
            //1. no leading zero
            //2. a = 1
            //3. a = 2
            //  1) b 在0-4之间
            //  2) b = 5, c 在0-5之间
            if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' & b == '5' && c >='0' && c <= '5'){
                helper(ip, level + 1, index + 3, sb.append(a).append(b).append(c).append('.'), result);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }

    public static void main(String[] args){
        Q93_Restore_IP_Addresses s = new Q93_Restore_IP_Addresses();
        String ip = "0122001";
        List<String> result = s.Restore(ip);
        System.out.println(result);
    }


}
