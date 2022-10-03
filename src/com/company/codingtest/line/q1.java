package com.company.codingtest.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1 {

    public static void main(String[] args) {
      q1 q = new q1();
      int[] prices = {8,3,5,9,};
      int[] coupons = {4,4,2,4,6};
      int[] sample = {4,1,1,3,2}; //예시 답안
      int [] results = q.solution(prices,coupons);
      for(int result : results){
          System.out.println(result);
      }
    }

    public int[] solution(int[] prices, int[] coupons) {
        /**
         *  1.다음 조건들은 모두만족하는 쿠폰은 반드시 사용해야 하며, 반드시 1개다.
             *  1-1. 상품과 같은 인덱스 또는 그 인덱스보다 큰 쿠폰
             *  1-2. 상품의 가격과 같거나 그 가격보다 작은 쿠폰
             *  1-3. 위 조건을 만족하는 쿠폰 중 인덱스가 가장 작은 쿠폰
             *  1-4. 불량쿠폰이 아닌 쿠폰
         *  2. 상품가격보다 큰 쿠폰은 사용할 수 없다.
         *  3. 한 번 사용한 쿠폰은 재사용 불가
         *  4. 불량쿠폰은 할인 가격이 없거나, 비싸게 만든다.
         *  5. 상품과 쿠폰의 개수는 다를 수 있다.
         */
        int[] answer = {};
        answer = this.filterQ1(prices, coupons);

        return answer;
    }

    public int[] filterQ1(int[] prices, int[] coupons){
//        List<Integer> tmp = new ArrayList<>();
        int[] tmp = Arrays.copyOf(prices,prices.length);

        for(int i=0; i<prices.length; i++){
            //개수가 다를수 있으므로 한쪽이 끝나면 거기서 종료한다.
            if(i == coupons.length){
                break;
            }
            //인덱스는 같거나 커야 하므로 시작값은 i와 같다.
            for(int j=i; j<coupons.length; j++){
                //이미사용한 쿠폰은 제외
                if(coupons[j]==0){
                    continue;
                }
                //가격차이 비교
                if(prices[i] >= coupons[j]){
                    //불량쿠폰 체크!
                    if(this.checkFault(prices[i], prices[i]-coupons[j])){
                        tmp[i] = prices[i] - coupons[j]; //할인 적용!
                        coupons[j] = 0; //0으로 사용처리
                        break;
                    }
                }
            }
        }
        return tmp;
    }
    /**
     * 불량쿠폰 체크
     */
    public boolean checkFault(int originPrice, int discountedPrice){
        boolean answer;

        answer = originPrice - discountedPrice >= 0 ? true : false;
        return answer;
    }

}
