import java.util.*;
import java.io.*;
// N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 
// 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 
// 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
// 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 
// 이때, 주어진 수의 순서를 바꾸면 안 된다.
// 예를 들어 6개의 수로 이루어진 수욜이 1,2,3,4,5,6 이고,
// 주어진 연산자가 덧셈(+) 2개, 뺼셈(-) 1개, 곱셈(x) 1개, 나눗셈 (/) 1개인 경우에는 총 60가지의 식을 만들 수 있다
// 예) 1+2+3-4x5/6
// 예) 1/2+3+4-5x6
// 예) 1+2/3x4+5+6
// 예) 1/2x3-4+5+6
// 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야한다
// 또 나눗셈은 정수 나눗셈으로 몫만 취한다
// 음수를 양수로 나눌때는 C++14의 기준을 따른다.
// 즉 양수로 바꾼 뒤 몫을 취하고 그 몫을 음수로 바꾼 것과 같다
// 이에 다라서 식4개의 결과를 계산해보면 다음과 같다
// 1+2+3-4X5/6 = 1
// 1/2+3+4-5X6 = 12
// 1+2/3*4-5+6 = 5 
// 1/2X3-4+5+6 = 7
// N개의 수와 N-1개의 연산자가 주어졌을떄 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오

public class OperatorInsert_bj {
    // 최대값
    public static int MAX = Integer.MAX_VALUE;
    // 최솟값
    public static int MIN = Integer.MIN_VALUE;
    // 연산자 개수
    public static int[] operator = new int[4];
    // 숫자
    public static int[] number;
    // 숫자개수
    public static int N;

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {
                // 해당 연산자를 1 감소
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(num + number[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - number[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * number[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / number[idx], idx + 1);
                        break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수 복귀
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // BufferedReader는 Scanner와 유사
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        // BufferedWriter는 System.out.println() 과 유사
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자입력
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), "");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0], 1);
        bw.write(Long.toString(MAX) + "\n");
        bw.write(Long.toString(MIN) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
