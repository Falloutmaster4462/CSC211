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
    }
}
}

    }
}