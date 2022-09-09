package getMaximum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Maximum{
    public int getMaximum(int number1, int number2, int number3){


        List<Integer> max = Arrays.asList(number1,number2, number3);

        Collections.sort(max);

        return max.get(2);
    }
}

