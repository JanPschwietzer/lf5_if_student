package gradesWithIHKScheme;

import java.lang.Math;

public class GradeCalculator {
    public int calculateGrade(double points, int reachablePoints){

        double percent = Math.round(points / reachablePoints * 100);

        if (percent > 100) return -1;
        else if (percent >= 92) return 1;
        else if (percent >= 81) return 2;
        else if (percent >= 67) return 3;
        else if (percent >= 50) return 4;
        else if (percent >= 30) return 5;
        else if (percent >= 0) return 6;

        return -1;
    }
}