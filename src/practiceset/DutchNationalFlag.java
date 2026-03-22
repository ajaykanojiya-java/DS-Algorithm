package practiceset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DutchNationalFlag {
    public static void main(String[] args) {
        ArrayList<Character> balls = new ArrayList<>();
        balls.add('G');
        balls.add('B');
        balls.add('G');
        balls.add('G');
        balls.add('R');
        balls.add('B');
        balls.add('R');
        balls.add('G');

        ArrayList<Character> sortedBalls = dutch_flag_sort(balls);
        System.out.println(sortedBalls);
    }

    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {

        int low= 0, mid = 0, high = balls.size()-1;
        while(mid<=high){
            if(balls.get(mid) == 'R'){
                swap(balls,low,mid);
                mid++;
                low++;
            } else if(balls.get(mid) == 'G'){
                mid++;
            } else {//'B'
                swap(balls,mid,high);
                high--;
            }
        }
        return balls;
    }
    static private void swap(ArrayList<Character> balls, int i, int j){
        char temp = balls.get(i);
        balls.set(i,balls.get(j));
        balls.set(j,temp);
    }
}
