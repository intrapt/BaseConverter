public class Main {

    public static void main(String[] args) {
        System.out.println(den2Bin(12));
        System.out.println(bin2Den("11111111"));
        System.out.println(bin2Hex("11111111"));
        System.out.println(hex2Bin("2D"));
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
        String hex = "";
        while (binary.length() % 4 != 0) binary = "0" + binary;
        String[] hexL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < binary.length(); i += 4) hex += hexL[bin2Den(binary.substring(i, Math.min(binary.length(), i + 4)))];
        return hex;
    }

    public static String hex2Bin(String hex) {
        String[] hexL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int nibble = 0;
        String binary = "";
        for (int i = 0; i < hex.length(); i++) {
            for (int j = 0; j < hexL.length; j++) {
                if (hexL[j].equals(hex.substring(i, i+1))) {
                    nibble = j;
                    for (int k = 0; k < 4; k++) {
                        if (nibble >= Math.pow(2, 3-k)) {
                            binary += "1";
                            nibble -= Math.pow(2, 3-k);
                        } else binary += "0";
                    }
                }
            }
        }
        return binary;
    }
}
