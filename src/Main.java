public class Main {

    public static void main(String[] args) {
        System.out.println(den2Bin(12));
        System.out.println(bin2Den("11111111"));
        System.out.println(bin2Hex("11111111"));
    }

    public static String den2Bin(int denary) {
        String binary = "";
        for (int i = 0; i < 8; i++) {
            if (denary >= Math.pow(2, 7 - i)) {
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

    public static String bin2Hex(String binary) {
        String[] hexL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String hex = "";
        int j = 0;
        while (binary.length() % 4 != 0) binary = "0" + binary;
        for (int i = 0; i < binary.length(); i += 4)
            hex += hexL[bin2Den(binary.substring(i, Math.min(binary.length(), i + 4)))];
        return hex;
    }

}
