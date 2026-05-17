class Solution {
    public int myAtoi(String s) {
        if (BadSigns(s))
            return 0;
        boolean numReaded = false;

        int i = 0;
        boolean isNegative = false;
        long res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        while (i < s.length()) {
            if (i < s.length() && numReaded && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                break;
            }
            if (s.charAt(i) == ' ') {
                break;
            }

            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            if (i < s.length() && s.charAt(i) == '+') {
                i++;
            } else if (i < s.length() && s.charAt(i) == '-') {
                isNegative = true;
                i++;
            }
            if (i < s.length() && s.charAt(i) == ' ') {
                break;
            }
            while (i < s.length() && !numReaded && s.charAt(i) == '0') {
                numReaded = true;
                i++;
            }
            if (i < s.length() && (Character.isLetter(s.charAt(i)) || s.charAt(i) == '.' || s.charAt(i) == '-')) {
                break;
            }

            if (i < s.length() && numReaded && s.charAt(i) == ' ')
                break;
            if (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int val = s.charAt(i) - '0';
                res = (long) ((res * 10) + val);
                if (res > Integer.MAX_VALUE) {
                    if (isNegative)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                numReaded = true;
            }
            i++;
        }
        if (String.valueOf(res).length() > 10) {
            if (isNegative)
                return Integer.MIN_VALUE;
            else {
                return Integer.MAX_VALUE;
            }
        }

        if (isNegative) {
            res = -res;
        }
        System.out.println(res);
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) res;
    }

    public static boolean BadSigns(String s) {
        int sign = 0;
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '+' || ch == '-') {
                sign++;
                if (num == 0 && sign > 1)
                    return true;
            } else if (ch >= '0' && ch <= '9') {
                num++;
            }
        }
        return false;
    }

}