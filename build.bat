java -jar .\exercisegenerator.jar -a toonescompl -x embedded -c 8  -e .\texExercises\toonescompl.tex -t .\texSolutions\toonescomplsol.tex
java -jar .\exercisegenerator.jar -a fromonescompl -x embedded -c 8 -e .\texExercises\fromonescompl.tex -t .\texSolutions\fromonescomplsol.tex
java -jar .\exercisegenerator.jar -a totwoscompl -x embedded -c 8 -e .\texExercises\totwoscompl.tex -t .\texSolutions\totwoscomplsol.tex
java -jar .\exercisegenerator.jar -a fromtwoscompl -x embedded -c 8 -e .\texExercises\fromtwoscompl.tex -t .\texSolutions\fromtwoscomplsol.tex
java -jar .\exercisegenerator.jar -a fromfloat -x embedded -c 4 -d 3 -e .\texExercises\fromfloat.tex -t .\texSolutions\fromfloatsol.tex
java -jar .\exercisegenerator.jar -a tofloat -x embedded -c 4 -d 3 -e .\texExercises\tofloat.tex -t .\texSolutions\tofloatsol.tex
java -jar .\exercisegenerator.jar -a totruthtable -x embedded -l 3 -e .\texExercises\totruthtable.tex -t .\texSolutions\totruthtablesol.tex
java -jar .\exercisegenerator.jar -a fromtruthtable -x embedded -l 3 -e .\texExercises\fromtruthtable.tex -t .\texSolutions\fromtruthtablesol.tex
java -jar .\exercisegenerator.jar -a insertionsort -x embedded -l 10 -e .\texExercises\insertionsort.tex -t .\texSolutions\insertionsortsol.tex
java -jar .\exercisegenerator.jar -a quicksort -x embedded -l 10 -e .\texExercises\quicksort.tex -t .\texSolutions\quicksortsol.tex
java -jar .\exercisegenerator.jar -a mergesortWithSplitting -x embedded -l 10 -e .\texExercises\mergesortwithsplitting.tex -t .\texSolutions\mergesortwithsplittingsol.tex
java -jar .\exercisegenerator.jar -a binsearchtree -x embedded -l 6 -e .\texExercises\binsearchtree.tex -t .\texSolutions\binsearchtreesol.tex
java -jar .\exercisegenerator.jar -a avltree -x embedded -l 6 -e .\texExercises\avltree.tex -t .\texSolutions\avltreesol.tex
java -jar .\exercisegenerator.jar -a bfs -x embedded -e .\texExercises\bfs.tex -t .\texSolutions\bfssol.tex
java -jar .\exercisegenerator.jar -a dfs -x embedded -e .\texExercises\dfs.tex -t .\texSolutions\dfssol.tex
java -jar .\exercisegenerator.jar -a dijkstra -x embedded -l 7 -e .\texExercises\dijkstra.tex -t .\texSolutions\dijkstrasol.tex
java -jar .\exercisegenerator.jar -a tohuff -x embedded -d 20 -l 30 -e .\texExercises\tohuff.tex -t .\texSolutions\tohuffsol.tex
java -jar .\exercisegenerator.jar -a tohamming -x embedded -l 11 -e .\texExercises\tohamming.tex -t .\texSolutions\tohammingsol.tex
java -jar .\exercisegenerator.jar -a fromhamming -x embedded -l 15 -e .\texExercises\fromhamming.tex -t .\texSolutions\fromhammingsol.tex
java -jar .\exercisegenerator.jar -a hashDivision -x embedded -l 11 -e .\texExercises\hashDivision.tex -t .\texSolutions\hashDivisionsol.tex
java -jar .\exercisegenerator.jar -a hashDivisionLinear -x embedded -l 11 -e .\texExercises\hashDivisionLinear.tex -t .\texSolutions\hashDivisionLinearsol.tex
java -jar .\exercisegenerator.jar -a hashDivisionQuadratic -x embedded -l 11 -e .\texExercises\hashDivisionQuadratic.tex -t .\texSolutions\hashDivisionQuadraticsol.tex
java -jar .\exercisegenerator.jar -a hashMultiplication -x embedded -l 11 -e .\texExercises\hashMultiplication.tex -t .\texSolutions\hashMultiplicationsol.tex
java -jar .\exercisegenerator.jar -a hashMultiplicationLinear -x embedded -l 11 -e .\texExercises\hashMultiplicationLinear.tex -t .\texSolutions\hashMultiplicationLinearsol.tex
java -jar .\exercisegenerator.jar -a hashMultiplicationQuadratic -x embedded -l 11 -e .\texExercises\hashMultiplicationQuadratic.tex -t .\texSolutions\hashMultiplicationQuadraticsol.tex



pdflatex Probeklausur.tex
pdflatex ProbeklausurLosung.tex