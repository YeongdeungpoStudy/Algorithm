import java.io.*;
class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int room = Integer.parseInt(br.readLine());
        int[] count = new int[9];
        while(room!=0){
            int num = room%10;
            room/=10;
            if(num!=9){
                count[num]++;
            } else {
                count[6]++;
            }
        }
        count[6] = get6(count[6]);
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=8;i++){
            if(max < count[i]){
                max = count[i];
            }
        }
        System.out.print(max);
    }
    static int get6(int count){
        if(count%2 != 0){
            return count/2+1;
        }
        return count/2;
    }
}
