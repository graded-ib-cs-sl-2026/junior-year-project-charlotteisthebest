import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths; 

public class FileManager {
    public static List<String> readLines(String filePath){
        // this reads all the lines from the file and then it returns them as a list of strings 
      try { 
        Path path = Paths.get(filePath); 
        // this line takes a string and it creates an actual file path and stores it in the variable path 
       return Files.readAllLines(path); 
       // this basicaly reads every line of the file and then it returns it as a List<string> 
         } catch(Exception e) { 
            throw new RuntimeException("Failed to read file", e);
            // the catch expetion trys the method but if there is an exeption we go to the catch method and then we print out failed to read file
            // I learned how to do this before in my other project before I decided to redo it and have it have multiple classes 

         }
    }

    public static void writeLines(String filePath, List<String> lines){
        // this method basically write the list of  strings into a file 
        try {
            Path path = Paths.get(filePath); 
            // this converts the path string into the path object 
            Files.write(path,lines); 
            // this write all of the strings that where in the list into the file 
        } catch(Exception e){
            // what this does is that if there is any problem writing the file it will catch the error 
            throw new RuntimeException("Failed to write file", e);
            //  this just stops the programs and prints out the message "failed to write the file" if the file cant be written 
        }

    } 
}
