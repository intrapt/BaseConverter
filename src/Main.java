public class Main {

    public static void main(String[] args) {
        System.out.println(den2Bin(12));
        System.out.println(bin2Den("11111111"));
    }

    public static String den2Bin(int denary) {
        int[] bits = {128, 64, 32, 16, 8, 4, 2, 1};
        String binary = "";
        for (int i = 0; i < 8; i++) {
            if (denary >= bits[i]) {
                binary += "1";
                denary -= Math.pow(2, 7 - i);
            } else {
                binary += "0";
            }
        }
        while (binary.length() % 4 != 0) binary = "0" + binary;
        return binary;
    }

    public static int bin2Den(String binary) {
        int denary = 0;
        String bit = "";
        for (int i = 0; i < binary.length(); i++) {
            bit = binary.substring(i, i + 1);
            if (bit.equals("1")) {
                denary += Math.pow(2, binary.length() - i - 1);
            }
        }
        return denary;
    }

    public static String hex2Bin(String binary) {
        String hex = "";
        return hex;
    }

}
