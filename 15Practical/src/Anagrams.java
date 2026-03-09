import java.io.*;
import java.util.*;
public class Anagrams {
    public static void main(String[] args) {

HashMap<String, ArrayList<String>> D = new HashMap<>();

try{
BufferedReader reader = new BufferedReader(new FileReader("joyce1922_ulysses.text"));
String line;

while ((line = reader.readLine()) != null){

    String[] words = line.split("\\s+");

    for (String word : words){

        //clean word (Leave apostrophes)
        word = word.replaceAll("[...,;:_!\\-]+", "");
        word = word.toLowerCase();

        if (word.length() == 0){
            continue;
        }

        // Create the Signature
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String key =  new String(chars);

        //Insert into dictionary
        if (!D.containsKey(key)){
            ArrayList<String> list = new ArrayList<>();
            list.add(word);
            D.put(key, list);
        }else {
            D.get(key).add(word);
        }
    }
}
reader.close();
}catch (IOException e){
System.out.println("Error reading file");
e.printStackTrace();

}

//Print anagrams (Lists with more than 1 word)
        for (String key : D.keySet()) {

            ArrayList<String> list = D.get(key);

            if (list.size() > 1) {
                System.out.println(key + " : " + list);
            }
        }


        // Write Latex File
        try{
            PrintWriter writer = new PrintWriter("theAnagrams.tex");
            writer.println("\\_begin verbatim");

            writer.println("\\_end verbatim");
        }catch(FileNotFoundException e){
            System.out.println("Error opening file");
        }

    }
}