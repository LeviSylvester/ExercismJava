package ex02__TwoFer;

class Twofer {

    String twofer(String name) {
        String you = name == null ? "you" : name;
        return "One for " + you + ", one for me.";
    }

}


//other solutions:


//import java.util.Optional;
//
//public class Twofer {
//    public String twofer(String name) {
//        return "One for " + Optional.ofNullable(name).orElse("you") + ", one for me.";
//    }
//}


//public class Twofer {
//    public String twofer(String name) {
//        return String.format("One for %s, one for me.", name==null ? "you" : name);
//    }
//}


//import java.util.Optional;
//
//public class Twofer {
//
//    public String twofer(String name) {
//        String otherPerson = Optional.ofNullable(name).orElse("you");
//        return "One for " + otherPerson + ", one for me.";
//    }
//}


//import static java.util.Optional.ofNullable;
//
//class Twofer {
//    String twofer(String name) {
//        return String.format("One for %s, one for me.", ofNullable(name).orElse("you"));
//    }
//}


//    import java.util.Optional;
//
//    class Twofer {
//        static String twofer(String name) {
//            return String.format("One for %s, one for me.",
//                    Optional.ofNullable(name).orElse("you"));
//        }
//    }


//    String twofer(String name) {
//        name = name != null ? name : "you";
//        return "One for " + name + ", one for me.";
//    }


//    String twofer(String name) {
//        if (name == null) {
//            return "One for you, one for me.";
//        } else {
//            return "One for " + name + ", one for me.";
//        }
//    }
