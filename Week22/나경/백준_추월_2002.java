import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        Queue<String> input = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            input.add(scan.next());
        }

        Queue<String> output = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            output.add(scan.next());
        }

        int answer = 0;
        while(!output.isEmpty()) {
            String out = output.poll();

            if(!out.equals(input.peek())) {
                answer += 1;
                input.remove(out);
            }else{
                input.poll();
            }
        }

        System.out.println(answer);
    }
}