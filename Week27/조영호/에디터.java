package Week27.조영호;

import java.io.*;
import java.util.Stack;

/*
 * 문제
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 
 * 이 편집기는 영어 소문자만을 기록할 수 있는 편집기, 최대 600,000 글자까지 입력가능
 * 편집기에는 '커서'라는 것이 있는데 커서는 문장의 맨앞(첫 번째 문자의 왼쪽), 문장의 맨뒤(마지막 문자의 오른쪽)
 * 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 * 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면 커서가 위치할 수 있는곳은 L+1 가지 경우
 * 편집기가 지원하는 명령어 
 * L: 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨앞이면 무시됨)
 * D: 커서를 오른쪽으로 한칸 옮김 (커서가 문장의 맨뒤면 무시됨)
 * B: 커서 왼쪽에 있는 문자를 삭제함
 * 초기에 편집기에 입력되어 있는 문자열이 주어지고 그 이후 입력한 명령어가 차례로 주어졌을때
 * 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오
 */
public class 에디터 {
    public static void main(String[] args) throws IOException {
        // reader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // writer 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Stack 생성
        Stack<Character> lStack = new Stack <Character>();
        Stack<Character> rStack = new Stack <Character>();

        // input 값 선언 // String 입력받음
        String input = br.readLine();
        
        // 왼쪽 스택에 리스트에 글자 담음
        for (int i = 0; i < input.length(); i++) {
            lStack.push(input.charAt(i));
        }
        
        // 첫 라인을 읽고
        String nStr = br.readLine();
        int n = Integer.parseInt(nStr);
       
         // 첫 라인에서 입력받은 라인만큼 반복
        for (int i = 0; i < n; i++) {
 
            String command = br.readLine();
            // 명령어 입력 받음
 
            // 왼쪽이동
            if (command.startsWith("L")) {
                // 커서가 맨 왼쪽이 아니면
                if(!lStack.empty()) {
                    // 오른쪽 이동
                    rStack.push(lStack.pop());
                }
            // 커서가 맨 오른쪽이 아니면
            } else if (command.startsWith("D")) {
                if(!rStack.empty()) {
                    // 커서 왼쪽 문자 삭제
                    lStack.push(rStack.pop());
                }
            // 커서가 맨 왼쪽이 아니면
            } else if (command.startsWith("B")) {
                if(!lStack.empty()) {
                    lStack.pop();
                }
                
            // 커서 왼쪽 문자 추가
            } else if (command.startsWith("P")) {
                
                String[] pCommand = command.split(" ");
                
                lStack.push(pCommand[1].toCharArray()[0]);
 
            }
 
        }
 
        // lStack이 빌때까지 오른쪽 스택으로 옮기고
        while(!lStack.empty()) {
            rStack.push(lStack.pop());
        }
 
        // rStack이 빌때까지
        while(!rStack.empty()) {
            //출력
            bw.write(rStack.pop());
        }
 
        br.close();
        bw.flush();
         // reader와 writer를 닫는다
        bw.close();
       
    }
}
