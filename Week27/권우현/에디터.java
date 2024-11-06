package Week27.권우현;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기 문자열 입력
        String initialString = br.readLine();
        int commandCount = Integer.parseInt(br.readLine());

        // LinkedList를 사용해 문자열 처리
        LinkedList<Character> editor = new LinkedList<>();
        for (char c : initialString.toCharArray()) {
            editor.add(c);
        }

        // ListIterator를 사용해 커서 위치 조정
        ListIterator<Character> cursor = editor.listIterator(editor.size());  // 처음에 커서를 맨 뒤에 둔다.

        // 명령어 처리
        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L': // 커서를 왼쪽으로 한 칸 이동
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;

                case 'D': // 커서를 오른쪽으로 한 칸 이동
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;

                case 'B': // 커서 왼쪽 문자 삭제
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;

                case 'P': // 커서 왼쪽에 문자 추가
                    char addChar = command.charAt(2); // P 뒤에 오는 문자
                    cursor.add(addChar);
                    break;
            }
        }

        // 결과 출력
        for (char c : editor) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}
