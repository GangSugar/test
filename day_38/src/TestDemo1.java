import java.util.*;
public class TestDemo1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();

            char[][] map = new char[n][m];
            for(int i=0; i<n; i++){
                map[i] = sc.nextLine().toCharArray();
            }

            System.out.println(resolve(map));
        }
    }

    private static int resolve(char[][] map){

        int startX = -1;
        int startY = -1;

        loop: for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]=='@'){
                    startX = i;
                    startY = j;
                    break loop;
                }
            }
        }

        map[startX][startY] = 'o';
        dfs(map, startX, startY);

        int res = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]=='o'){
                    res++;
                }
            }
        }

        return res;
    }

    private static final Integer[][] next = new Integer[][] {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    private static void dfs(char[][] map, int x, int y){

        for(int i=0; i<next.length; i++){
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];

            if(nextX<0 || nextX>=map.length || nextY<0 || nextY>=map[x].length){
                continue;
            }

            if(map[nextX][nextY] == '#' || map[nextX][nextY]=='o'){
                continue;
            }

            map[nextX][nextY] = 'o';
            dfs(map, nextX, nextY);
        }

    }

}