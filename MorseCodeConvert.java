import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This MorseCodeConvert class contains one private member variable and many methods.
 */
public class MorseCodeConvert {

    private final ArrayList<MorseCode> morse_Codes = new ArrayList<MorseCode>(); //creates a new private ArrayList

    /**
     * This is a non-default constructor
     * @param nameOfFile String
     */
    public MorseCodeConvert(String nameOfFile) {

        try ( Scanner scanner = new Scanner(new FileInputStream(nameOfFile))){ //this try blockers functions as autoCloser.

            while (scanner.hasNext()) { //loops itself until there is no nextLine
                String next_line = scanner.nextLine();

                String[] list = next_line.split("\t"); //the split method separates the strings into many little characters and strings and store them into arrays

                if (list.length == 2) { // it checks if an array contain only one element or not

                    try {
                        MorseCode x = new MorseCode(list[0].charAt(0), list[1]);
                        morse_Codes.add(x);
                    }
                    catch (Exception e) {
                        System.out.println(e.toString()); //it prints out exceptions as strings
                    }
                }
                else
                    System.out.printf("%s%s%n","Invalid line: " , next_line); //prints if there exists any invalid lines
            }
        }
        catch (FileNotFoundException e) {
            System.out.printf("%s%s%n", "Failed to open file: " , nameOfFile);
        }

    }

    /**
     * This method prints out the ArrayList
     */
    public void printEncodingList() {
        for(MorseCode k : morse_Codes)
            System.out.println(k.getCharacter() + "  =>  " + k.getEncoding());
    }


    /**
     * This method encoded the strings into morse code.
     * @param str String
     * @throws NullPointerException Exception
     */
    public void encodeString(String str) throws NullPointerException{
        try {
            for (int i = 0; i < str.length(); i++) {
                Character c1 = str.charAt(i); //saves the characters into the c1


                if (c1 >= 97 && c1 <= 122) // this if loop checks if the characters are alphabets or not.
                    c1 = Character.toUpperCase(c1); //if they are alphabets then make them into capital letters

                int k = c1; //sorts the ascii value of c1 into k


                if (k < 32 || k > 90)
                    System.out.print("?"); // it prints out "?" if the ascii value is invalid
                else {
                    for (MorseCode m : morse_Codes) {

                        if (m.getCharacter() == c1) { // it checks if c1 is inside ArrayList<MorseCode>morse_codes

                            System.out.print(m.getEncoding() + " ");
                            break;
                        }
                    }
                }
            }
            System.out.print("\n"); // goes to a new line
        }

        catch (NullPointerException e) {
            System.out.println("Null strings are not accepted"); // it prints out if there is a null value
        }
    }

    /**
     * This method encodes a file into morse code
     * @param s String
     * @throws FileNotFoundException Exception
     */
    public void encodeFile(String s) throws FileNotFoundException {

        try (Scanner fileInput = new Scanner(new FileInputStream(s))){ //try block here works as autoCloser

            while (fileInput.hasNext()) { //if there is next element invoke the method
                String nextLine = fileInput.nextLine();
                System.out.printf("%s%s%n" , nextLine, " ");
                encodeString(nextLine);
            }
        }
        catch (FileNotFoundException ef) {
            System.out.printf("%s%n","Attempt to open file"); // it handles the FileNotFoundException
        }

    }
}
