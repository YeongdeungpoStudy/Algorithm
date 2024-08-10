import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer>  assistantBelt = new Stack<>();
        int mainBeltItem = 1;
        int orderLength = order.length;

        while(answer < orderLength ) {
            int n = order[answer]; //꺼내야 하는 박스의 숫자

            if(mainBeltItem <= n) {
                while(mainBeltItem != n) {
                    assistantBelt.push(mainBeltItem++);
                }
                mainBeltItem++;
                answer++;
            }else if(assistantBelt.pop() == n) {
                answer++;
            }else {
                break;
            }
        }

        return answer;
    }
}