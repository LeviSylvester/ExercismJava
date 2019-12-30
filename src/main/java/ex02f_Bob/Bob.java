package ex02f_Bob;

class Bob {

    String hey(String input) {
        String response = "";
        if (input.matches("\\?$")) //? on end of sentence
            response = "Sure.";
        else if (input.matches("[A-Z\\s\\S]"))
            response = "Whoa, chill out!";
        else if (input.matches("[A-Z]\\?$")) //A-Z and ?
            response = "Calm down, I know what I'm doing!";
        else if (input.matches("\\W")) //doesn't contain alphanumeric caracter
            response = "Fine. Be that way!";
        else
            response = "Whatever.";
        return response;
    }

}