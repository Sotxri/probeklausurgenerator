@echo off

:MENU
setlocal enabledelayedexpansion
ECHO.
ECHO ...............................................
ECHO PRESS 1 or 2 to select your TASK, or 3 for EXIT.
ECHO ...............................................
ECHO.
ECHO 1 - Generate Mock exam
ECHO 2 - Cram one type of Exercise
ECHO 3 - EXIT
ECHO.
SET /P M=TYPE 1,2 or 3 then press ENTER:
IF %M%==1 GOTO MOCK
IF %M%==2 GOTO CRAM
IF %M%==3 GOTO EOF
ECHO Invalid choice. Please try again.
GOTO MENU

:MOCK
ECHO Generating Mock exam...please wait
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
java -jar .\exercisegenerator.jar -a mergesort -x embedded -l 10 -e .\texExercises\mergesortwithsplitting.tex -t .\texSolutions\mergesortwithsplittingsol.tex
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
pdflatex -quiet -output-directory=Klausuren Probeklausur.tex
pdflatex -quiet -output-directory=Klausuren ProbeklausurLosung.tex
echo Finished creating Exam
GOTO MENU

:CRAM
REM Building basic tex structure for Cram.tex
echo \documentclass{article} > Cram.tex
echo \usepackage[ngerman]{babel} >> Cram.tex
echo \usepackage[T1]{fontenc} >> Cram.tex
echo \usepackage[table]{xcolor} >> Cram.tex
echo \usepackage[a4paper,margin=2cm]{geometry} >> Cram.tex
echo \usepackage{tikz} >> Cram.tex
echo \usetikzlibrary{arrows,shapes.misc,shapes.arrows,shapes.multipart,shapes.geometric,chains,matrix,positioning,scopes,decorations.pathmorphing,decorations.pathreplacing,shadows,calc,trees,backgrounds} >> Cram.tex
echo \usepackage{tikz-qtree} >> Cram.tex
echo \usepackage{calc} >> Cram.tex
echo \usepackage{array} >> Cram.tex
echo \usepackage{amsmath} >> Cram.tex
echo \usepackage{enumerate} >> Cram.tex
echo \usepackage{seqsplit} >> Cram.tex
echo \usepackage{multicol} >> Cram.tex
echo \usepackage[output-decimal-marker={,}]{siunitx} >> Cram.tex
(echo \newcolumntype{C}[1]{\>{\centering\let\newline\\\arraybackslash\hspace{0pt}}m{#1}}) >> Cram.tex
echo \setlength{\parindent}{0pt} >> Cram.tex
echo \newcommand{\code}[1]{\textnormal{\texttt{#1}}} >> Cram.tex
echo \newcommand{\codeseq}[1]{{\ttfamily\seqsplit{#1}}} >> Cram.tex
echo \newcommand{\emphasize}[1]{\textbf{#1}} >> Cram.tex
echo \newcommand*{\circled}[1]{\tikz[baseline=(char.base)]{ \node[shape=circle,draw,inner sep=2pt] (char) {#1};}} >> Cram.tex
echo \newcommand{\var}[1]{\textit{#1}} >> Cram.tex
echo \newcommand{\solutionSpace}{} >> Cram.tex
echo \title{Cram sponsored by Quentin} >> Cram.tex
echo \begin{document} >> Cram.tex
echo \maketitle >> Cram.tex

REM Building basic tex structure for CramLosung.tex
echo \documentclass{article} > CramLosung.tex
echo \usepackage[ngerman]{babel} >> CramLosung.tex
echo \usepackage[T1]{fontenc} >> CramLosung.tex
echo \usepackage[table]{xcolor} >> CramLosung.tex
echo \usepackage[a4paper,margin=2cm]{geometry} >> CramLosung.tex
echo \usepackage{tikz} >> CramLosung.tex
echo \usetikzlibrary{arrows,shapes.misc,shapes.arrows,shapes.multipart,shapes.geometric,chains,matrix,positioning,scopes,decorations.pathmorphing,decorations.pathreplacing,shadows,calc,trees,backgrounds} >> CramLosung.tex
echo \usepackage{tikz-qtree} >> CramLosung.tex
echo \usepackage{calc} >> CramLosung.tex
echo \usepackage{array} >> CramLosung.tex
echo \usepackage{amsmath} >> CramLosung.tex
echo \usepackage{enumerate} >> CramLosung.tex
echo \usepackage{seqsplit} >> CramLosung.tex
echo \usepackage{multicol} >> CramLosung.tex
echo \usepackage[output-decimal-marker={,}]{siunitx} >> CramLosung.tex
(echo \newcolumntype{C}[1]{\>{\centering\let\newline\\\arraybackslash\hspace{0pt}}m{#1}}) >> CramLosung.tex
echo \setlength{\parindent}{0pt} >> CramLosung.tex
echo \newcommand{\code}[1]{\textnormal{\texttt{#1}}} >> CramLosung.tex
echo \newcommand{\codeseq}[1]{{\ttfamily\seqsplit{#1}}} >> CramLosung.tex
echo \newcommand{\emphasize}[1]{\textbf{#1}} >> CramLosung.tex
echo \newcommand*{\circled}[1]{\tikz[baseline=(char.base)]{ \node[shape=circle,draw,inner sep=2pt] (char) {#1};}} >> CramLosung.tex
echo \newcommand{\var}[1]{\textit{#1}} >> CramLosung.tex
echo \newcommand{\solutionSpace}{} >> CramLosung.tex
echo \title{Cram Lösung sponsored by Quentin} >> CramLosung.tex
echo \begin{document} >> CramLosung.tex
echo \maketitle >> CramLosung.tex


set "additional_flags="
set "problems=toonescompl fromonescompl totwoscompl fromtwoscompl tofloat fromfloat totruthtable fromtruthtable insertionsort quicksort mergesort binsearchtree avltree bfs dfs dijkstra tohuff tohamming fromhamming hashDivision hashDivisionLinear hashDivisionQuadratic hashMultiplication hashMultiplicationLinear hashMultiplicationQuadratic"
REM Display available problems
echo Available problems:
for %%i in (%problems%) do (
    echo - %%i
)

:GET_PROBLEM
REM Ask the user for their choice of problem
set /p "selected_problem=Enter the problem you want to cram: "

REM Check if the selected problem is in the list
set "valid_choice=0"
for %%i in (%problems%) do (
    if /i "!selected_problem!"=="%%i" (
        set "valid_choice=1"
        goto PROBLEM_VALID
    )
)

REM If the choice is not valid, ask again
if "!valid_choice!"=="0" (
    echo Invalid problem choice. Please select from the available problems.
    goto GET_PROBLEM
)


:PROBLEM_VALID
REM Set additional flags based on the selected problem
if "!selected_problem!"=="toonescompl" (
    set "additional_flags=-c 8"
    (echo \section{Einerkomplement}) >> Cram.tex
) else if "!selected_problem!"=="fromonescompl" (
    set "additional_flags=-c 8"
    (echo \section{Einerkomplement}) >> Cram.tex
) else if "!selected_problem!"=="totwoscompl" (
    set "additional_flags=-c 8"
    (echo \section{Zweierkomplement}) >> Cram.tex
) else if "!selected_problem!"=="fromtwoscompl" (
    set "additional_flags=-c 8"
    (echo \section{Zweierkomplement}) >> Cram.tex
) else if "!selected_problem!"=="fromfloat" (
    set "additional_flags=-c 4 -d 3"
    (echo \section{Gleitkommazahlen}) >> Cram.tex
) else if "!selected_problem!"=="tofloat" (
    set "additional_flags=-c 4 -d 3"
    (echo \section{Gleitkommazahlen}) >> Cram.tex
) else if "!selected_problem!"=="totruthtable" (
    set "additional_flags=-l 3"
    (echo \section{Wahrheitstafeln}) >> Cram.tex
) else if "!selected_problem!"=="fromtruthtable" (
    set "additional_flags=-l 3"
    (echo \section{Wahrheitstafeln}) >> Cram.tex
) else if "!selected_problem!"=="insertionsort" (
    set "additional_flags=-l 10"
    (echo \section{Insertionsort}) >> Cram.tex
) else if "!selected_problem!"=="quicksort" (
    set "additional_flags=-l 10"
    (echo \section{Quicksort}) >> Cram.tex
) else if "!selected_problem!"=="mergesort" (
    set "additional_flags=-l 10"
    (echo \section{Mergesort}) >> Cram.tex
) else if "!selected_problem!"=="binsearchtree" (
    set "additional_flags=-l 6"
    (echo \section{Binärbäume}) >> Cram.tex
) else if "!selected_problem!"=="avltree" (
    set "additional_flags=-l 6"
    (echo \section{AVL-Bäume}) >> Cram.tex
) else if "!selected_problem!"=="bfs" (
    set "additional_flags="
    (echo \section{Breadth-First-Search}) >> Cram.tex
) else if "!selected_problem!"=="dfs" (
    set "additional_flags="
    (echo \section{Depth-First-Search}) >> Cram.tex
) else if "!selected_problem!"=="dijkstra" (
    set "additional_flags=-l 7"
    (echo \section{Dijkstra}) >> Cram.tex
) else if "!selected_problem!"=="tohuff" (
    set "additional_flags=-d 20 -l 30"
    (echo \section{Huffman}) >> Cram.tex
) else if "!selected_problem!"=="tohamming" (
    set "additional_flags=-l 11"
    (echo \section{Hamming}) >> Cram.tex
) else if "!selected_problem!"=="fromhamming" (
    set "additional_flags=-l 15"
    (echo \section{Hamming}) >> Cram.tex
) else if "!selected_problem!"=="hashDivision" (
    set "additional_flags=-l 11"
    (echo \section{Hash Division}) >> Cram.tex
) else if "!selected_problem!"=="hashDivisionLinear" (
    set "additional_flags=-l 11"
    (echo \section{Hash Division Linear}) >> Cram.tex
) else if "!selected_problem!"=="hashDivisionQuadratic" (
    set "additional_flags=-l 11"
    (echo \section{Hash Division Quadratisch}) >> Cram.tex
) else if "!selected_problem!"=="hashMultiplication" (
    set "additional_flags=-l 11"
    (echo \section{Hash Multiplikation}) >> Cram.tex
) else if "!selected_problem!"=="hashMultiplicationLinear" (
    set "additional_flags=-l 11"
    (echo \section{Hash Multiplikation Linear}) >> Cram.tex
) else if "!selected_problem!"=="hashMultiplicationQuadratic" (
    set "additional_flags=-l 11"
    (echo \section{Hash Multiplikation Quadratisch}) >> Cram.tex
)

REM Ask the user for the number of exercises to generate
set /p "num_exercises=Enter the number of exercises to generate: "
echo Generating Cram Excercises...please wait
REM Run the jar file repeatedly with the selected exercise type
for /l %%x in (1, 1, %num_exercises%) do (
  java -jar .\exercisegenerator.jar -a !selected_problem! -x embedded !additional_flags! -e .\texExercises\!selected_problem!_%%x.tex -t .\texSolutions\!selected_problem!_%%x_sol.tex
  (echo \input{texExercises/!selected_problem!_%%x})>> Cram.tex
  (echo \\)>>Cram.tex
  (echo \input{texSolutions/!selected_problem!_%%x_sol})>> CramLosung.tex
  (echo \\)>>CramLosung.tex
)
(echo \end{document})>> Cram.tex
(echo \end{document})>> CramLosung.tex
pdflatex -quiet -output-directory=Cram Cram.tex
pdflatex -quiet -output-directory=Cram CramLosung.tex
echo Cram Excersies generated successfully.
endlocal
GOTO MENU

