package Date31JanVariableDay2;

//every class will import java.lang.object library by default

import com.sun.security.jgss.GSSUtil;

import java.lang.constant.Constable;

public class StringsConcept {
    public static void main(String[] args) {
        // String--> ombination of characters
        // CHaracter be a small letter, capital letter, number, special character,

        //Syntax
        String s= "life is beautiful";
        System.out.println(s.length());

        //checks if the given string is empty or not return boolean
        System.out.println(s.isEmpty());


        // convert the upper case
        System.out.println(s.toUpperCase());

        // convert the lower case
        System.out.println(s.toLowerCase());

        //check the string is stsring with mentioned word or letter case sensitive
        System.out.println(s.startsWith("life")); // true
        System.out.println(s.startsWith("Life"));// false
        System.out.println(s.startsWith(s));// true it is matching with entire strng with entire string
        System.out.println(s.toLowerCase().startsWith("life is"));// true

        // checks the given string is ending with given letter or word
        System.out.println(s.endsWith("beautiful"));//true
        System.out.println(s.endsWith("ful")); // true
        System.out.println(s.startsWith("Beautiful"));// false
        System.out.println(s.startsWith(s));// true it is matching with entire strng with entire string
        System.out.println(s.toLowerCase().endsWith("beautiful"));// true

        //replcae the word by given with and mentioned word
        System.out.println(s.replace("life","my World"));

        //it wont throw any error but it will print the real word
        System.out.println(s.replace("nothing","my World"));



        String s2="   ";
        System.out.println(s2.isBlank());// true
        System.out.println(s2.isEmpty());// false

        //repeats the same string for 4 times
        String s1="lets try etering the string";
        System.out.println(s1.repeat(3));

        System.out.println(s1.charAt(2));
        System.out.println(s1.length());
        System.out.println(s1.charAt(s1.length()-10));// it will show what is placed on 17 index

        //System.out.println(s1.charAt(30));ans would be an error

        System.out.println(s1.substring(5));// it will start printing from 5 char of the string
                 //123456789012345678901234567890123
        String s3="My name is chiranjivi kumar singh";
        System.out.println(s3.substring(31));// it wont priint the 31 char index it only print from 3 index position
        System.out.println(s3.substring(30,33));// it will print ngh not ingh
        System.out.println(s3.substring(s3.length()-1,s3.length()));// it means the last char of string

       //System.out.println(s3.substring(33,27)); it throws an error

        System.out.println(s3.indexOf('n'));// it prints the first occurence of the char "n" in the string
        System.out.println(s3.indexOf("name"));// it prints the occurence of "n" only as it is first char
        System.out.println(s3.indexOf("what"));// it will retrun -1 as word is not in the string
      //prints the index position of the last occurence of the character "i"
        System.out.println(s3.lastIndexOf('i'));

        s3="new string has been generated";
        System.out.println(s3.lastIndexOf('e'));

        // retruns the ascII value of the char that is present at given number position
        //A-Z=65-90
        //a-z==97-122
        // whtie space=32
        //0-9=45-54
        System.out.println(s3.codePointAt(9));


        s3="this is an older data which requires an older person to validate";
        //replace the first occurenc of 'older' with 'new'
        System.out.println(s3.replaceFirst("older","new"));


        String s4="this is an older data which requires an older person to validate";
        System.out.println(s3.equals(s4));
        String s6="Hel"+"lo";
        String s5="Hello";

        System.out.println(s5.equals(s6));// true
        System.out.println(s5==s6);// it should be false but it is giving true idk why

        String s7="hello";
        String s8="Hello";
        System.out.println(s7.equalsIgnoreCase(s8));


        // compare the string charcater by character
        //Returns 0 if both the string are same
        //returns +ve value if the first string is greater than the second string
        // returns the -ve value for the first mismatched character
        //it returns +ve or -ve value for the first mismatched character
        System.out.println(s8.compareTo(s7));// it minus or + with first char as per ASCII value
        System.out.println(s7.compareToIgnoreCase(s8));// it will give 0 as per ascII

        s7="      my name is chiru      ";
        System.out.println(s7.trim());// it removes the white spaces
        System.out.println(s7.strip());
        //trim() only removes ASCII spaces (U+0020).
        //strip() removes all types of Unicode whitespace.

        System.out.println(s7.stripLeading());// it removes the start white spaces
        System.out.println(s7.stripTrailing());//. it removes the end white spaces

        s8="my name is vidyut";

        System.out.println(s8.concat(" Yes it is working"));
        System.out.println(s8.concat(" Yes it is working").concat(" yeah again "));

        s8="     my name is vandana.    ";
        System.out.println(s8.strip().contains("is"));// true

        String s9="it won't be changed";
        Constable s10=s9.describeConstable().get();// no it wont be changes its like fixed value
        System.out.println(s10);

        Constable s11="name ";
        System.out.println(s11.toString().trim());











        //


    }
}
