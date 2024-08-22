class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z0-9]", "");
        String s2 = new StringBuilder(s).reverse().toString();

        if (s.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }
}