
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        while (true) {
            //User input directory of file
            inputDirectoryFile();
            //User input string to search
            inputString();

        }

    }

    public static void inputDirectoryFile() {
        while (true) {
            String file_name = getText("Enter the directory of file: ");

            try {
                File myFile = new File(file_name);
                Scanner sc_f = new Scanner(myFile);
                while (sc_f.hasNextLine()) {
                    String line = sc_f.nextLine();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            } catch (NullPointerException e) {
                System.out.println("Crashed file!");
            }
        }
    }

    public static void inputString() {
        try {
            String txt = getText("Please enter string to search: ");
            
            String arr[] = line.trim().split("\\s+");
            int count = 0;
            for (String word : arr) {
                if (word.toLowerCase().contains(txt.toLowerCase())) {
                    count++;
                    if (count == 1) {
                        System.out.println("\nSearch results: ");
                    }
                    System.out.println(word);
                }
            }
        
        if (count == 0) {
            System.out.println("Not found '" + txt + "' in file");
        }
        }
        catch (NullPointerException e){
            System.out.println("Crashed file!");

    }
}


    private static String getText(String mess) {
        String txt = "";
        System.out.print(mess);
        Scanner sc = new Scanner(System.in);
        do {
            txt = sc.nextLine();
            if (!txt.trim().trim().equals("")) {
                return txt;
            }
            System.err.println("Can not be empty! Re-Enter: ");
        } while (true);
    }
}
