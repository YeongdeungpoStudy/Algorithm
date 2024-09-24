package Week22.권우현;

import java.util.ArrayList;
import java.util.Arrays;

public class 수식_복원하기 {
    public static void main(String[] args) {
        solution(new String[]{"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"});
    }
    public static String[] solution(String[] expressions) {
        ArrayList<String> ans_formula = new ArrayList<>();
        boolean[] able = new boolean[10];
        Arrays.fill(able, true);
        for (int i = 0; i <expressions.length; i++) {
            String formula = expressions[i];
            String[] split = formula.split(" ");
            String num1 = split[0];
            String num2 = split[2];
            String num3 = split[4];
            String operator = split[1];

            if (num3.equals("X")){
                ans_formula.add(formula);
                for (int j = 2; j < 10; j++) {
                    try {
                        Integer.parseInt(num1, j);
                        Integer.parseInt(num2, j);
                    } catch (NumberFormatException e) {
                        able[j] = false;
                    }
                }
            }
            else {
                //가능한지 판단
                for (int j = 2; j < 10; j++) {
                    try {
                        int int1 = Integer.parseInt(num1, j);
                        int int2 = Integer.parseInt(num2, j);
                        int int3 = Integer.parseInt(num3, j);
                        //정답이 맞는지 확인
                        if (operator.equals("+")){
                            if (int1+int2!=int3){
                                able[j] = false;
                            }
                        }else {
                            if (int1 - int2 != int3) {
                                able[j] = false;
                            }
                        }
                    } catch (NumberFormatException e) {
                        able[j] = false;
                    }
                }
            }
        }

        String[] ans = new String[ans_formula.size()];

        for (int i = 0; i < ans_formula.size(); i++) {
            String now_formula = ans_formula.get(i);

            String[] split = now_formula.split(" ");

            String num1 = split[0];
            String num2 = split[2];
            String operator = split[1];

            int prev = 1000;

            for (int j = 2; j < 10; j++) {

                if (!able[j]) continue;

                int int1 = Integer.parseInt(num1, j);
                int int2 = Integer.parseInt(num2, j);

                int result = 0;
                if (operator.equals("+"))
                    result = Integer.parseInt(Integer.toString(int1+int2, j));
                else result = Integer.parseInt(Integer.toString(int1-int2, j));

                if (prev==1000){
                    prev = result;
                }else {
                    if (prev!=result){
                        ans[i] = num1+" "+operator+" "+num2+" = ?";
                        break;
                    }
                }

            }
            if (ans[i]==null){
                ans[i] = num1+" "+operator+" "+num2+" = "+prev;
            }

        }


        return ans;

    }
}
