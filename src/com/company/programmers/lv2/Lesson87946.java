package com.company.programmers.lv2;

public class Lesson87946 {
    public static boolean check[];
    public static int ans = 0;

    public static void main(String[] args) {

        Lesson87946 lesson = new Lesson87946();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(lesson.solution2(k,dungeons));
    }

    public int solution(int k, int[][] dungeons) {
        /**
         * 1. 1<= k <= 5000
         * 2. 최소필요 피로도는 항상 소모피로도 보다 갖거나 크다.
         * 3. 사실 이건 완저탐색 보다는 그리디 인것 같다.
         * 4. 우선 최소필요 피로도가 안되면 도전조차 불가능...
         * 5. 필요피로도가 높으면서, 소모피로도는 적은 순으로 돌아야 최고로 많이 돌수있다.
         * 6. BFS? DFS로 풀수있을까?...
         */
        int answer = -1;
        boolean[] check = new boolean[dungeons.length];
        for(int[] dungeon : dungeons){
            this.dfs(k,dungeons,0);
        }
        return answer;
    }
    public int solution2(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }
    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }


}
