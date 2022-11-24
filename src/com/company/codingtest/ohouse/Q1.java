package com.company.codingtest.ohouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1 {

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{0, 10}, {1, 5}, {2, 7}, {3, 4}};
//        Room[] rooms = new Room[meetings.length];
        List<Room> rooms = new ArrayList<>();

        for(int i=0; i<n; i++){
            Room r = new Room(i);
            rooms.add(r);
        }

        int count = 0;
        //회의 시작시간순으로 정렬
        //가능한 회의실 만큼 배정,
        //회의실이 모두 찼으면 1시간씩 시작,마감 시간을 더해준다.
        //회의실 마감 = 대기중인 시작시간이 생기면 작은순으로 대입
        // 끝날때가지 반복!
        Arrays.sort(meetings, (Comparator<int[]>) (o1, o2) -> Integer.compare(o1[0], o2[0]));
        while(count < meetings.length){
            int tmpCount = count;
            for(Room r : rooms){
                if(r.getEndTime()<=meetings[count][0]){
                    r.setHit(r.getHit()+1);
                    r.setEndTime(meetings[count][1]);
                    count++;
                    if(count == meetings.length){
                        break;
                    }
                }
            }
            if(tmpCount == count){
                for(int i=count; i< meetings.length; i++){
                    meetings[i][0]+=1;
                    meetings[i][1]+=1;
                }
            }
        }

        rooms.sort( (Comparator<Room>) (o1, o2) -> Integer.compare(o2.getHit(), o1.getHit()));
        System.out.println(rooms.get(0).number);
    }

    static class Room {
        int number;
        int hit=0;
        int endTime=0;

        public Room(int number){
            this.number = number;
        }
        public Room(int hit, int endTime){
            this.hit = hit;
            this.endTime =endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getHit() {
            return hit;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setHit(int hit) {
            this.hit = hit;
        }
    }

}
