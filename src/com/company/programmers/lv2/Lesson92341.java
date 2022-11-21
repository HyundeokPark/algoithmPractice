package com.company.programmers.lv2;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lesson92341 {

    public static void main(String[] args) {
        Lesson92341 lesson = new Lesson92341();
        int[] fees = new int[2];
        String[] records = new String[2];

        lesson.solution(fees,records);
    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String,ParkingFee> parkingFees = new HashMap<>();
        List<ParkingFee> answerList = new ArrayList<>();

        //초기화
        for(String record : records){
            String[] tmpRecords = record.split(" ");
            String carNumber = tmpRecords[1];
            String time = tmpRecords[0];
            String type = tmpRecords[2];

            ParkingFee pk = parkingFees.get(carNumber);
            if(pk == null){
                ParkingFee newPk = new ParkingFee(carNumber, time, type);
                parkingFees.put(carNumber,newPk);
            } else{
                if(type.equals("IN")){
                    pk.entryTime = time;
                }else{
                    pk.exitTime = time;
                }
            }
        }
        answerList = parkingFees.values().stream().sorted(
            new Comparator<ParkingFee>() {
                @Override
                public int compare(ParkingFee o1, ParkingFee o2) {
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.carNumber , o2.carNumber);
                }
            }
        ).collect(Collectors.toList());

        answer = answerList.stream().mapToInt(ParkingFee::getParkingFees).toArray();
        return answer;
    }


    class ParkingFee{
        String entryTime;
        String exitTime = "23:59";
        String carNumber;
        int parkingFees;
        int[] feeInfo;

        public int getParkingFees(){
            return this.parkingFees;
        }


        ParkingFee(){

        }

        ParkingFee(String carNumber, String time, String type){
            this.carNumber = carNumber;
            if(type.equals("IN")){
                this.entryTime = time;
            }
            if(type.equals("OUT")){
                this.exitTime = time;
            }
        }
        public void calcFees(){
            //TODO: 시간계산이 필요
            int totalParkingTime = this.getParkingTimeToMinuite(this.entryTime, this.exitTime);
            this.parkingFees = this.calcFeesWithParkingTime(totalParkingTime);
        }

        public int getParkingTimeToMinuite(String entryTime, String exitTime){
            int[] tmpEntryTimes = Arrays.stream(entryTime.split(":")).mapToInt(Integer::parseInt).toArray();
            int[] tmpExitTimes = Arrays.stream(exitTime.split(":")).mapToInt(Integer::parseInt).toArray();

            int hour = (tmpExitTimes[0] - tmpEntryTimes[0]) / 60;
            int minuite = Math.abs(tmpExitTimes[1] - tmpEntryTimes[1]);

            int totalTimeToMinuite = hour + minuite;

            return totalTimeToMinuite;
        }

        public int calcFeesWithParkingTime(int totalTimeToMinuite){
            if(totalTimeToMinuite<180){
                return 5000;
            }
            double v = ((totalTimeToMinuite - 180) / 10);
            return (int)(5000+(Math.ceil(v)) * 600);
        }




    }
}
