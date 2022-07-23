class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, List<String>> map = new HashMap<>();

        for (String word : words) {
            char init = word.charAt(0);
            if (map.containsKey(init)) {
                map.get(init).add(word);
            } else {
                List<String> list = new LinkedList<>();
                list.add(word);
                map.put(init, list);
            }
        }

        int ans = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                List<String> nextWords = map.get(c);
                List<String> listOfSubwords = new LinkedList<>();

                for (String word : nextWords) {
                    String subword = word.substring(1);

                    if (subword.isEmpty()) {
                        ans++;
                    } else {
                        listOfSubwords.add(subword);
                    }
                }
                map.remove(c);

                for (String subword : listOfSubwords) {
                    char init = subword.charAt(0);
                    if (map.containsKey(init)) {
                        map.get(init).add(subword);
                    } else {
                        List<String> list = new LinkedList<>();
                        list.add(subword);
                        map.put(init, list);
                    }
                }

            }
        }

        return ans;
    
    }
}