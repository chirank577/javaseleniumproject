package march5thstringBuilder;

public class StringBuilderConcepts {

    public static void main(String[] args) {

        //StringBuilder is fast in performance compared to String Buffer as String Buffer is thread safe
        //Strings is the slowest in terms of performance

        //If we want to make the strings work in a mutable manner
        //we can use StringBuilder or StringBuffer

        StringBuilder sb=new StringBuilder("Sample Data");

        System.out.println(sb);

        sb.append(" It is in Process"); //Adding the data to the existing string

        System.out.println(sb);

        //Inserting a new character at the 5th index position
        sb.insert(5,'k');

        System.out.println(sb);

        //Deleting the characters that is present at 6th index position till 12th index position
        //Inclusive of start index position and exclusive of end index position
        sb.delete(6,12);

        System.out.println(sb);

        //Deletes the character that is present at 10th index position
        sb.deleteCharAt(10);

        System.out.println(sb);

        //Reverses the original string
        sb.reverse();

        System.out.println(sb);

        //Inserting a new string at 10th index position
        sb.insert(10,"New Data");

        System.out.println(sb);

        //Replacing the values tha tis present at 12th index position till 17th index position
        sb.replace(12,17,"");

        System.out.println(sb);

        //Ensure that the minimum capacity of the string builder is 500
        //Here capacity means how many characters does the string builder hold
        sb.ensureCapacity(500);

        System.out.println(sb.length());

        //Trimming the string to 2 characters only
        sb.setLength(2);

        System.out.println(sb);

        //Replacing the character at 1st index position
        sb.setCharAt(1,'t');

        System.out.println(sb);





    }

}
