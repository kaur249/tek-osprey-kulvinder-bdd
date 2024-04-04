package tek.bdd.utility;

import java.util.Random;

public class DataGeneratorUtility {

    public static String randomEmail(String email){
      //  kulvinder1234expectedName add and put it back as kulvinder@gmail.com
        Random random= new Random();
        int number= random.nextInt(1000);
        int indexOfAtSign= email.indexOf("@");
        String firstPart= email.substring(0, indexOfAtSign);
        String secondPart= email.substring(indexOfAtSign);

        return firstPart+ number+secondPart;
    }

   /*
   Example just show running a main method
   Giving an example to print the random numbers
   public static void main(String[] arg){

        System.out.println(randomEmail("kaur@gmail.com"));

    */
    }

