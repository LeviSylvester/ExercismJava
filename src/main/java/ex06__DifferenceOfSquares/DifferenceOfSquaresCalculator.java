package ex06__DifferenceOfSquares;

import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sumToInput = IntStream.rangeClosed(1, input)
                .sum();
        return sumToInput * sumToInput;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input)
                .map(n -> n * n)
                .sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}

//import java.util.stream.IntStream;
//
//class DifferenceOfSquaresCalculator {
//
//    int computeSquareOfSumTo(int input) {
//        return (int) Math.pow(input * (input + 1) / 2, 2);
//    }
//
//    int computeSumOfSquaresTo(int input) {
//        return IntStream.rangeClosed(1, input)
//                .map(n -> n * n)
//                .sum();
//    }
//
//    int computeDifferenceOfSquares(int input) {
//        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
//    }
//
//}

//import java.util.stream.IntStream;
//
//class DifferenceOfSquaresCalculator {
//
//    int computeSquareOfSumTo(int input) {
//        return IntStream.rangeClosed(1, input)
//                .boxed()
//                .reduce((num1, num2) -> num1 + num2)
//                .map(num -> num * num)
//                .orElse(0);
//    }
//
//    int computeSumOfSquaresTo(int input) {
//        return IntStream.rangeClosed(1, input)
//                .map(n -> n * n)
//                .sum();
//    }
//
//    int computeDifferenceOfSquares(int input) {
//        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
//    }
//
//}

//class DifferenceOfSquaresCalculator {
//
//    int computeSquareOfSumTo(int input) {
//        return square(sumOfNaturalNumbersTo(input));
//    }
//
//    int computeSumOfSquaresTo(int input) {
//        int square = 0;
//        int differenceToNextSquare = 1;
//        int sumOfSquares = square;
//        for (int i = 1; i <= input; i++) {
//            square += differenceToNextSquare;
//            differenceToNextSquare += 2;
//            sumOfSquares += square;
//        }
//        return sumOfSquares;
//    }
//
//    int computeDifferenceOfSquares(int input) {
//        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
//    }
//
//    private int sumOfNaturalNumbersTo(int input) {
//        int sumOfNaturalNumbersToInput = 0;
//        for (int n = 1; n <= input; n++) {
//            sumOfNaturalNumbersToInput += n;
//        }
//        return sumOfNaturalNumbersToInput;
//    }
//
//    private int square(int input) {
//        int square = 0;
//        int differenceToNextSquare = 1;
//        for (int i = 1; i <= input; i++) {
//            square += differenceToNextSquare;
//            differenceToNextSquare += 2;
//        }
//        return square;
//    }
//
//    public static void main(String[] args) {
//        DifferenceOfSquaresCalculator diff = new DifferenceOfSquaresCalculator();
//        System.out.println(diff.computeDifferenceOfSquares(100000));
//    }
//
//}

//class DifferenceOfSquaresCalculator {
//
//    int computeSquareOfSumTo(int input) {
//        return square(sumOfNaturalNumbersTo(input), false);
//    }
//
//    int computeSumOfSquaresTo(int input) {
//        return square(input, true);
//    }
//
//    int computeDifferenceOfSquares(int input) {
//        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
//    }
//
//    private int sumOfNaturalNumbersTo(int input) {
//        int sumOfNaturalNumbersToInput = 0;
//        for (int n = 1; n <= input; n++) {
//            sumOfNaturalNumbersToInput += n;
//        }
//        return sumOfNaturalNumbersToInput;
//    }
//
//    private int square(int input, boolean sumSquaresUp) {
//        int square = 0;
//        int differenceToNextSquare = 1;
//        int sumOfSquares = square;
//        for (int i = 1; i <= input; i++) {
//            square += differenceToNextSquare;
//            differenceToNextSquare += 2;
//            if (sumSquaresUp) sumOfSquares += square;
//        }
//        return sumSquaresUp ? sumOfSquares : square;
//    }
//
//}