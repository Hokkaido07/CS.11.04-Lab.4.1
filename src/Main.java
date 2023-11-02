
import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int length = str.length();
        int count = 0;

        for(int i = 0;i<length;i++){
            if(str.charAt(i) == '('){
                count++;
            } else if(str.charAt(i) == ')'){
                count--;
            } else {
                return false;
            }

            if(count < 0){
                return false;
            }
        }
        return count == 0;

    }

    // 2. reverseInteger
    public static String reverseInteger(int n){
        String s = n + "";
        String reverseString = "";

        for (int i = s.length()-1; i>=0;i-- ){
            char c = s.charAt(i);
            reverseString = reverseString+c;
        }
        return reverseString;
    }


    // 3. encryptThis
    public static String encryptThis(String str){
        Scanner in = new Scanner(str);
        String result = "";
            while (in.hasNext()) {
                String word = in.next();
                int firstCharCode = word.charAt(0);
                if(word.length() > 2) {
                    String secondChar = word.charAt(1) + "";
                    String lastChar = word.charAt(word.length() - 1) + "";
                    String middle = word.substring(2, word.length() - 1);
                    String newWord = firstCharCode + lastChar + middle + secondChar;
                    result += newWord + " ";
                } else{
                    String lastChar = word.charAt(word.length() - 1) + "";
                    String newWord = firstCharCode + lastChar;
                    result += newWord + "";
                }

            }
            return result.trim();
        }


    // 4. decipherThis
    public static String decipherThis(String str){
        String result="";
        Scanner scanner=new Scanner(str);
        boolean isLastWord=false;

        while(scanner.hasNext()){
            String word=scanner.next();
            int length=word.length();
            int first=0;
            int i=0;

            while(i<length && Character.isDigit(word.charAt(i))){
                first=first*10+(word.charAt(i)-'0');
                i++;
            }

            char decodedFirst=(char)first;
            String second="";
            String middle="";

            if(length-i>1) {
                second=word.substring(length-1,length);
                middle = word.substring(i+1, length-1);
            }

            char last=word.charAt(i);

            result += decodedFirst+second+middle+last;

            if(scanner.hasNext()){
                result+=" ";
            } else{
                isLastWord=true;
            }
        }

        if(!isLastWord){
            result+=" ";
        }

        return result;
    }
}


