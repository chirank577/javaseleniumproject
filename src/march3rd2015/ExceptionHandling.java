package march3rd2015;
//exception handling is all about handling the errors that occur at the execution time or at the run time.

public class ExceptionHandling {

        //throws keyword is used to indicate at the method level, that this method is prone to throw an exception/Error
        public static void main(String[] args) throws GenericExceptions {

            //Exception handling is all about handling the errors that occur at the execution time or
            //at the run time

            //There are two types of exceptions:
            //1. Checked Exceptions: These kind of exceptions occur at the compilation time
            //Ex: InterruptedException, FileNotFoundException, ParseException etc....
            //2. Unchecked Exceptions:  These kind of exceptions occur at the run time
            //Ex: ArithmeticException, NullPointerException, IndexOutOfExceptions etc...

            //Syntax of a try catch block:

            try
            {
                //Write the code that is prone to throwing an error at the run time
            }

            catch (Exception e2)
            {
                //Write the code that is useful to handle the exception during the execution time
            }


            //For a single try block we can have multiple catch blocks
            try
            {
                String b=null;
                System.out.println(b.length());

                System.out.println(Integer.parseInt("5.236236"));
                String a="";
                System.out.println(a.charAt(500));
                System.out.println(10 / 0);
            }

            //ArithmeticException e1 --> here e1 is the variable that is used for that exception
            catch (ArithmeticException e1)
            {
                System.out.println("DO not divide any number with zero as it leads to infinity");
            }

            catch (StringIndexOutOfBoundsException e2)
            {
                System.out.println("Please try to access a character that is within the length of the string");
            }

            catch (NumberFormatException e4)
            {
                System.out.println("Please provide the valid data for formatting");
            }

            //We cannot have duplicates of the same exception in the catch block
            catch (NullPointerException r4)
            {
                //throw/print my own error message instead of using any print statements
//            throw new Exception("Do not perform any operations on the null values");

                throw new GenericExceptions("Do not perform any operations on the null values");
            }

            //Exception Class is the parent class of all kinds of exception
            catch (Exception e5)
            {
                e5.printStackTrace(); //Print the exact reason and the log of why the code got failed
            }

            //This block gets executed irrespective of what happens between try and catch block
            finally {
                System.out.println("Finally Block executed");

                //Use Cases:
                //1. Closing the database connections
                //2. Closing the file connections
                //3. Closing the network connections
                //4. Closing the browser connections
            }

            System.out.println(50-3025-3);
        }
    }
