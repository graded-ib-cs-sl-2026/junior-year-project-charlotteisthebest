import java.util.Scanner;
// this allows me to read the input from the teacher 

public class InputManager {
    Scanner scanner = new Scanner(System.in); 
    // this line basically just creates a new scanner object wich I am going to use to get the input that the teacher type from the keyboard
    public String promptString(String message){
        // this basically just asks the teacher a question and then returns their answer
        System.out.println(message);
        // this just prints the message on the screen so that the teacher can read it  
        return scanner.nextLine().trim(); 
        // this just wait for the user to type something and then when they do it returns the answer and the .trim is so that it removes any spcaes 
    }   
}
