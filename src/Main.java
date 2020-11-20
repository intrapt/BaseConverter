public class Main {

    public static void main(String[] args) {
        System.out.println(den2Bin(12));
        System.out.println(bin2Den("00001101"));
    }

    public static String den2Bin(int denary) {
        int[] bits = {64, 32, 16, 8, 4, 2, 1};
        String binary = "";
        for (int i = 0; i < bits.length; i++) {
            if (denary >= bits[i]) {
                if ((denary - bits[i]) >= 0) {
                    binary += "1";
                    denary -= bits[i];
                } else {
                    binary += "0";
                }
            } else {
                binary += "0";
            }
        }
        while (binary.length() % 4 != 0) binary = "0" + binary;
        return binary;
    }

    public static int bin2Den(String binary) {
        int denary = 0;
        String bin2 = "";
        int bit = 0;
        for (int i = binary.length(); i > 0; i--) bin2 += bin2 + binary.substring(i, i + 1);
        for (int i = 0; i < bin2.length(); i++) {
            if (binary.substring(i, i + 1) == "1") {
                denary += Math.pow(bit, 2);
            }
        }
        return denary;
    }

}
