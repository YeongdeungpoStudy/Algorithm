package Week24;
import java.io.*;
import java.util.*;

public class 벽장문의_이동 {

    static int count;
    static int[] order;
    static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] stringList = br.readLine().split(" ");

        int a = Integer.parseInt(stringList[0]);
        int b = Integer.parseInt(stringList[1]);

        //사용할 벽장문 개수
        count = Integer.parseInt(br.readLine());

        //사용할 벽장문 리스트 초기화
        order = new int[count];

        //사용할 벽장문 리스트 생성
		for(int i = 0; i < count; i++){
            order[i] = Integer.parseInt(br.readLine());
        }

        //정답 초기화
        answer = Integer.MAX_VALUE;

        //재귀문
        func(0, a, b, 0);

        System.out.println(answer);
	}

    //현재 열려있는 벽장문 인덱스에서 이동할 벽장문 위치의 인덱스를 빼준다 => calc에 넣음 => 인덱스 늘리면서 이동한 벽장문 인덱스에서 이동할 벽장문 위치의 인덱스를 뺴준다 ... => 사용할 벽장문 개수를 다쓰면 Max값과 비교한다.  
	private static void func(int index, int a, int b, int calc) {

        //사용할 벽장문 개수 다쓰면 종료
        if(index == count){
            answer = Math.min(answer, calc);
            return;
        }

        func(index+1, b, order[index], Math.abs(order[index] - a) + calc);
        
        func(index+1, a, order[index], Math.abs(order[index] - b) + calc);

	}
}
