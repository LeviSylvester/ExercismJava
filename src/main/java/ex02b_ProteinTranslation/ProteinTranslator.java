package ex02b_ProteinTranslation;

import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        String[] codons = rnaSequence.split("(?<=\\G...)");
        List<String> proteins = new ArrayList<>();
        for (String codon : codons) {
            if (codon.matches("AUG")) proteins.add("Methionine");
            if (codon.matches("UUU|UUC")) proteins.add("Phenylalanine");
            if (codon.matches("UUA|UUG")) proteins.add("Leucine");
            if (codon.matches("UCU|UCC|UCA|UCG")) proteins.add("Serine");
            if (codon.matches("UAU|UAC")) proteins.add("Tyrosine");
            if (codon.matches("UGU|UGC")) proteins.add("Cysteine");
            if (codon.matches("UGG")) proteins.add("Tryptophan");
            if (codon.matches("UAA|UAG|UGA")) break;
        }
        return proteins;
    }

}