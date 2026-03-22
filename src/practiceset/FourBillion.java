package practiceset;

import java.util.ArrayList;
import java.util.HashSet;

public class FourBillion {
     public static void main(String[] args) {
         ArrayList<Long> arr = new ArrayList<>();
         arr.add(0L);
         arr.add(1L);
         arr.add(2L);
         arr.add(3L);
         System.out.println(find_integer(arr));
     }

    static Long find_integer(ArrayList<Long> arr) {
        // Write your code here.
        HashSet<Long> set = new HashSet<>(arr);
        for(long i = 0; ; i++){
            if(!set.contains(i)){
                return i;
            }
        }
    }
}
