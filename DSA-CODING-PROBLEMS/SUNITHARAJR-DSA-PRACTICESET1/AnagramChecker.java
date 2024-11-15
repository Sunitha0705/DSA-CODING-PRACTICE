import java.util.Scanner;
import java.util.Arrays;
public class AnagramChecker{
        public static boolean isAnagram(String s1,String s2){
              if(s1.length() != s2.length()){
                  return false;
              }
              char[] arr1 = s1.toCharArray();
              char[] arr2 = s2.toCharArray();
              
              Arrays.sort(arr1);
              Arrays.sort(arr2);
             
              return Arrays.equals(arr1,arr2);
        }
        public static void main(String args[]){

               Scanner scanner=new Scanner(System.in);
               
               System.out.print("Enter the first String:");
               String s1=scanner.nextLine();
               
               System.out.print("Enter the second String:");
               String s2=scanner.nextLine();
                  
               System.out.println("Are the strings anagrams ? " +isAnagram(s1,s2));
       }
}
