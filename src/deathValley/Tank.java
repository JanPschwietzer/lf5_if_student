package deathValley;

import java.lang.Math;

public class Tank {

    public boolean enoughGas(int capacity, int gasDisplay, double consumption) {

        return Math.ceil(capacity * (100 / gasDisplay) - consumption * 200) > 0;
    }

}
