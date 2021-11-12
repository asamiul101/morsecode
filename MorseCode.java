/**
 * This MorseCode class contains all the members of this class.
 * This class contains  a non-default constructor.
 * This class contains two private member variables.
 * @author Samiul Ahmed
 */

public class MorseCode {
    private char character;
    private String encoding;

    /**
     * This is the non default constructor that contains two parameters
     * @param character char
     * @param encoding String
     * @throws Exception
     */
    public MorseCode(char character, String encoding) throws Exception {
        int valOfChar = character; // it contains the ascii value of character


        if (valOfChar < 32 || valOfChar > 90 || encoding.length() < 1) // this if loop checks if the characters are valid or not by looking at their ascii code
            throw new Exception("The character " + character + " is not a supported Morse character");
        else {
            this.character = character;
            this.encoding = encoding;
        }
    }

    /**
     * This is a setter method that writes the character
     * @param character char
     */
    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * This is a getter method that reads the character
     * @return char
     */
    public char getCharacter() {
        return character;
    }

    /**
     * This is a setter method that writes the encoding
     * @param encoding String
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * This is a getter method that reads the encoding
     * @return String
     */
    public String getEncoding() {
        return encoding;
    }

}
