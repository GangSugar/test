
/*
小镇法官
 */
class Solution2 {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];// 获得的票数
        int[] outDegree = new int[N + 1];// 投出的票数
        for (int[] relation : trust) {
            inDegree[relation[1]]++;// 获得了一张投票
            outDegree[relation[0]]++;// 给人投了一票
        }
        int flag = -1;
        for (int i = 1; i <= N; i++) {
            //有n-1张票，但是自己没有投票，就是法官
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                flag = i;
                break;
            }
        }
        return flag;//返回
    }
}

public class TestDemo6 {
}
