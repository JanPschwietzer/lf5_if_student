package trainInByteburg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketCalculator {

    final static int ofs_char = 48;
    private int fahrtkosten = 2;
    private int startstation = 0;
    private int endstation = 0;
    private List<Integer> linien = new ArrayList<>();
    private List<Integer> halte = new ArrayList<>();

    public int calculateTicketprice(int startRailwayStation, int exitRailwayStation) {

        initialisierung(startRailwayStation, exitRailwayStation);

        if(stationExistiert(startRailwayStation, exitRailwayStation) != 0) return stationExistiert(startRailwayStation, exitRailwayStation);

        if(fahreRingLinie() != 0) return fahreRingLinie();

        if(fahreNormaleLinie() != 0) return fahreNormaleLinie();

        nutzeEndstation();

        return fahrtkosten;
    }

    private void initialisierung(int startRailwayStation, int exitRailwayStation) {

        if (startRailwayStation != 0 && exitRailwayStation != 0) {
            linien.add((int) String.valueOf(startRailwayStation).charAt(0) - ofs_char);
            linien.add((int) String.valueOf(exitRailwayStation).charAt(0) - ofs_char);
            halte.add((int) String.valueOf(startRailwayStation).charAt(1) - ofs_char);
            halte.add((int) String.valueOf(exitRailwayStation).charAt(1) - ofs_char);
        } else if (startRailwayStation == 0) {
            linien.add(0);
            linien.add((int) String.valueOf(exitRailwayStation).charAt(0) - ofs_char);
            halte.add(0);
            halte.add((int) String.valueOf(exitRailwayStation).charAt(1) - ofs_char);
        } else {
            linien.add((int) String.valueOf(startRailwayStation).charAt(0) - ofs_char);
            linien.add(0);
            halte.add((int) String.valueOf(startRailwayStation).charAt(1) - ofs_char);
            halte.add(0);
        }

        startstation = halte.get(0);
        endstation = halte.get(1);

        Collections.sort(linien);
        Collections.sort(halte);
    }


    private int stationExistiert(int startRailwayStation, int exitRailwayStation) {

        if (startRailwayStation >= 60 || startRailwayStation < 0 || exitRailwayStation >= 60 || exitRailwayStation < 0) return -1;
        if (halte.get(0) > 6 || halte.get(1) > 6 || halte.get(0) < 0 || halte.get(1) < 0) return -1;

        return 0;
    }

    private int fahreRingLinie() {

        if (halte.get(0) == 3 && halte.get(0).equals(halte.get(1))) { //Ringlinie

            if (linien.get(1) - linien.get(0) == 1 || linien.get(1) == 5 && linien.get(0) == 1) return 1; //Eine Haltestelle fahren
            return 2; //Mehrere Haltestellen fahren
        }
        return 0;
    }

    private int fahreNormaleLinie() {

        if (linien.get(0).equals(linien.get(1))) { //Gleiche Linie

            if (halte.get(1) - halte.get(0) == 1) return 1; // Nur eine Haltestelle fahren
            else if (halte.get(1) > 3 && halte.get(0) <= 3) fahrtkosten++; //Überquerung Zonengrenze

        } else { // ungleiche Linie

            if (halte.get(0) == 0 && halte.get(1) == 1 || halte.get(1) == 0 && halte.get(0) == 1) return 1; // Nur eine Haltestelle fahren

            if (halte.get(0) == 6 && halte.get(1) == 6) return 6; //2 Endstationen

            if (halte.get(1) > 3 && halte.get(0) > 3) fahrtkosten += 2; //2x Zone überqueren
            else if (halte.get(1) > 3 && halte.get(0) <= 3) fahrtkosten++; //1x Zone überqueren
        }
        return 0;
    }

    private void nutzeEndstation() {

        if (startstation == 6 || endstation == 6) fahrtkosten++;
    }
}