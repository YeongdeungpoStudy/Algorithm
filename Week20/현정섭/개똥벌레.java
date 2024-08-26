import java.io.*;
import java.util.*;

class 개똥벌레{

    // 이진탐색 로직
    static int binarySearch(int[] array, int target, int start, int end) {
		
        // end가 start보다 큰 동안 반복
        while(start < end) {

			int mid = (start + end)/2;
			
			if(array[mid] >= target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
        return start;
	}

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
        // 석순, 종유석 따로 생성
		int[] d = new int[n/2];
		int[] u = new int[n/2];

        // 석순, 종유석 세팅
		for(int i=0; i<n/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			d[i]=a;
			u[i]=b;
		}

        // 정렬
		Arrays.sort(u);
		Arrays.sort(d);

		int min = n;
		int cnt=0;
        
        for(int i = 1; i < h+1; i ++){

            //i 높이의 값 서치 -> i보다 큰 값이 시작되는 index 추출 -> 전체길이에서 뺌 -> 석순, 종유석 둘다 찾아서 더함
            int value = (n/2 - binarySearch(u, i, 0, n/2)) + (n/2 - binarySearch(d, h-i+1, 0, n/2));

            if(min == value) {
				cnt++;
				continue;
			}

			if(min > value) {
				min = value;
				cnt=1;
			}
        }

        System.out.println(min + " " + cnt);

    };

}