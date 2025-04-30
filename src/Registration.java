import java.util.List;
import java.util.ArrayList;
// I imported this in order to be able to use my lists 
import java.util.Collections; 
// I imported this in order to be able to use the shuffle in order to shuffle my student lists 

public class Registration {
    // this defines my class wich  I named regerastion 
    int uid; 
    // this is the id for my students 
    List<Student> studentList = new ArrayList<>();
    //  this list keeps all of my student before the grouping 
    List<Group> groupStudents = new ArrayList<>(); 
    // this is the list keeps all of my groups after they are split  
    
    int groupSize = 3;
    // i set a defualt number for my groups 
    int studentCount = 1;
    // here i did the same thing but for the student count 
    int numberOfGroups = 4;
    // also did the same thing but for numberofgroups  

    public void SplitGroups(){
        // this is the method that I created in order to devide my students into groups 
         studentCount = studentList.size();
         // This makes me actually get the number of students in my list
         numberOfGroups = studentCount/groupSize;
         // This calculates how many full groups can be formed and in the next line of code I calculate the remainder of students left over 
         int remainder = studentCount % groupSize;
         // this basically counts the remainder to check if there are any students that didnt fit into the orginal groups 
         if (remainder != 0){
            numberOfGroups ++; 
            // this basically says if the ramainder is not equal to zero meaning there is a remainder then add one more group to fit everyone 

       
         }
        Collections.shuffle(studentList);
        // this randomizes my list of students for the teacher 
        
        for (int i = 0;i<numberOfGroups;i++){
            Group group = new Group();
            group.uid = i; 
            groupStudents.add(group);
            // this initiliazes the groups with the ids of group and then adds them to the groupstudents 
        }
        int i = 0; 
        int groupNumber = 0;
        int groupLocation = 0;   
        while (i<studentCount){
            groupStudents.get(groupNumber).studentsInGroup.add(studentList.get(i));
            // this basically creates a new group, gives it a id and then it ads it to the group students list
            groupLocation ++; 
            if (groupLocation ==groupSize ){
                groupNumber++; 
                groupLocation = 0; 
                // this code just means that if the current group if full to move to the next group 
            }
            i++; 
            // this just makes sure that the loop is continuing 
        }  
        
     
    }
}
