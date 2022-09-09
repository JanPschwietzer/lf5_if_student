package trainInByteburg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TicketCalculator {
    public int calculateTicketprice(int startRailwayStation, int exitRailwayStation) {

        int fahrtkosten = 2;
        int ofs_char = 48;
        List<Integer> linien = new ArrayList<>();
        List<Integer> halte = new ArrayList<>();
        //Fehler vermeiden, weil 0 nur ein Zeichen lang ist:
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
        int startstation = halte.get(0);
        int endstation = halte.get(1);

        Collections.sort(linien);
        Collections.sort(halte);

        //Station existiert?
        if (startRailwayStation >= 60 || startRailwayStation < 0 || exitRailwayStation >= 60 || exitRailwayStation < 0) return -1;
        if (halte.get(0) > 6 || halte.get(1) > 6 || halte.get(0) < 0 || halte.get(1) < 0) return -1;


        if (halte.get(0) == 3 && halte.get(0) == halte.get(1)) { //Ringlinie

            if (linien.get(1) - linien.get(0) == 1 || linien.get(1) == 5 && linien.get(0) == 1) return 1;
            return 2;
        }

        if (linien.get(0) == linien.get(1)) { //Gleiche Linie

            if (halte.get(1) - halte.get(0) == 1) { //Nur eine Haltestelle fahren
                return 1;
            } else if (halte.get(1) > 3 && halte.get(0) <= 3) { //Überquerung Zonengrenze

                fahrtkosten++;
            }
        } else { // ungleiche Linie

            if (halte.get(0) == 0 && halte.get(1) == 1 || halte.get(1) == 0 && halte.get(0) == 1) return 1; // Nur eine Haltestelle fahren

            if (halte.get(0) == 6 && halte.get(1) == 6) return 6; //2 Endstationen

            if (halte.get(1) > 3 && halte.get(0) > 3) { //2x Zone überqueren

                fahrtkosten += 2;
            } else if (halte.get(1) > 3 && halte.get(0) <= 3) { //1x Zone überqueren

                fahrtkosten++;
            }
        }

        if (startstation == 6 || endstation == 6) { //Endstation benutzen

            fahrtkosten += 1;
        }


        return fahrtkosten;
    }
}