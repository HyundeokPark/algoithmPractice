package com.company.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

//https://velog.io/@doeunllee/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-42578%EB%B2%88-%EC%9C%84%EC%9E%A5
public class Lesson42578 {

    public static void main(String[] args) {
        Lesson42578 lesson = new Lesson42578();
        String[][] clothes = {{"crow_mask", "face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}}; //[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
        System.out.println(lesson.solution(clothes));
    }


    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> sortedClothes;

        //착용부위에 따른 옷을 정리!
        sortedClothes=arrangeClothes(clothes);
        //TODO::정리된 표에 따라 가짓수를 구한다! 중복조합?.. 순열?...

        answer = sortedClothes.values().stream().reduce(1,(s,o)->s*(o+1)).intValue()-1;
        return answer;
    }
    public Map<String, Integer> arrangeClothes(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();

        //TODO:: 이걸 람다로 표현할 수 있을까??
        for(String[] cloth : clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
        }
        return map;
    }

}
