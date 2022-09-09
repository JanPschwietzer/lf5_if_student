package tyre_pressure;

public class TyrePressureCalculator {
    public boolean calc(int frontRight, int frontLeft, int behindRight, int behindLeft) {

        return (frontRight - frontLeft <= 3 && frontRight - frontLeft >=-3) && (behindRight - behindLeft <= 3 && behindRight - behindLeft >=-3);
    }

    public boolean checkTyre(int pressure) {
        return (pressure <= 45 && pressure >= 35);
    }
}
