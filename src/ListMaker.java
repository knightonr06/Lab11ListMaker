import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> lines = new ArrayList<>();
    final static String MENU_PROMPT = "A - Add D - Delete I - Insert P - Print Q - Quit";
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;

        String cmd;

        do {
            showList();
            showMenu();
            cmd = SafeInput.getRegExString(in, "Enter Menu Choice: ", "[AaDdIiPpQq]").toUpperCase();

            switch (cmd) {
                case "A":
                    System.out.println("Add Selected");
                    addItem();
                    break;
                case "D":
                    System.out.println("Delete Selected");
                    deleteItem();
                    break;
                case "I":
                    System.out.println("Insert Selected");
                    insertItem();
                    break;
                case "P":
                    System.out.println("Print Selected");
                    showList();
                    break;
                case "Q":
                    done = true;
                    break;
            }

        } while (!done);
    }

    private static void showList() {
        System.out.println("------------------------------------------------------------------");
        if (lines.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (String l : lines) {
                System.out.println(l);
            }
        }
    }
    private static void showMenu(){
        System.out.println("------------------------------------------------------------------");
        System.out.println(MENU_PROMPT);
        System.out.println("------------------------------------------------------------------");
    }

    private static void addItem(){
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
        lines.add(item);
    }

    private static void deleteItem(){
        if(lines.size() == 0){
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        int index = SafeInput.getRangedInt(in, "Enter item number to delete: ", 1, lines.size()) - 1;
        String removedItem = lines.remove(index);
        System.out.println("Removed: " + removedItem);
    }

    private static void insertItem(){
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert: ");
        int position = SafeInput.getRangedInt(in, "Enter position to insert at: ", 1, lines.size() + 1) - 1;
        lines.add(position, item);
    }
}
