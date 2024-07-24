import java.util.*;

enum Block{
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, BLANK;
}

class Point{
    int row;
    int col;
    
    public Point(int row, int col){
        this.row=row;
        this.col=col;
    }
}

class Board{
    int row;
    int col;
    Block[][] blocks;
    
    int[][] dps = {
        {0, 0},
        {0, 1},
        {1, 1},
        {1, 0}
    };
    
    boolean start = true;
    int ans = 0;
    
    public Board(int row, int col, Block[][] blocks){
        this.row = row;
        this.col = col;
        this.blocks = blocks;
    }
    
    void game(){
        while(start){
            turn();
            down();
        }
    }
    
    void down(){
        //아래서부터 접근해서 리스트에 넣고 재배열 이게 답인거가틈 
        Block[][] newBlocks = new Block[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(newBlocks[i], Block.BLANK);
        }
        
        for(int i=0;i<col;i++){
            List<Block> column = new ArrayList<>();
            for(int j = row-1; j>=0; j--){
                if(blocks[j][i] != Block.BLANK){
                    column.add(blocks[j][i]);
                }
            }
            
            for(int k=0;k<column.size();k++){
                newBlocks[row-1-k][i] = column.get(k);
            }
        }
        
        blocks = newBlocks;
    }
        
    void turn(){
        List<Point> changablePoint = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(blocks[i][j] == Block.BLANK){
                    continue;
                }
                
                int cnt=0;
                
                for(int[] dp:dps){
                    int newI = i+dp[0];
                    int newJ = j+dp[1];
                    
                    if(newI == row || newJ == col){
                        break;
                    }
                    
                    if(blocks[i][j] != blocks[newI][newJ]){
                        break;
                    }
                    
                    cnt++;
                }
                
                if(cnt == 4){
                    changablePoint.add(new Point(i, j));
                }
            }
        }
        
        if(changablePoint.isEmpty()){
            start = false;
            
            return;
        }
        
        //지워주기 
        for(Point point:changablePoint){
            for(int[] dp:dps){
                int newI = point.row + dp[0];
                int newJ = point.col + dp[1];
                
                Block block = blocks[newI][newJ];
                
                if(block == Block.BLANK){
                    continue;
                }
                
                ans++;
                blocks[newI][newJ] = Block.BLANK;
            }
        }
        
        
    }
        
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int row = m;
        int col = n;
        
        Block[][] blocks = new Block[row][col];
        for(int i=0;i<row;i++){
            char[] chars = board[i].toCharArray();
            
            for(int j=0;j<col;j++){
                blocks[i][j] = Block.valueOf(Character.toString(chars[j]));
            }
        }
        
        Board myBoard = new Board(row, col, blocks);
        myBoard.game();
        
        return myBoard.ans;
    }
}
