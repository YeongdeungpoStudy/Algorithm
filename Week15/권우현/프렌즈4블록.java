public class 프렌즈4블록 {
    char[][] board_;
    char[][] board_copy;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        board_ = new char[n][m];
        board_copy = new char[n][m];
        for(int i = 0;i<m;i++){
            String tmp = board[i];
            for(int j = 0;j<n;j++){
                board_[j][i] = tmp.charAt(j);
                board_copy[j][i] = tmp.charAt(j);
            }
        }
        while(true){
            int result = findSame(m, n);
            answer+=result;
            if(result==0) break;
        }
        return answer;
    }

    private int findSame(int m, int n){
        for(int i = 1;i<m-1;i++){
            for(int j = 1;j<n-1;j++){
                if(board_[j][i]!='@'){
                    //상좌
                    if(board_[j][i]==board_[j-1][i]&&board_[j][i]==board_[j][i-1]&&board_[j][i]==board_[j-1][i-1]){
                        board_copy[j][i]='#';
                        board_copy[j-1][i]='#';
                        board_copy[j][i-1]='#';
                        board_copy[j-1][i-1]='#';
                    }
                    //상우
                    if(board_[j][i]==board_[j+1][i]&&board_[j][i]==board_[j][i-1]&&board_[j][i]==board_[j+1][i-1]){
                        board_copy[j][i]='#';
                        board_copy[j+1][i]='#';
                        board_copy[j][i-1]='#';
                        board_copy[j+1][i-1]='#';
                    }
                    //하좌
                    if(board_[j][i]==board_[j-1][i]&&board_[j][i]==board_[j][i+1]&&board_[j][i]==board_[j-1][i+1]){
                        board_copy[j][i]='#';
                        board_copy[j-1][i]='#';
                        board_copy[j][i+1]='#';
                        board_copy[j-1][i+1]='#';
                    }
                    //하우
                    if(board_[j][i]==board_[j+1][i]&&board_[j][i]==board_[j][i+1]&&board_[j][i]==board_[j+1][i+1]){
                        board_copy[j][i]='#';
                        board_copy[j+1][i]='#';
                        board_copy[j][i+1]='#';
                        board_copy[j+1][i+1]='#';
                    }
                }}
        }
        return cntRemove(m, n);
    }
    private int cntRemove(int m, int n){
        int tmp = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board_copy[j][i]=='#'){
                    tmp++;
                }
            }
        }
        for(int i = 0;i<n;i++){
            int cnt = 0;
            for(int j=m-1;j>=0;j--){
                if(board_copy[i][j]=='#'){
                    cnt++;
                }
                if(board_copy[i][j]!='#'){
                    board_[i][j+cnt]=board_copy[i][j];
                }
            }
            for(int j=0;j<cnt;j++){
                board_[i][j] = '@';
            }
        }
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                board_copy[j][i]=board_[j][i];
            }
        }
        return tmp;
    }
}
