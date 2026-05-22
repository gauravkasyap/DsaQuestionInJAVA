import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class words_within_two_edits_of_dictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> words = new ArrayList<>();
        for (int i=0; i< queries.length ; i++){
            int j=0;
            while (j< dictionary.length){
                if (Objects.equals(queries[i], dictionary[j])){
                    words.add(queries[i]);
                    break;
                }
                if (!Objects.equals(queries[i], dictionary[j])){
                    int count=0;
                    for (int k =0; k<queries[i].length(); k++){
                        if (queries[i].charAt(k)!=dictionary[j].charAt(k)) count++;
                    }
                    if (count<3){
                        words.add(queries[i]);
                        break;
                    }
                    else j++;
                }
            }
        }
        return words;
    }
    public static void main(String[] args) {
   words_within_two_edits_of_dictionary wordsWithinTwoEditsOfDictionary = new words_within_two_edits_of_dictionary();

   String[] q = {"word","note","ants","wood"};
   String[]  d = {"word","note","wood"};

        System.out.println(wordsWithinTwoEditsOfDictionary.twoEditWords(q,d));
    }
}
