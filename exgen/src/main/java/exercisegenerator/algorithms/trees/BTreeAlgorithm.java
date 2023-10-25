package exercisegenerator.algorithms.trees;

import java.io.*;
import java.util.*;

import exercisegenerator.*;
import exercisegenerator.algorithms.*;
import exercisegenerator.io.*;
import exercisegenerator.structures.*;
import exercisegenerator.structures.trees.*;
import exercisegenerator.structures.trees.btree.*;

public class BTreeAlgorithm implements AlgorithmImplementation {

    public static final BTreeAlgorithm INSTANCE = new BTreeAlgorithm();

    private static String OPERATIONS =
        "\\begin{itemize}\\item \\emphasize{Aufteilung}\\item \\emphasize{Diebstahloperation}\\item \\emphasize{Einf\\\"ugeoperation}\\item \\emphasize{L\\\"oschoperation}\\item \\emphasize{Rotation}\\item \\emphasize{Verschmelzung}\\end{itemize}";

    /**
     * Performs the operations specified by <code>construction</code> and <code>ops</code> on the specified B-tree and
     * prints the results to the specified writer. The <code>construction</code> operations are not displayed.
     * @param tree The B-tree.
     * @param tasks The operations.
     * @param construction The operations used to construct the start structure.
     * @param writer The writer for the solution.
     * @param writerSpace The writer for the tree to start with (the one reached after the <code>construction</code>
     *                    operations). May be null if this tree should not be displayed separately.
     * @throws IOException If some error occurs during output.
     */
    public static void btree(
        final int degree,
        final Deque<TreeOperation<Integer>> tasks,
        final Deque<TreeOperation<Integer>> construction,
        final BufferedWriter writer,
        final Optional<BufferedWriter> optionalWriterSpace
    ) throws IOException {
        if (tasks.isEmpty()) {
            return;
        }
        BTree<Integer> tree = new BTree<Integer>(degree);
        while (!construction.isEmpty()) {
            final TreeOperation<Integer> operation = construction.poll();
            if (operation.add) {
                tree = tree.addWithSteps(operation.value).getLast().x;
            } else {
                tree = tree.removeWithSteps(operation.value).getLast().x;
            }
        }
        if (optionalWriterSpace.isPresent()) {
            final BufferedWriter writerSpace = optionalWriterSpace.get();
            if (tasks.size() > 1) {
                if (tree.isEmpty()) {
                    writerSpace.write("F\\\"uhren Sie folgenden Operationen beginnend mit einem anfangs leeren ");
                    writerSpace.write("\\emphasize{B-Baum} mit Grad $t = ");
                    writerSpace.write(String.valueOf(degree));
                    writerSpace.write("$ aus und geben Sie die dabei jeweils entstehenden B\\\"aume nach jeder ");
                    Main.newLine(writerSpace);
                    writerSpace.write(BTreeAlgorithm.OPERATIONS);
                    Main.newLine(writerSpace);
                    writerSpace.write("an:\\\\");
                    Main.newLine(writerSpace);
                } else {
                    writerSpace.write("Betrachten Sie den folgenden \\emphasize{B-Baum} mit Grad $t = ");
                    writerSpace.write(String.valueOf(degree));
                    writerSpace.write("$:\\\\");
                    Main.newLine(writerSpace);
                    LaTeXUtils.printBeginning(LaTeXUtils.CENTER, writerSpace);
                    LaTeXUtils.printTikzBeginning(TikZStyle.BTREE, writerSpace);
                    LaTeXUtils.printBTree(tree, writerSpace);
                    LaTeXUtils.printTikzEnd(writerSpace);
                    LaTeXUtils.printEnd(LaTeXUtils.CENTER, writerSpace);
                    LaTeXUtils.printVerticalProtectedSpace(writerSpace);
                    writerSpace.write("F\\\"uhren Sie beginnend mit diesem Baum die folgenden Operationen aus ");
                    writerSpace.write("und geben Sie die dabei jeweils entstehenden B\\\"aume nach jeder ");
                    Main.newLine(writerSpace);
                    writerSpace.write(BTreeAlgorithm.OPERATIONS);
                    Main.newLine(writerSpace);
                    writerSpace.write("an:\\\\");
                    Main.newLine(writerSpace);
                }
                LaTeXUtils.printBeginning(LaTeXUtils.ENUMERATE, writerSpace);
                for (final TreeOperation<Integer> task : tasks) {
                    if (task.add) {
                        writerSpace.write(LaTeXUtils.ITEM + " " + task.value + " einf\\\"ugen\\\\");
                    } else {
                        writerSpace.write(LaTeXUtils.ITEM + " " + task.value + " l\\\"oschen\\\\");
                    }
                    Main.newLine(writerSpace);
                }
                LaTeXUtils.printEnd(LaTeXUtils.ENUMERATE, writerSpace);
            } else {
                final TreeOperation<Integer> task = tasks.peek();
                if (tree.isEmpty()) {
                    if (task.add) {
                        writerSpace.write("F\\\"ugen Sie den Wert ");
                        writerSpace.write(String.valueOf(task.value));
                        writerSpace.write(" in einen leeren \\emphasize{B-Baum} mit Grad $t = ");
                        writerSpace.write(String.valueOf(degree));
                        writerSpace.write("$ ein und geben Sie die dabei entstehenden B\\\"aume nach jeder ");
                        Main.newLine(writerSpace);
                        writerSpace.write(BTreeAlgorithm.OPERATIONS);
                        Main.newLine(writerSpace);
                        writerSpace.write("an.");
                    } else {
                        writerSpace.write("L\\\"oschen Sie den Wert ");
                        writerSpace.write(String.valueOf(task.value));
                        writerSpace.write(" aus einem leeren \\emphasize{B-Baum} mit Grad $t = ");
                        writerSpace.write(String.valueOf(degree));
                        writerSpace.write("$ und geben Sie die dabei entstehenden B\\\"aume nach jeder ");
                        Main.newLine(writerSpace);
                        writerSpace.write(BTreeAlgorithm.OPERATIONS);
                        Main.newLine(writerSpace);
                        writerSpace.write("an.");
                    }
                } else {
                    if (task.add) {
                        writerSpace.write("F\\\"ugen Sie den Wert ");
                        writerSpace.write(String.valueOf(task.value));
                        writerSpace.write(" in den folgenden \\emphasize{B-Baum} mit Grad $t = ");
                        writerSpace.write(String.valueOf(degree));
                        writerSpace.write("$ ein und geben Sie die dabei entstehenden B\\\"aume nach jeder ");
                        Main.newLine(writerSpace);
                        writerSpace.write(BTreeAlgorithm.OPERATIONS);
                        Main.newLine(writerSpace);
                        writerSpace.write("an:");
                    } else {
                        writerSpace.write("L\\\"oschen Sie den Wert ");
                        writerSpace.write(String.valueOf(task.value));
                        writerSpace.write(" aus dem folgenden \\emphasize{B-Baum} mit Grad $t = ");
                        writerSpace.write(String.valueOf(degree));
                        writerSpace.write("$ und geben Sie die dabei entstehenden B\\\"aume nach jeder ");
                        Main.newLine(writerSpace);
                        writerSpace.write(BTreeAlgorithm.OPERATIONS);
                        Main.newLine(writerSpace);
                        writerSpace.write("an:");
                    }
                    Main.newLine(writerSpace);
                    Main.newLine(writerSpace);
                    LaTeXUtils.printBeginning(LaTeXUtils.CENTER, writerSpace);
                    LaTeXUtils.printTikzBeginning(TikZStyle.BTREE, writerSpace);
                    LaTeXUtils.printBTree(tree, writerSpace);
                    LaTeXUtils.printTikzEnd(writerSpace);
                    LaTeXUtils.printEnd(LaTeXUtils.CENTER, writerSpace);
                    Main.newLine(writerSpace);
                }
            }
            Main.newLine(writerSpace);
        }
        int stepCounter = 1;
        while (!tasks.isEmpty()) {
            final TreeOperation<Integer> task = tasks.poll();
            final BTreeSteps<Integer> steps = task.add ? tree.addWithSteps(task.value) : tree.removeWithSteps(task.value);
            for (final BTreeAndStep<Integer> step : steps) {
                LaTeXUtils.printSamePageBeginning(stepCounter++, LaTeXUtils.COL_WIDTH, writer);
                writer.write(step.y.toLaTeX());
                writer.write("\\\\[2ex]");
                Main.newLine(writer);
                LaTeXUtils.printTikzBeginning(TikZStyle.BTREE, writer);
                LaTeXUtils.printBTree(step.x, writer);
                LaTeXUtils.printTikzEnd(writer);
                LaTeXUtils.printSamePageEnd(writer);
            }
            tree = steps.getLast().x;
        }
        Main.newLine(writer);
    }

    private BTreeAlgorithm() {
    }

    @Override
    public void executeAlgorithm(final AlgorithmInput input) throws IOException {
        final Pair<Deque<TreeOperation<Integer>>, Deque<TreeOperation<Integer>>> constructionAndTasks =
            new ParserAndGenerator<Pair<Deque<TreeOperation<Integer>>, Deque<TreeOperation<Integer>>>>(
                TreeAlgorithms::parseConstructionAndTasks,
                TreeAlgorithms::generateConstructionAndTasks
            ).getResult(input.options);
        BTreeAlgorithm.btree(
            input.options.containsKey(Flag.DEGREE) ? Integer.parseInt(input.options.get(Flag.DEGREE)) : 2,
            constructionAndTasks.y,
            constructionAndTasks.x,
            input.solutionWriter,
            Algorithm.getOptionalSpaceWriter(input)
        );
    }

    @Override
    public String[] generateTestParameters() {
        final String[] result = new String[2];
        result[0] = "-l";
        result[1] = "5";
        return result; //TODO
    }

}
