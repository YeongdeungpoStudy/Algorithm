public class 광물캐기 {
    static int min = Integer.MAX_VALUE;
    static int[] picks = {1, 3, 2};
    static int total_picks = picks[0]+picks[1]+picks[2];
    static String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
    public static void main(String[] args) {
        dfs(0, 0, 0);
        System.out.println(min);
    }
    private static void dfs(int depth, int num, int tired){
        System.out.println(depth);
        System.out.println(tired);
        System.out.println(num);
        for (int i = 0; i < 3; i++) {
            System.out.println(picks[i]);
        }
        System.out.println();
        if(depth == minerals.length||num == total_picks){
            min = Math.min(min, tired);
            return;
        }
        int tmp = 0;
        int tmp1 = 0;
        //다이아 곡괭이
        if(picks[0]!=0){
            picks[0]--;
            for (int i = 0; i < 5 && depth+tmp1< minerals.length; i++) {
                tmp1++;
                tmp++;
            }
            dfs(depth+tmp1, num+1, tired+tmp);
            picks[0]++;
        }
        //철 곡괭이
        if(picks[1]!=0){
            tmp = 0;
            tmp1 = 0;
            picks[1]--;
            for (int i = 0; i < 5 && depth+tmp1< minerals.length; i++) {
                if (minerals[depth+tmp1].equals("diamond")){
                    tmp+=5;
                }
                else {
                    tmp++;
                }
                tmp1++;
            }
            dfs(depth+tmp1, num+1, tired+tmp);
            picks[1]++;
        }
        //돌 곡괭이
        if(picks[2]!=0){
            tmp = 0;
            tmp1 = 0;
            picks[2]--;
            for (int i = 0; i < 5 && depth+tmp1< minerals.length; i++) {
                if (minerals[depth+tmp1].equals("diamond")){
                    tmp+=25;
                } else if (minerals[depth+tmp1].equals("iron")) {
                    tmp+=5;
                }
                else{
                    tmp++;
                }
                tmp1++;
            }
            dfs(depth+tmp1, num+1, tired+tmp);
            picks[2]++;
        }
    }
}