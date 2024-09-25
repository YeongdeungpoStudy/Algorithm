import java.util.*;
import java.io.*;

public class Main{
    static char[] basic={'a', 'n', 't', 'i', 'c'};
    static boolean[] learned; //null
    static int max= -1;
    static int n, k; //0
    static List<Character> wards;
    static String[] words;

    private static int cal(){
        //antic는 무조건 알아야 함
        if (k<5) return 0;
        if (k==26) return n;

        //words에서 중간 단어만 추출해서 문장 만든다.
        for(int i=0;i<words.length;i++){
            String word=words[i];
            String newWord=word.substring(4, word.length()-4);
            words[i]=newWord;

            for(int j=0;j<newWord.length();j++){
                char c=newWord.charAt(j);
                if(!isThere(c))
                    wards.add(c);
            }
        }

        if (wards.size()<=k-5) return n;

        backTracking(0, 0);
        return max;
    }

    private static void backTracking(int idx, int learnedCnt){
        if (learnedCnt==k-5){
            //다 배웠으니까 할 수 있는 단어 계산
            int cnt=0;
            for(String w:words){
                if(isOkayWord(w))
                    cnt++;
            }

            if (cnt>max)
                max=cnt;

            return; //종료
        }

        //전개
        for(int i=idx; i<wards.size();i++){
            char ward=wards.get(i);
            if(!learned[ward-'a']){
                learned[ward-'a']=true;
                backTracking(i+1, learnedCnt+1);
                learned[ward-'a']=false;
            }
        }
    }

    private static boolean isOkayWord(String w){
        for(int i=0;i<w.length();i++){
            if(!learned[w.charAt(i)-'a'])
                return false;
        }
        return true;
    }

    private static boolean isThere(char val){
        for(char ward: wards){
            if (ward==val)
                return true;
        }

        for(char b:basic){
            if(b==val)
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        learned=new boolean[26];

        //antic
        for(char b:basic){
            learned[b-'a']=true;
        }

        wards=new ArrayList();
        words=new String[n];
        for(int i=0;i<n;i++){
            words[i]=br.readLine();
        }

        System.out.println(cal());
    }
}
