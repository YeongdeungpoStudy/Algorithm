import java.util.*;
import java.io.*;

enum Direct {
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    int dx;
    int dy;

    Direct(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node {
    Point p;
    Direct d;
    int mirror;

    public Node(Point p, Direct d, int mirror) {
        this.p = p;
        this.d = d;
        this.mirror = mirror;
    }
}

class Main {
    static int W;
    static int H;
    static char[][] fields;
    static List<Point> cs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizes = br.readLine().split(" ");
        W = Integer.parseInt(sizes[0]);
        H = Integer.parseInt(sizes[1]);

        fields = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                char field = row[j];
                fields[i][j] = field;

                if (field == 'C') {
                    cs.add(new Point(j, i));
                }
            }
        }

        int res = BFS();
        System.out.print(res);
    }

    static int BFS() {
        Point p1 = cs.get(0);
        Point p2 = cs.get(1);

        Queue<Node> queue = new LinkedList<>();

        int[][][] dp = new int[H][W][Direct.values().length];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (Direct direct : Direct.values()) {
            dp[p1.y][p1.x][direct.ordinal()] = 0;
            queue.add(new Node(new Point(p1.x, p1.y), direct, 0));
        }

        //뭔가 어디서 관찰되고 이런 게 중복되거나 안 맞는 게 있어서 처음부터 다시 생각해서 연습하기!
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //큐 로직에서 현재 위치
            int newX = node.p.x + node.d.dx;
            int newY = node.p.y + node.d.dy;

            //현재 newX, newY가 가능한지 확인
            if (newX < 0 || newX >= W || newY < 0 || newY >= H) {
                continue;
            }
            if(fields[newY][newX] == '*'){
                continue;
            }
            if (dp[newY][newX][node.d.ordinal()] <= node.mirror) {
                continue;
            }

            //현재 방향으로 진행하도록
            dp[newY][newX][node.d.ordinal()] = node.mirror;
            queue.add(new Node(new Point(newX, newY), node.d, node.mirror));

            //90도 여부 확인
            List<Node> mirrorNodes = new ArrayList<>();
            if(node.d == Direct.UP || node.d == Direct.DOWN){
                mirrorNodes.add(new Node(new Point(newX, newY), Direct.LEFT, node.mirror+1));
                mirrorNodes.add(new Node(new Point(newX, newY), Direct.RIGHT, node.mirror+1));
            } else {
                mirrorNodes.add(new Node(new Point(newX, newY), Direct.UP, node.mirror+1));
                mirrorNodes.add(new Node(new Point(newX, newY), Direct.DOWN, node.mirror+1));
            }

            queue.addAll(mirrorNodes);
        }

        //결과 출력
        int res = Integer.MAX_VALUE;
        for(Direct direct:Direct.values()){
            if(res > dp[p2.y][p2.x][direct.ordinal()]){
                res = dp[p2.y][p2.x][direct.ordinal()];
            }
        }

        return res;
    }
}
