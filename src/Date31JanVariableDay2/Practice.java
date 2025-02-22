package Date31JanVariableDay2;

import java.util.Locale;

public class Practice {
    public static void main(String[] args) {


        int result=0;
        for (int i=1;i<=5;i++){
            if((i*2+3)%4==0) {
                result += i * i;
            }else if(i%2==0) {
                result -= i;
            }else {
                result+=i*2;
            }
        }
        System.out.println(result);







    }
}
