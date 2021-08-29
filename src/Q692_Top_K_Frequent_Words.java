/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */

import java.util.*;

/*
Solution:


 */
public class Q692_Top_K_Frequent_Words {
    public String[] topKFrequent(String[] words, int k){
        //sanity check
        if (words.length == 0){
            return new String[0];
        }
        //get all the distinct strings as keys and their frequencies as values
        //the freqMap has at least size 1
        Map<String, Integer> freqMap = getFreqMap(words);
        //minHeap on the frequencies of the strings.
        //use Map.Entry as the element type directly so that all the operations are most efficient.
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //compare the frequencies, directly call the compareTo
                //method since the frequencies are represented by Integer.
                return o1.getValue().compareTo(o2.getValue());

            }
        });
        for (Map.Entry<String, Integer > entry : freqMap.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        //since the returned array requires the strings sorted by their frequencies,
        // use a separate helper method to do this operation
        return freqArray(minHeap);

    }
    private Map<String, Integer> getFreqMap(String[] words){
        Map<String, Integer> freqMap = new HashMap <>();
        //when possible, choose the most efficient way for Hash operations
        for (String s : words) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() -1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args){
        Q692_Top_K_Frequent_Words s = new Q692_Top_K_Frequent_Words();
        String[] words = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        int n = 2;
        String[] result = s.topKFrequent(words,n);
        System.out.println(Arrays.toString(result));

    }
}
