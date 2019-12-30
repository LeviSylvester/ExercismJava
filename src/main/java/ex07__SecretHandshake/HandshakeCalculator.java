package ex07__SecretHandshake;

import java.util.*;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new ArrayList<>();
        for (int i = 1; number > 0; i *= 10) {
            int binary_digit = number % 2;
            if (i == 10000) Collections.reverse(handshake);
            else if (binary_digit == 1) handshake.add(Signal.get(i));
            number = number / 2;
        }
        return handshake;
    }

}


//other solutions:


//import java.util.*;
//
//class HandshakeCalculator {
//
//    private static final Map<Integer, Signal> SIGNAL_MAP = new HashMap<>();
//
//    static {
//        SIGNAL_MAP.put(1, Signal.WINK);
//        SIGNAL_MAP.put(10, Signal.DOUBLE_BLINK);
//        SIGNAL_MAP.put(100, Signal.CLOSE_YOUR_EYES);
//        SIGNAL_MAP.put(1000, Signal.JUMP);
//    }
//
//    List<Signal> calculateHandshake(int number) {
//        List<Signal> handshake = new ArrayList<>();
//        for (int i = 1; number > 0; i *= 10) {
//            int binary_digit = number % 2;
//            if (i == 10000) Collections.reverse(handshake);
//            else if (binary_digit == 1) handshake.add(SIGNAL_MAP.get(i));
//            number = number / 2;
//        }
//        return handshake;
//    }
//
//}