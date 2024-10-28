package Week27;
import java.util.*;
import java.io.*;

//P x => 왼쪽 스택에 문자열 추가

//L => ( 왼쪽 스택이 비어있으면 무시) 왼쪽 스택에서 하나 빼서 오른쪽 스택에 추가

//B => (왼쪽 스택이 비어있으면 무시) 왼쪽 스택에서 하나 빼기

//D => (오른쪽 스택이 비어있으면 무시) 오른쪽 스택에서 하나빼서 왼쪽 스택에 추가


class 에디터 {

    static public int cursor = 0;

    static public Stack<String> leftStack = new Stack<>();

    static public Stack<String> rightStack = new Stack<>();;

    public static void commandP(String addStr){

        leftStack.push(addStr);
        cursor += 1;

    }

    public static void commandL(){

        if(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

    }

    public static void commandB(){

        if(!leftStack.isEmpty()){
            leftStack.pop();
        }

    }

    public static void commandD(){

        if(!rightStack.isEmpty()){
            leftStack.push(rightStack.pop());
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String qtStr = br.readLine();

        cursor = qtStr.length() - 1;
        
        String[] qtStrArray = qtStr.split("");

        for(String str : qtStrArray){
            leftStack.push(str);
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){

            String comStr = br.readLine();

            String[] comStrArray = comStr.split(" ");

            switch(comStrArray[0]){
                case "P":
                    commandP(comStrArray[1]);
                    break;
                case "L":
                    commandL();
                    break;
                case "B":
                    commandB();
                    break;
                case "D":
                    commandD();
                    break;
                default:
                    System.out.println("옳지 않은 명령문입니다.");
                    break;

            }

        }
        
        StringBuilder answer = new StringBuilder("");

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()){
            answer.append(rightStack.pop());
        }

        System.out.println(answer);

    }

}