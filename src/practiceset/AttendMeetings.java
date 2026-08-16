package practiceset;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendMeetings {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<Integer>() {{add(0); add(30);}});
        intervals.add(new ArrayList<Integer>() {{add(15);add(20);}});
        intervals.add(new ArrayList<Integer>() {{add(5);add(10);}});
        System.out.println(can_attend_all_meetings(intervals));

        intervals.sort((a,b)->a.get(0).compareTo(b.get(0)));
    }

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        // Write your code here.
        intervals.sort((a,b)-> a.get(0).compareTo(b.get(0)));
        System.out.println(intervals.stream().flatMap(List::stream).collect(Collectors.toList()));
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i).get(1) > intervals.get(i+1).get(0)){
                return 0;
            }
        }
        return 1;
    }
}

