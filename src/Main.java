//This imports my java ulutis and my lists that I will need to use 
import java.util.*;

public class Main {
    // this delceares the main class 

    public static void main(String[] args) {
        // this is where everything starts running 
        InputManager input = new InputManager();  
        // here I am creating a new imput manager object so that I can ask the teacher for input like what groupsize they want or what file name they are looking for 
        String fileName = input.promptString("Enter File Name of Data"); 
       // this line asks the teacher to input that file name that has the lists of students wich is class3.txt 
       List<String> lines = FileManager.readLines(fileName); 
       // this reads all the files and then it stores it in the list string 
      Registration registration = new Registration();
      // this creates my new registration object wich is going to control the (splitting the students into groups)
      registration.groupSize = Integer.parseInt(input.promptString("Enter group size 3-4 recomended")); 
      // this basically prompts the teacher for a number and then converts it into an integer and save it to the registration.groupsize 
      // I struggled alot to be able to do this and I researched on the internet how to convert integers to string and It gave me an example with this model and I was able to implement it into my code 
      int i = 0; 
      // this is going to be used as an id for each student 
      List<String>data = new ArrayList<>();
      // the data list is going to be an empty array but when we run the code it will hold the final groups  


     
      String resultName = input.promptString("Enter File Name of results"); 
      // in this line of code I just ask the user where they want their code saved an example would be src/results 1 

      
      for(String line: lines){
        // this is a for each loop and basically what it does is it goes throuch each line in the list and each of the lines represents one
        // student from the input file 
        // I decicded to do a for loop when I got stuck on this project and asked chat what ideas he had to continue it suggestsed a for each loop
        // so I researched what a for each loop was watched https://www.youtube.com/watch?v=XUsRflQFL8c and read https://www.w3schools.com/java/java_foreach_loop.asp
        Student student =  new Student();
        // here I am just creating my new student object  
        student.name = line;
        // here what i am doing is basically setting the name of the student using the line from the file so like student.name = charloote 
        student.uid = i;
        // here I am assigning my students an id number 
        i++; 
        // this just increases my uid counter by 1 so that my next student also gets a uid 
        registration.studentList.add(student);  
        // this just adds the student that I just created into my student list that in my regitration object. 

      }
        while(true){
            // this creates an infinit loop 
            registration.groupStudents = new ArrayList<>();
            // what this does is it that it cleares the regestration.groupstudents every time before it generates the groups 
            registration.SplitGroups();
            // this pasically just shuffles the students and also assigns the students 
            data = new ArrayList<>();
            // the data basically replaces the existing list with with a bran new empty list wich is important because it is going to shuffle until the teacher says yes and is happy with their results 
           
                String person1 = input.promptString("enter the name of the first classmate that you would like to seperate"); 
                String person2 = input.promptString("enter the name of the second classmate that you would like to seperate"); 
                // this basically just asks the user which student they dont want to sit together 

                
                boolean bothFound = false; 
                // this sets up like a flag and assumes that the students are not found untill and will only change it to true if both the students are found together 
                
                for (Group group: registration.groupStudents){
                    // here I am looping through each grouo in my  lists to check if both of the students that i want seperated are seperated 
                    boolean person1InGroup = false;
                    // the person 1 in  group  will be set to true if found 
                    boolean person2InGroup = false;
                    // same thing with person 2 in group 

                    for (Student student: group.studentsInGroup){
                        // this loops check each student in the current group
                        if (student.name.equals(person1)){
                            person1InGroup = true; 
                            // basically if the first name you entered matches the students name then you change the person 1 in group to true 
                        }
                        if  (student.name.equals(person2)){
                            person2InGroup = true; 
                            // you do the same thing for this one 
                        }
                    }
                    if(person1InGroup == true  && person2InGroup == true){
                        // basically what this does is after checking the whole entire group is aks is this student with sitting next to this one if yes then we have a problem
                        // because the seperation rule is not working 
                        System.out.println("both names found"); 
                        // then we print the message that both names where found 
                       bothFound =true; 
                       //  then we set both found equal to true and that is going to reshuffle our list of names 
                       break;
                       // then I break out of the loop that i am in  
                    }
                }
                if (bothFound == true){
                    // so then after the group checking loop has finished we we set both found to true 
                    continue; 
                    // and if they are found then you use the continue to go back to the start of the loop triggering a new reshuffle 
                    // I used chat gpt to suggest to me how I can do this part but using a different example and it suggested the continue; 
                    // basically what the continue does is its a control flow statment and in this scenario it tells the code to skip everything and go back to the while loop and restart 
                }
                

        
          
            for (Group group: registration.groupStudents){
                // this if a for each loop that goes through every group that was created by the registration.splitGroup()
                // the regitration.groupstudents is the lists of all of my group object so basically its saying like for each group in the in the list do this 
                System.out.println("group " + group.uid);
                // this prints out the group id 
                for (Student student: group.studentsInGroup){
                    // this for loop goes through all of the current groups 
                    // and the group,studentsInGroup is basically as list of student objects that are being assigned to that group 
                    System.out.println(student.name); 
                    // this line prints out the name of each students one by one 
                }
              System.out.println("  "); 
              // I just implemented this line of code so that it is more neat when it gets printed out in the consile 
            
            }

            
            String response = input.promptString("Is this okay?? y/n");
            // this basically aks the teacher are you happy yes or no and the the answer is saved in my respone  
            if (response.equals("y") ){
                // this basically just checks if the teacher said y for yes 
                break;
                // and then if they said yes they leave the while loop 

            }
            else if (response.equals("n") ){
                System.out.println("trying again"); 
               // if the teacher type n for no the code prints out "try again" and then it reshuffles and tries again 
                
            }
            else {
                 System.out.println("choose y or n");
                 // I created this code to acount for it sombody type like a maybe or something basically what it is going to do is print out the message "choose yes or no"
                 // and the while loop will continue so that they can now type yes or no 
                }
            }

        
        
        
        for (Group group: registration.groupStudents){
            // this loop goes through each group in the groupStudents
            data.add("group " + group.uid);
            // this just helps us see when each group starts so that we can see it clearer in the console like group 0,group1 ext..
            for (Student student: group.studentsInGroup){
                // this loop goes through all of the loops in the current group 

                data.add(student.name); 
               // this just adds the student names to the data lists
            }
            data.add("  "); 
            // I just did this so that its neater in the console it so it doesnt print all the names like mashed together  
        
        }

        FileManager.writeLines(resultName, data); 
        // the write the final lists of the group into the file that the user gave 
       
      
        
    }
}

    
   