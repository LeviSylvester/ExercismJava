package ex01a_Raindrops;

/*Convert a number to a string, the contents of which depend on the number's factors.

If the number has 3 as a factor, output 'Pling'.
If the number has 5 as a factor, output 'Plang'.
If the number has 7 as a factor, output 'Plong'.
If the number does not have 3, 5, or 7 as a factor, just pass the number's digits straight through.
Examples
28's factors are 1, 2, 4, 7, 14, 28.
In raindrop-speak, this would be a simple "Plong".
30's factors are 1, 2, 3, 5, 6, 10, 15, 30.
In raindrop-speak, this would be a "PlingPlang".
34 has four factors: 1, 2, 17, and 34.
In raindrop-speak, this would be "34".*/

class RaindropConverter {

    String convert(int number) {
        String rainTank = "";
        if (number % 3 == 0) rainTank += "Pling";
        if (number % 5 == 0) rainTank += "Plang";
        if (number % 7 == 0) rainTank += "Plong";
        return rainTank.isEmpty() ? String.valueOf(number) : rainTank;
    }


    //other solutions:


//    public class Raindrops {
//
//        static String convert(int input) {
//            StringBuilder builder = new StringBuilder();
//            if (input % 3 == 0) builder.append("Pling");
//            if (input % 5 == 0) builder.append("Plang");
//            if (input % 7 == 0) builder.append("Plong");
//            return builder.length() > 0 ? builder.toString() : String.valueOf(input);
//        }
//
//    }


//    public class Raindrops {
//
//        public static String convertFactorsToSounds(int input){
//
//            String sound = "";
//            if (input % 3 == 0){
//                sound += "Pling";
//            }
//            if (input % 5 == 0){
//                sound += "Plang";
//            }
//            if (input % 7 == 0){
//                sound += "Plong";
//            }
//            return sound;
//        }
//
//
//        public static String convert(int input) {
//
//            String sound = convertFactorsToSounds(input);
//
//            if (sound.isEmpty()){
//                sound = Integer.toString(input);
//            }
//
//            return sound;
//        }
//
//    }


//    import java.util.HashMap;
//
//    public class RaindropConverter {
//
//        private static final HashMap<Integer, String> MAP = new HashMap<>();
//
//        static {
//            MAP.put(3, "Pling");
//            MAP.put(5, "Plang");
//            MAP.put(7, "Plong");
//        }
//
//        public String convert(int number) {
//            return MAP.keySet()
//                    .stream()
//                    .filter(key -> number % key == 0)
//                    .map(key -> MAP.get(key))
//                    .reduce((s1, s2) -> s1 + s2)
//                    .orElse(Integer.toString(number));
//        }
//
//    }


//    import java.util.*;
//
//    public class RaindropConverter{
//        public String convert(int inputNumber){
//            int n = inputNumber;
//            Set<Integer> factors = new HashSet<Integer>();
//            for(int i = 1; i <= n; i++) {
//                if(n%i == 0) {
//                    factors.add(i);
//                }
//            }
//            if(factors.contains(3) || factors.contains(5) || factors.contains(7)){
//                String result = "";
//                for (Integer f : factors) {
//                    if(f == 3){
//                        result = result + "Pling";
//                    }
//                    if(f == 5){
//                        result = result + "Plang";
//                    }
//                    if(f == 7){
//                        result = result + "Plong";
//                    }
//                }
//                return result;
//            }
//
//            return String.valueOf(inputNumber);
//        }
//    }


    //import java.util.Arrays;
    //import java.util.function.Predicate;
    //import java.util.stream.Stream;
    //
    //public class Raindrops {
    //
    //    public static String convert(int number) {
    //        Predicate<Raindrop> keepRaindrop =
    //            raindrop -> raindrop.hasPrimeFactor(number);
    //
    //        return rainDrops()
    //                 .filter(keepRaindrop)
    //                 .map(Raindrop::toString)
    //                 .reduce(String::concat)
    //                 .orElse(Integer.toString(number));
    //    }
    //
    //    private static Stream<Raindrop> rainDrops() {
    //        return Arrays.stream(Raindrop.values());
    //    }
    //
    //    private enum Raindrop {
    //        Pling(3),
    //        Plang(5),
    //        Plong(7);
    //
    //        private final int primeFactor;
    //
    //        private Raindrop(int primeFactor) {
    //            this.primeFactor = primeFactor;
    //        }
    //
    //        private boolean hasPrimeFactor(int number) {
    //            return number % primeFactor == 0;
    //        }
    //    }
    //}


//    public class Raindrops {
//        public static String convert(int number){
//            String rain = "";
//
//            if (number % 3 == 0) {
//                rain += "Pling";
//            }
//
//            if (number % 5 == 0) {
//                rain += "Plang";
//            }
//
//            if (number % 7 == 0) {
//                rain += "Plong";
//            }
//
//            if (rain.isEmpty()) {
//                rain = Integer.toString(number);
//            }
//
//            return rain;
//        }
//    }


//    import java.util.function.Predicate;
//import java.util.stream.Stream;
//
//    public final class Raindrops {
//
//        enum Drop {
//
//            FACTOR_OF_3(3, "Pling"),
//            FACTOR_OF_5(5, "Plang"),
//            FACTOR_OF_7(7, "Plong");
//
//            private final Predicate<Integer> pred;
//            private final String sound;
//
//            Drop(int n, String sound) {
//                this.pred = factorOf(n);
//                this.sound = sound;
//            }
//
//            String sound() {
//                return sound;
//            }
//
//            private static Predicate<Integer> factorOf(int n) {
//                return i -> 0 == i % n;
//            }
//        }
//
//        public static String convert(int input) {
//            return Stream.of(Drop.values())
//                    .filter(drop -> drop.pred.test(input))
//                    .map(Drop::sound)
//                    .reduce(String::concat)
//                    .orElse(Integer.toString(input));
//        }
//    }
}
