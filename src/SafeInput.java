
// SafeInput.java
import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getRegExString(Scanner sc, String prompt, String regEx) {
        Pattern p = Pattern.compile(regEx);
        String input;
        while (true) {
            System.out.print(prompt + " ");
            input = sc.nextLine().trim();
            if (p.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Invalid entry. Must match pattern: " + regEx);
            }
        }
    }

    public static int getRangedInt(Scanner sc, String prompt, int low, int high) {
        while (true) {
            System.out.print(prompt + " (" + low + "-" + high + "): ");
            String line = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val >= low && val <= high) {
                    return val;
                } else {
                    System.out.println("Number out of range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer.");
            }
        }
    }

    public static String getNonZeroLenString(Scanner sc, String prompt) {
        String s;
        while (true) {
            System.out.print(prompt + " ");
            s = sc.nextLine();
            if (s != null && s.trim().length() > 0) {
                return s;
            } else {
                System.out.println("Entry required (cannot be empty).");
            }
        }
    }

    public static boolean getYNConfirm(Scanner sc, String prompt) {
        String ans = getRegExString(sc, prompt + " (Y/N):", "[YyNn]");
        return ans.equalsIgnoreCase("Y");
    }
}
