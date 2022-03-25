class Solution {

    public boolean isAnagram(String s, String t) {
        s = sortstr(s);
        t = sortstr(t);
        return s.equals(t);
    }
    private String sortstr(String str) {
        return Stream.of(str.split("")).sorted().collect(Collectors.joining());
    }
}