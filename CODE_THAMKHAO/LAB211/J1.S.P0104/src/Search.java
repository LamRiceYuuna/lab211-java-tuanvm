import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Search {
    private String getText(String mess) {
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

    public void search() {
        String file_name = getText("Enter the directory of file: ");
        try {
            File myFile = new File(file_name);
            Scanner sc_f = new Scanner(myFile);
            String txt = getText("Please enter string to search: ");
            int count = 0;
            while (sc_f.hasNextLine()) {
                String line = sc_f.nextLine();
                String arr[] = line.trim().split("\\s+");
                for (String word : arr) {
                    if (word.toLowerCase().contains(txt.toLowerCase())) {
                        count++;
                        if (count == 1) {
                            System.out.println("\nSearch results: ");
                        }
                        System.out.println(word);
                    }
                }

//                if (line.toLowerCase().contains(txt.toLowerCase())) {
//                    count++;
//                    if (count == 1) {
//                        System.out.println("\nSearch results: ");
//                    }
//                    System.out.println(line);
//                }
            }
            if (count == 0) {
                System.out.println("Not found '" + txt + "' in file");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        catch (NullPointerException e){
            System.out.println("Crashed file!");
        }
    }
}
