package com.company.programmers.lv2;

public class Lesson17677 {

    public static void main(String[] args) {
        Lesson17677 lesson = new Lesson17677();
        String str1 = "ab+ab";
        String str2 = "";

        System.out.println(lesson.solution(str1,str2));
    }

    public int solution(String str1, String str2) {
        /**
         * 1. 두 문자열을 두글자씩 끊어 배열/List를 만든다. (두글자씩 끊는 이유는 문제에서 그렇게 주어짐)
         *  -> 영문자외에 기타공백이나 특수문자는 버린다.
         *  -> 대소문자는 구분하지 않는다.
         * 2. 자카드 유사도를 다중집합에 적용한 함수를 분리하자.
         * 3. 유사도는 0~1 사이의 실수이므로, 도출된 유사도에 65536을 곱하고 소수는 버리고 정수부분만 출력 하는 부분을 분리하자
         */
        int answer = 0;
        String[] str1Arr = this.filterString(str1);
        String[] str2Arr = this.filterString(str2);

        double similarity = this.getJakadSimilarity(str1Arr, str2Arr);

        answer = makeSimilarityToInteger(similarity);

        return answer;
    }

    /**
     * 1. 입력받은 문자열을 주어진 조건에 맞게 필터링한다.
     *  -> 대소문자 구분X -> 소문자로 통일하자.
     *  -> 영문자만 인정한다. 기타공백,특수문자는 지운다
     * 2. 두글자씩 끊어 배열로 만들자.
     * @param str
     */
    public String[] filterString(String str){
        str = str.toLowerCase();
        str.replaceAll("[^a-z]","");
        return str.split("[a-z]{2}");
    }
    /**
     * 1. 문자열을 바로 받을지, 아니면 배열/리스트로 변환 후 받을지...
     *  -> 어차피 charArray다...
     * 2. 중복을 허용하는 다중중복집합에 대한 교집합, 합집합을 구하자, 이를 또다시 분리해도 괜찮을듯
     * @return
     */
    public double getJakadSimilarity(String[] str1, String[] str2){
        double result = 0;
        return  result;
    }
    /**
     * 1. 자카드 유사도를 인자로 받는다.
     * 2. 소수14자리까지 정확한 double형으로받자, 실패 시 BigDecomal로 바꿀껏!
     * 3. 문제에서 주어진대로 65536을 곱하고, 소수부분은 버리고 반환한다.(int형으로 변경시 자동적으로 정수만 남는다.)
     * @param similarity
     * @return
     */
    public int makeSimilarityToInteger(double similarity){
        int result = 0;
        result = (int)(similarity * 65536);
        return  result;
    }


}
