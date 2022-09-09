package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public void sort(double size1, double size2, double size3) {

        List<Double> sizes = Arrays.asList(size1,size2,size3);
        Collections.sort(sizes);
        Collections.reverse(sizes);

        System.out.println(sizes);


    }
}
