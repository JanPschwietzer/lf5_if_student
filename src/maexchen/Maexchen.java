/*
# Maexchen**

„Mäxchen“ ist ein einfaches Würfelspiel, dessen vollständige Spielregeln hier nicht zu betrachten sind.
Für das zu entwerfende Programm soll lediglich die Auswertung der Würfelaugen interessieren.
Ein Spieler würfelt zwei Würfel. Der Wert des Wurfs ergibt sich aus den Augen der Würfel wie folgt:

1.	Der Wurf 1, 2 heißt „Mäxchen“ und ist 1000 Punkte wert.
2.	Ein Wurf mit zwei gleichen Augenzahlen wird als „Pasch“ bezeichnet und ist 100 * Augenzahl wert.
Der Wurf 4, 4 hat also den Wert 400.
3.	Ansonsten ergibt sich die Punktzahl als 10 * höhere Augenzahl + niedrigere Augenzahl.
Der Wurf 3, 5 hat beispielsweise die Punktzahl 53.
*/

package maexchen;

public class Maexchen {

    public int calculatePoints(int throw1, int throw2){


        //case ungültig
        if (throw1 > 6 || throw1 < 1 || throw2 > 6 || throw2 < 1 ) return -1;

        //case Mäxchen
        if (throw1 == 2 && throw2 != 2 || throw2 == 2 && throw1 != 2) return 1000;

        //case 2
        if (throw1 == throw2) return (throw1) * 100;

        //case 3
        if (throw1 > throw2) return throw1 * 10 + throw2;
        else return throw2 * 10 +throw1;
    }
}
