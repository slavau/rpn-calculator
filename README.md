This is a simple RPN Calculator. See https://en.wikipedia.org/wiki/Reverse_Polish_notation#Postfix_algorithm

It is based on the requirements passed in the text file from ANZ.

This is a command line tool, no GUI. It takes an input from user in a form of a space separated list of operands and operations (e.g. 2 3 +). Entering an empty line exits the program.

To build call

    `mvn clean install`.

    It will generate jars in the target directory. Requirements: Java 8.

To Run call:

    `java -jar target/rpn-calculator-1.0.jar`
