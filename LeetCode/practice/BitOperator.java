public class BitOperator {
    static private final String INVALID_STRING = "Input is invalid";

    static public int convertToInteger(String numStr) {
        int result = 0;
        int base = 10;
        int index = 0;
        int sign = 1;

        if (numStr.startsWith("-")) {
            sign = -1;
            index = 1;
        }

        if (numStr.startsWith("0x", index) || numStr.startsWith("0X", index)) {
            base = 16;
            index = 2;
        }

        int len = numStr.length();
        for (int i = index; i < len; i++) {
            char digit = numStr.charAt(i);
            int digitValue = -1;

            if ('0' <= digit && digit <= '9') {
                digitValue = digit - '0';
            } else if ('A' <= digit && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else if ('a' <= digit && digit <= 'f') {
                digitValue = digit - 'a' + 10;
            } else {
                throw new IllegalArgumentException(INVALID_STRING);
            }

            result = result * base + digitValue;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        int result1 = BitOperator.convertToInteger("123412341234123412341234");
        System.out.println("Kết quả 1: " + result1);

        int result2 = BitOperator.convertToInteger("-123");
        System.out.println("Kết quả 2: " + result2);
    }
}
