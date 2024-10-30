package Week27.조영호;

import java.util.Scanner;

/* 1보다 큰 자연수 중에서 1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 
   예를들어 1과 5를 제외한 약수가 없기 때문에 소수이다. 
   하지만 6은 6 = 2 x 3 이라서 소수가 아니다.
   골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼수 있다
   또 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다
   예를 들면 4 = 2 + 2  , 6 = 3 + 3 , 8 = 3 + 5, 10 = 5 + 5 이다. 1
   10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재 
   2보다 큰 짝수 n이 주어졌을때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
   만약 가능한 n의 골드바흐 파티션이 여러가지인 경우에는 두 소수의 차이가 가장 작은것 출력
*/

/* 풀이방법
 * 먼저 소수를 boolean 배열 index로 활용해 true일 경우 소수가 아니고, false일 경우 소수로 표현
 * 골드바흐 추측 = 2보다 큰 모든 짝수는 두 개의 소수의 합으로 표시할 수 있다 && 이때 하나의 소수를 두번 사용하는 것은 허용 
 * 위 소수의 정보를 담고 있는 배열을 생성하기 위해 에라토스테네스 체 사용 
 */
public class 골드바흐의추측 {
    public static final int Max = 1000000;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //boolean 타입의 dp배열을 먼저 생성
        boolean[] dp = new boolean[Max + 1];
        
        //dp의 모든 값을 true로 바꾸어 주고 
        for(int i = 2; i <= Max; i++) {
        	dp[i] = true;
        }
        //이중 for문을 이용해, dp 배열에서 i가 2의 배수일 때(2를 제외하고), 3의 배수일 때(3을 제외하고) dp값을 false로 바꾸어 줍니다. 
        for(int i = 2; i <= Max; i++) {
        	for(int j = i * 2; j<= Max; j+=i) {
        		if(!dp[j])
        			continue;
        		dp[j] = false;
        	}
        }
        // while문으로 들어가 
        while(true) {
        	int n = scan.nextInt();
            //boolean 타입의 ok를 false로 먼저 선언하고 다시 for문을 짭니다.
        	boolean ok = false;
            // n이 0일 때 입력을 종료한다고 하였으므로 n == 0 일 땐 break;
        	if(n == 0)
        		break;
            // 이 문제의 출력 조건을 맞추기 위해 "20 = 3 + 17" 형태로 출력되게끔 짜려면
            // 앞에 나오는 3을 나타내는 부분이 뒤의 17보다 커지면 안됩니다.
        	// 즉, 먼저 나오는 value값은 20의 절반인 10보다 작거나 같아야 합니다.
            for(int i = 2; i <= n/2; i++) {
                // 이후 dp[i]와 dp[n-i] ( 앞의 value와 뒤의 value가 모두 소수이면 참이므로)가 참일 때
        		if(dp[i] && dp[n-i]) {
                    //Sys.out.문으로 출력
        			System.out.println(n + " = " + i + " + " + (n-i));
        			ok = true;
        			break;
        		}
        	}
        	if(!ok)
        		System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
