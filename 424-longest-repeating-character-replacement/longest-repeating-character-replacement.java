class Solution {

    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (true) {

                int currMaxFreq = 0;

                // Find maximum frequency in current window
                for (int count : freq.values()) {
                    currMaxFreq = Math.max(currMaxFreq, count);
                }

                int windowSize = right - left + 1;

                // Characters that need to be replaced
                int replacements = windowSize - currMaxFreq;

                if (replacements <= k) {
                    break;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}