package ex03__Hamming;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Hamming {
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        hammingDistance = IntStream.range(0, leftStrand.length())
                .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                .boxed().collect(Collectors.summingInt(value -> 1));
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}


//other solution:

//class Hamming {
//    private int hammingDistance;
//
//    Hamming(String leftStrand, String rightStrand) {
//        if (leftStrand.length() != rightStrand.length()) {
//            if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
//            if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
//            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
//        }
//        hammingDistance = (int) IntStream.range(0, leftStrand.length())
//                .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
//                .count();
//    }
//
//    int getHammingDistance() {
//        return hammingDistance;
//    }
//}


//    Hamming(String leftStrand, String rightStrand) {
//        if (leftStrand.length() != rightStrand.length()) {
//            if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
//            if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
//            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
//        }
//        hammingDistance = (int) IntStream.iterate(0, n -> n + 1).limit(leftStrand.length())
//                        .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
//                        .count();
//    }


//    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
//        if (leftStrand.length() != rightStrand.length()) {
//            String message;
//            if (leftStrand.isEmpty()) {
//                message = "left strand must not be empty.";
//            } else if (rightStrand.isEmpty()) {
//                message = "right strand must not be empty.";
//            } else {
//                message = "leftStrand and rightStrand must be of equal length.";
//            }
//            throw new IllegalArgumentException(message);
//        } else {
//            leftStrand = leftStrand.toUpperCase();
//            rightStrand = rightStrand.toUpperCase();
//            for (int i = 0; i < leftStrand.length(); i++) {
//                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
//                    this.hammingDistance++;
//                }
//            }
//        }
//    }
