package com.company.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Lesson64065 {

    public static void main(String[] args) {
        Lesson64065 lesson = new Lesson64065();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Arrays.stream(lesson.solution(s)).forEach(System.out::println);
    }

    /**
     * 1. 집합의 순서는 바뀌어도 되나, 이를 통해서 튜플을 확인하는게 굉장히 이상하다. -> 이해가 안된다.
     * 2. 순서가 바뀌어도 되므로, 튜플의 순서를 유추해 내는것이 사실상 불가능하지 않은가?
     * 3. 그저 튜플을 이루는 원소들만 중복제거로 알 수있을것 같다.
     * 2201116
     * 4. 집합으로 표기할때는 순서의 제한이 전.혀 없다. 순서의 제한은 튜플 원본 뿐이다.
     * 5. 집합의 표기법에서 알수있는 건, 집합의 원소들의 갯수에 따른 각 원소가 몇번째 부터 몇번째 까지 들어있는지 이다.
     * 6. 즉, {x} -> 무조건 튜플의 첫번째 원소이다.
     * 7. 이런식으로 하나씩 튜플의 순서를 알아내어 튜플을 배치하는게 가능하다!
     *
     * @param s
     * @return
     */
    public int[] solution(String s) {
        int[] answer = {};
        String[] target = Arrays.stream(
            s.substring(1, s.length() - 1).split(",\\{"))
            .map(e -> {
                return e.replaceAll("\\{|\\}|", "");
            })
            .toArray(String[]::new);

        //TODO: sort by target element's length
        target = this.sortByLength(target);

        //TODO: 배열을 순회하며 각 집합마다 튜플 순서에 맞는 원소를 찾고, 튜플에 넣는다.
        answer = this.findOrder(target);
        return answer;
    }

    public String[] sortByLength(String[] target){
     Arrays.sort(target, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
             return o1.length() < o2.length() ? -1 : 1;
         }
     });
     return target;
    }

    public int[] findOrder(String[] target){
        int[] result = new int[target.length];
        result[0] = Integer.valueOf(target[0]);
        for(int i=1; i<target.length; i++){
            String[] tmp = target[i].split(",");
            for(int j=0; j<target[i].length(); j++){
                if(!target[i-1].contains(tmp[j])){
                    result[i] = Integer.valueOf(tmp[j]);
                    break;
                }
            }
        }
        return result;
    }
}
