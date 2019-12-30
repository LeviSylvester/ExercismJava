package ex02c_Proverb;

class Proverb {
    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder proverb = new StringBuilder();
        String firstWord;
        String secondWord;
        String repeatingLine;
        String closingLine;
        int noOfWords = words.length;
        if (noOfWords > 1)
            for (int i = 1; i < noOfWords; i++) {
                firstWord = words[i - 1];
                secondWord = words[i];
                repeatingLine = "For want of a " + firstWord
                        + " the " + secondWord + " was lost.\n";
                proverb.append(repeatingLine);
            }
        if (noOfWords > 0) {
            firstWord = words[0];
            closingLine = "And all for the want of a " + firstWord + ".";
            proverb.append(closingLine);
        }
        return proverb.toString();
    }

}