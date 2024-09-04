import java.util.*;
import java.io.*;

class Point{
    int start;
    int end;

    public Point(int start, int end){
        this.start = start;
        this.end=end;
    }

    public int getDist(){
        return end-start+1;
    }
}

public class Main{
    static String s;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();

        Point pd = getPD();

        //더해야 할 값 찾기
        int additional = pd.start;

        System.out.print(s.length()+additional);
    }

    static Point getPD(){
        for(int i=0; i<s.length(); i++){
            String subStr = s.substring(i, s.length());
            if(!isPD(subStr)){
                continue;
            }

            return new Point(i, s.length()-1);
        }
        return new Point(s.length()-1, s.length()-1);
    }

    static boolean isPD(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}
