import java.io.*;
import java.util.*;

/**
 * Class offering methods for dynamic programming.
 * @author Florian Corzilius
 * @version $Id$
 */
public abstract class DynamicProgramming {

    /**
     * Prints exercise and solution for solving a longest common subsequence (lcs) problem with dynamic programming.
     * @param wordA The first word to find the longest subsequence in, which also is a subsequence of the second word.
     * @param wordB The second word to find the longest subsequence in, which also is a subsequence of the first word.
     * @param solWriter The writer to send the solution output to.
     * @param exWriter The writer to send the exercise output to.
     * @throws IOException If some error occurs during output.
     */
    public static void lcs(
        String wordA,
        String wordB,
        BufferedWriter solWriter,
        BufferedWriter exWriter
    ) throws IOException {
        // some preprocessing
        
        // actual algorithm
        
        
        // create output
    }

    /**
     * Prints exercise and solution for solving a knapsack problem with dynamic programming.
     * @param weights The weights of the items to put into the knapsack.
     * @param values The values of the items to put into the knapsack.
     * @param capacity The capacity of the knapsack.
     * @param solWriter The writer to send the solution output to.
     * @param exWriter The writer to send the exercise output to.
     * @throws IOException If some error occurs during output.
     */
    public static void knapsack(
        Integer[] weights,
        Integer[] values,
        Integer capacity,
        BufferedWriter solWriter,
        BufferedWriter exWriter
    ) throws IOException {
        // actual algorithm
        int n = weights.length;
        Integer[][] C = new Integer[n+1][capacity+1];
        String[][] solutions = new String[n+2][capacity+2];
        for (int j = 0; j <= capacity; j++) {
            C[0][j] = 0;
            solutions[0][j+1] = "" + j;
            solutions[1][j+1] = "0";
        }
        solutions[0][0] = "";
        solutions[1][0] = "0";
        for (int i = 1; i <= n; i++) {
            solutions[i+1][0] = "" + i;
            for (int j = 0; j <= capacity; j++) {
                if (weights[i-1] <= j) {
                    Integer valueA = values[i-1] + C[i-1][j-weights[i-1]];
                    if (C[i-1][j] < valueA) {
                        C[i][j] = valueA;
                    } else {
                        C[i][j] = C[i-1][j];
                    }
                } else {
                    C[i][j] = C[i-1][j];
                }
                solutions[i+1][j+1] = "" + C[i][j];
            }
        }
        
        // find the items to choose to get the maximum value
        int row = n;
        int column = capacity;
        List<Integer> itemsToChoose = new ArrayList<Integer>();
        while (column > 0 && row > 0) {
            if (C[row][column] != C[row-1][column]) {
                itemsToChoose.add(new Integer(row));
                Integer chosenWeight = weights[row-1];
                for (int i = 0; i < chosenWeight; i++) {
                    solutions[row+1][column+1] = "$\\leftarrow$ " + solutions[row+1][column+1];
                    column--;
                }
                solutions[row+1][column+1] = "$\\uparrow$ " + solutions[row+1][column+1];
                row--;
            } else {
                solutions[row+1][column+1] = "$\\uparrow$ " + solutions[row+1][column+1];
                row--;
            }
        }
        
        // create output
        exWriter.write("Gegeben sei ein Rucksack mit \\textbf{maximaler Tragkraft} " + capacity);
        exWriter.write(" sowie " + n + " \\textbf{Gegenst\\\"ande}. Der $i$-te Gegenstand soll hierbei");
        exWriter.write(" ein Gewicht von $w_i$ und einen Wert von $c_i$ haben.");
        exWriter.write(" Bestimmen Sie mit Hilfe des in der Vorlesung vorgestellten Algorithmus zum L\\\"osen");
        exWriter.write(" des Rucksackproblems mit dynamischer Programmierung den maximalen");
        exWriter.write(" Gesamtwert der Gegenst\\\"ande, die der Rucksack tragen kann (das Gesamtgewicht der");
        exWriter.write(" mitgef\\\"uhrten Gegenst\\\"ande \\\"ubersteigt nicht die Tragkraft des Rucksacks).");
        exWriter.write(" Die \\textbf{Gewichte} seien dabei $w_0=" + weights[0] + "$");
        for (int i = 1; i < n-1; i++) {
            exWriter.write(", $w_{" + i + "} =" + weights[i] + "$");
        }
        exWriter.write(" und $w_{" + (n-1) + "} =" + weights[n-1] + "$ und die \\textbf{Werte} $c_0=" + values[0] + "$");
        for (int i = 1; i < n-1; i++) {
            exWriter.write(", $c_{" + i + "} =" + values[i] + "$");
        }
        exWriter.write(" und $c_{" + (n-1) + "} =" + values[n-1] + "$.");
        exWriter.write(" Geben Sie zudem die vom Algorithmus bestimmte Tabelle \\texttt{C} an");
        exWriter.write(" und zeigen Sie anhand der Tabelle, welche Gegenst\\\"ande");
        exWriter.write(" mitgenommen werden, um diesen maximalen Wert zu erreichen.");
        exWriter.newLine();
        
        solWriter.write("Die Tabelle \\texttt{C} wird vom Algorithmus wie folgt gef\\\"ullt:");
        solWriter.newLine();
        solWriter.newLine();
        if (capacity+2 > 10) {
        String[][] solutionsTmp = null;
        boolean remainderStarted = true;
        for (int columnNr = 0; columnNr < capacity+2; columnNr++) {
//            System.out.println("columnNr = " + columnNr);
            if (columnNr % 10 == 0 || (remainderStarted && capacity + 2 - columnNr <= 10)) {
                if (columnNr > 0) {
                    TikZUtils.printTable(solutionsTmp, null, "0.9cm", solWriter, true);
                    solWriter.newLine();
                    solWriter.newLine();
                }
                int columnNrTmp = capacity + 2 - columnNr > 10 ? 10 : capacity + 2 - columnNr;
                if (capacity + 2 - columnNr > 10) {
                    remainderStarted = false;
                }
//                System.out.println("columnNrTmp = " + columnNrTmp);
                solutionsTmp = new String[n+2][columnNrTmp];
            }
            for (int rowNr = 0; rowNr < n+2; rowNr++) {
//                System.out.println("add column " + (columnNr % 10));
                solutionsTmp[rowNr][columnNr%10] = solutions[rowNr][columnNr];
            }
        }
        } else {
            TikZUtils.printTable(solutions, null, "0.9cm", solWriter, true);
            solWriter.newLine();
            solWriter.newLine();
        }
        solWriter.write("\\medskip");
        solWriter.newLine();
        solWriter.write("Damit ergibt sich der maximale Wert " + C[n][capacity] + " f\\\"ur den Fall, dass der");
        for (int i = itemsToChoose.size() - 1; i >= 0; i--) {
            if (i > 0 && i < itemsToChoose.size() - 1) {
                solWriter.write(",");
            } else if (i == 0) {
                solWriter.write(" und");
            }
            solWriter.write(" " + (itemsToChoose.get(i)-1) + ".");
        }
        solWriter.write(" Gegenstand mitgenommen werden.");
        solWriter.newLine();
        solWriter.newLine();
        solWriter.write(" Dies l\\\"asst sich von der Tabelle wie folgt ablesen: Wenn die $i$-te Zeile einen Pfeil nach links enth\\\"alt");
        solWriter.write(" dann wird der $(i-1)$-te Gegenstand mitgenommen. Die Pfeile zeigen dabei an wie der folgende Algorithmus durch");
        solWriter.write(" die Tabelle l\\\"auft:");
        solWriter.newLine();
        solWriter.newLine();
        solWriter.write("\\begin{verbatim}");
        solWriter.newLine();
        solWriter.write("int i = n; int j = M;");
        solWriter.newLine();
        solWriter.write("while (i > 0 && j > 0) {");
        solWriter.newLine();
        solWriter.write("    if (C[i][j] != C[i-1][j])");
        solWriter.newLine();
        solWriter.write("        for (int k = 0; k < w[i]; k++) j--;");
        solWriter.newLine();
        solWriter.write("    i--;");
        solWriter.newLine();
        solWriter.write("}");
        solWriter.newLine();
        solWriter.write("\\end{verbatim}");
        solWriter.newLine();
        solWriter.newLine();
    }

}
