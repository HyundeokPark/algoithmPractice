package com.company.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson64065 {

    public static void main(String[] args) {
        Lesson64065 lesson = new Lesson64065();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s = "{{2},{1,2}}";
//        Arrays.stream(lesson.solution(s)).forEach(System.out::println);
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
     *
     *
     *
     */
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
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

    public ArrayList<Integer> findOrder(String[] target){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.valueOf(target[0]));

        for(int i=1; i<target.length; i++){
            String[] tmp = target[i].split(",");

            for(int j=0; j<tmp.length; j++){
                int e = Integer.valueOf(tmp[j]);
                if(!result.contains(e)){
                    result.add(e);
                    break;
                }
                //TODO: 왜 안되는거야?;;
                // if(!target[i-1].contains(tmp[j])){
                //     result.add(Integer.valueOf(tmp[j]));
                //     break;
                // }
            }
        }
        return result;
    }
    //참고한 소스
    public ArrayList<Integer> solution2(String s) {
        // 1. 튜플을 만들 ArrayList 객체.
        ArrayList<Integer> answer = new ArrayList<>();
        // 2. 가장 앞의 {{ 를 제거한다.
        s = s.substring(2,s.length());
        // 3. 가장 뒤의 }} 를 제거한 뒤, },{ 형태의 문자열을 -로 바꾼다.
        s = s.substring(0,s.length()-2).replace("},{","-");
        // 4. 위에서 바꾼 문자열을 기준으로 split 해준다.
        String str[] = s.split("-");
        // 5. 나눠진 문자열 배열을 길이에 따라 다시 정렬한다.
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){

                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 6. 각 문자열을 탐색한다.
        for(String x : str){
            // 7. 한 문자열마다 ,를 기준으로 split하여 새로운 문자열 배열을 만든다.
            String[] temp = x.split(",");
            // 8. 새로만든 문자열 배열에는 정수값만 존재하며 이를 탐색한다.
            for(int i = 0 ; i < temp.length;i++){
                // 9. 각 문자열 값을 정수로 바꾼다.
                int n = Integer.parseInt(temp[i]);
                // 10. 튜플에 들어있는 값이 아니라면 추가해준다.
                if(!answer.contains(n))
                    answer.add(n);
            }
        }
        return answer;
    }
}
