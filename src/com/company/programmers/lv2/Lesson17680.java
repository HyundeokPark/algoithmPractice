package com.company.programmers.lv2;

import java.util.LinkedList;
import java.util.Locale;

public class Lesson17680 {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public static void main(String[] args) {
        Lesson17680 lesson = new Lesson17680();
        int cacheSize =0;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        lesson.solution(cacheSize,cities);
    }

    /**
     * 1. cache교체 알고리즘은 LRU
     * 2. cache hit : 1, cache miss : 5 의 시간 소요
     * 3. LRU 알고리즘 이란?
     *   : Least Recently Used 의 약자로 가장 최근에 사용되지 않은 캐시를 교체하는 알고리즘이다.
     * 4. 최초 cacheSize가 다 찰때까지는 새로운 도시는 모두 CACHE_MISS로 5의 시간이 소요된다.
     * 5. cache에 들어있는 도시는 CACHE_HIT로 1의 시간이 소요된다.
     * 6. cacheSize를 넘어가는 새로운 도시가 들어오면 가장 최근까지 사용되지 않았던 도시를 지운다.
     *    역시 이때도 CACHE_MISS로 5의 시간이 소요된다.
     * @param cacheSize max 30, min 0, 정수
     * @param cities 최대 10만개의 배열, 대소문자 구분없는 영어, 최대20글자
     * @return
     */
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        CacheMemory cache = new CacheMemory();
        cache.setMaxSize(cacheSize);

        for(String city : cities){
            String upperedCity = city.toUpperCase(Locale.ROOT);
            cache.add(upperedCity);
        }
        answer = cache.getCountedTime();
        return answer;
    }
    class CacheMemory{
        LinkedList<String> cache = new LinkedList<>(); //캐시를 담아둘 자료구조
        int maxSize;
        int countedTime=0;
        public void setMaxSize(int maxSize){
            this.maxSize = maxSize;
        }

        public void lru(String city){
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
            }else{
                //존재하지 않으면 제일 뒤로 위치시킨다.
                cache.add(city);
            }
        }

        public void add(String city){
            if(maxSize==0) { //캐시가 없을경우
                countedTime+=CACHE_MISS;
            }else if(cache.size()<maxSize){ //캐시가 아직 다 차지 않았을때
                //기존에 존재하면 삭제하고 제일 뒤로 위치시킨다.
                if(cache.contains(city)){
                    cache.remove(city);
                    cache.add(city);
                    countedTime += CACHE_HIT;
                }else{
                    //존재하지 않으면 제일 뒤로 위치시킨다.
                    cache.add(city);
                    countedTime+=CACHE_MISS;
                }
            }else if(cache.size()==maxSize) {
                //캐시가 전부 찼을때 캐시내에 존재하면!
                if (cache.contains(city)) {
                    cache.remove(city);
                    cache.add(city);
                    countedTime += CACHE_HIT;
                } else {
                    //존재하지 않으면 첫원소(제일 오래쓰이지 않은) 제거 후 새로운 캐시를 뒤로 위치시킨다.
                    cache.removeFirst();
                    cache.add(city);
                    countedTime += CACHE_MISS;
                }
            }
        }
        public int getCountedTime(){
            return this.countedTime;
        }
    }


}
