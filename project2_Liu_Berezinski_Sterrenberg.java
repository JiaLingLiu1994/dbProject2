import java.lang.Object;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* TEAM3
 
 Write a program that can input from a set of superkeys , and output all possible candidate keys from the input to an output file (named "candidate-keys").
 
 Use java8 */

public class project2_Liu_Berezinski_Sterrenberg {
	

	public static void main (String[] args) throws IOException {
		String contents = Files.lines(Paths.get("./project2_Liu_Berezinski_Sterrenberg.txt/"))
					.collect(Collectors.joining("\n"));
		System.out.println(contents);

		String[] superkeys_set = contents.split(" ");
        Set<String> fix_set = new HashSet<String>();

        int num = superkeys_set.length;
        String[] candidate_set;
		int[] compare_num = new int[num];
        int controller = 0;
        int counter = 0;

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
    
		
	}
}
