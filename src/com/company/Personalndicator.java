package com.company;

import java.util.*;

public class Personalndicator {
    public static void main(String[] args) {
        solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String,Integer> scoreResult = new HashMap<>();
        List<IndicatorResult> indicatorResults = new ArrayList<>();

        //지표 만들기
        for(int i=1; i<=4; i++){
            IndicatorResult indicatorResult = new IndicatorResult();
            indicatorResults.add(indicatorResult);
        }
        //성격 설정
//        indicatorResults.get(0).setTypes();

        for(int i=0; i<choices.length; i++){
            int choice = choices[i];
            String[] types = survey[i].split("");
            System.out.println("choice : "+choice + "\n survey : " + types[0]+","+types[1]);
            if(choice<4){
                if(scoreResult.get(types[0])!=null){
                    scoreResult.put(types[0],scoreResult.get(types[0])+choice);
                }else{
                    scoreResult.put(types[0],choice);
                }
            }else if(choice >4){
                if (scoreResult.get(types[1]) != null) {
                    scoreResult.put(types[1], scoreResult.get(types[1]) + choice);
                } else {
                    scoreResult.put(types[1], choice);
                }
            }
        }
//        scoreResult.keySet().forEach((e)-> System.out.println(e+":"+scoreResult.get(e)));

        return answer;
    }
    static class IndicatorResult{
        Map<String,Integer> typeScore = new HashMap<>();
        public IndicatorResult(){
        }
        public void setTypes(Map type){
            this.typeScore = type;
        }

        public Map<String, Integer> getTypeScore() {
            return typeScore;
        }
        public String getType(){
            return typeScore.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).toString();
        }
    }

}
