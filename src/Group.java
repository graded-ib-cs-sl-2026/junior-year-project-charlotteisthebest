import java.util.ArrayList;
import java.util.List;

public class Group {
    int uid; 
    // this is the id for each of the groups and it helps keep trakc of wich group is wich 
    int groupSize; 
    //  this is used to store the maximume students allowed for each group 
    List<Student> studentsInGroup = new ArrayList<>();
    // this list was created to hold all of the students that are being assigned to this group 
}  
