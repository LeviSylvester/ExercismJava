package ex02a_ReverseString;

class ReverseString {

    String reverse(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

}