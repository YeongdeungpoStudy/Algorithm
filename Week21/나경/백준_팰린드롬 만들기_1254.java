import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        int answer = str.length();
        
        for(int i=0; i<str.length(); i++) {
            if(isPalind(str.substring(i))) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
    
    private static boolean isPalind(String str) {
        int start = 0; 
        int last = str.length()-1;
        while(start <= last) {
            if(str.charAt(start) != str.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
}