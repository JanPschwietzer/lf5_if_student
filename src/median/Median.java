package median;

import java.util.Arrays;
import java.util.List;

public class Median {

    public int getMedian(int a, int b, int c) {

        List<Integer> list = Arrays.asList(a,b,c);
        return list.get(list.indexOf(2));

    }
}
