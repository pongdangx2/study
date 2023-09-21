// 깊이 우선 탐색 (dfs)

// 자연수 N이 주어지면 1부터 N까지 원소를 갖는 집합의 부분집합을 모두 출력해보기

import java.util.*;

public class DFS_Subset{

    static boolean[] subSet;
    private static void dfs(int len){
        if(len == subSet.length){
            for(int i = 1; i < subSet.length; i++){
                if(subSet[i])
                    System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        subSet[len] = true;
        dfs(len+1);
        subSet[len] = false;
        dfs(len+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        subSet = new boolean[num+1];
        dfs(1);
        sc.close();
    }
}