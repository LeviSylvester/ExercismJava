package ex02e_Diamond;

import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char character) {
        List<String> output = new ArrayList<>();
        if (character == 'A') {
            output.add("A");
            return output;
        }
        StringBuilder diamondLine = new StringBuilder();
        int distance = character - 'A';
        makeDiamondPeak(diamondLine, distance);
        addToOutputAndResetDiamondLine(output, diamondLine, distance);
        for (int i = distance; i > 0; i--) {
            makeDiamondSymmetricalSide(diamondLine, distance, i);
            addToOutputAndResetDiamondLine(output, diamondLine, distance);
        }
        for (int i = 2; i <= distance; i++) {
            makeDiamondSymmetricalSide(diamondLine, distance, i);
            addToOutputAndResetDiamondLine(output, diamondLine, distance);
        }
        makeDiamondPeak(diamondLine, distance);
        addToOutputAndResetDiamondLine(output, diamondLine, distance);
        return output;
    }

    private void makeDiamondPeak(StringBuilder diamondLine, int distance) {
        addSideSpaces(diamondLine, distance);
        diamondLine.append("A");
        addSideSpaces(diamondLine, distance);
    }

    private void makeDiamondSymmetricalSide(StringBuilder diamondLine, int distance, int i) {
        addSideSpaces(diamondLine, i - 1);
        appendProperCharacterInDiamondLine(diamondLine, distance, i);
        addCenterSpaces(diamondLine, distance, i);
        appendProperCharacterInDiamondLine(diamondLine, distance, i);
        addSideSpaces(diamondLine, i - 1);
    }

    private void addSideSpaces(StringBuilder diamondLine, int distance) {
        for (int i = distance; i > 0; i--) {
            diamondLine.append(" ");
        }
    }

    private void appendProperCharacterInDiamondLine(StringBuilder diamondLine, int distance, int i) {
        diamondLine.append((char) (distance - i + 1 + 'A'));
    }

    private void addCenterSpaces(StringBuilder diamondLine, int distance, int i) {
        for (int k = (distance * 2) - (2 * i); k >= 0; k--) {
            diamondLine.append(" ");
        }
    }

    private void addToOutputAndResetDiamondLine(List<String> output, StringBuilder diamondLine, int distance) {
        output.add(diamondLine.toString());
        diamondLine.delete(0, distance * 2 + 1);
    }

}


//other solutions:


//import java.util.Arrays;
//import java.util.List;
//
//public class DiamondPrinter {
//
//    public List<String> printToList(char letter) {
//        int number = letter - 'A' + 1;
//        int size = 2 * (number - 1) + 1;
//
//        String[] lines = new String[size];
//        for (int i=0; i<size / 2 + 1; i++) {
//            char c = (char) ('A' + i);
//
//            int leftPosition = size / 2 + 1 - i - 1;
//            int rightPosition = size - leftPosition - 1;
//            char[] buffer = new char[size];
//            Arrays.fill(buffer, ' ');
//            buffer[leftPosition] = c;
//            buffer[rightPosition] = c;
//            String line = new String(buffer);
//
//            lines[i] = line;
//            lines[size - 1 - i] = line;
//        }
//
//        return Arrays.asList(lines);
//    }
//
//}