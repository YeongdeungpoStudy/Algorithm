import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[] original;
    static int[] changed;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        original = new int[N];
        changed = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            original[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            changed[i] = Integer.parseInt(st.nextToken());
        }

        boolean result = getResult();

        if(result){
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }
    }

    static boolean getResult(){
        changeOriginal();

        return compare() || compareWithReverse();
    }

    static void changeOriginal(){
        int startValue = changed[0];
        int startIndex = 0;

        for(int i=0;i<N;i++){
            if(original[i] == startValue){
                startIndex = i;
                break;
            }
        }

        int[] newOriginal = new int[N];
        int idx = 0;
        for(int i=startIndex;i<N;i++){
            newOriginal[idx++] = original[i];
        }

        for(int i=0;i<startIndex;i++){
            newOriginal[idx++] = original[i];
        }

        original = newOriginal;
    }

    static boolean compare(){
        for(int i=1;i<N;i++){
            if(original[i] != changed[i]){
                return false;
            }
        }

        return true;
    }

    static boolean compareWithReverse(){
        for(int i=1;i<N;i++){
            if(changed[i] != original[N-i]){
                return false;
            }
        }

        return true;
    }
}
