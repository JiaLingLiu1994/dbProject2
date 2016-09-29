import java.lang.Object;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* TEAM3
 
 Write a program that can input from a set of superkeys , and output all possible candidate keys from the input to an output file (named "candidate-keys").
 
 Use java8 */

public class project2_Liu_Berezinski_Sterrenberg {
	
    final static Charset ENCODING = StandardCharsets.UTF_8;
    final static String OUTPUT_FILE_NAME = "./output.txt/";

	public static void main (String[] args) throws IOException {
        
        project2_Liu_Berezinski_Sterrenberg writeText = new project2_Liu_Berezinski_Sterrenberg();
        
        String INPUT_FILE_NAME = "./project2_Liu_Berezinski_Sterrenberg.txt/";
        
        
        Set<String> fix_set = new HashSet<String>();
        List<String> candidate_keys;
        
        int controller = 0;
        int counter = 0;
        
		String contents = Files.lines(Paths.get(INPUT_FILE_NAME))
					.collect(Collectors.joining("\n"));
        
		System.out.println(contents);

		String[] superkeys_set = contents.split(" ");
        String[] candidatekeys_set;
        
        
        int num = superkeys_set.length;
        int[] compare_num = new int[num];


		for (int s = 0; s < superkeys_set.length ; s++) {
            
            char[] charArray = superkeys_set[s].toCharArray();
            System.out.println(charArray);
            
            for (int i = 0; i < superkeys_set.length; i++) {
                
                for(int j = 0; j < charArray.length; j++) {
                    if (superkeys_set[i].contains(Character.toString(charArray[j]))) {
                        controller += 1;
                    }
                }
                
                if (controller == charArray.length) {
                    fix_set.add(superkeys_set[i]);
                    counter++;
                } else {
//                    System.out.println("no fix" + superkeys_set[i] + " " + controller);
                }
                
                controller = 0;
            }
            
            compare_num[s] = counter;
            System.out.println(counter);
            counter = 0;
            
            if (fix_set.size() == num) {
                break;
            }
            
        }
        
        System.out.println(fix_set);
        
        candidate_keys = Arrays.asList("test1", "test2");
        writeText.writeLargerTextFile(OUTPUT_FILE_NAME, candidate_keys);
    
		
	}
    
    void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
        Path path = Paths.get(aFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
            for(String line : aLines){
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
