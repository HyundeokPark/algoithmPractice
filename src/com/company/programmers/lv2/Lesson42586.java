package com.company.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Lesson42586 {

    public static void main(String[] args) {
        Lesson42586 lesson = new Lesson42586();
        int[] progresses = {1};
        int[] speeds = {1};
        lesson.solution(progresses,speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> deployedWork = new ArrayList<>();
        List<Worker> workers = new LinkedList<>();
        int count = 0;
        while(!workers.isEmpty()){
            this.recursive(workers,count);
            if(count>=0){
                deployedWork.add(count);
            }
            this.progressAllWorker(workers);
        }

        answer = deployedWork.stream().mapToInt(i->i).toArray();
        return answer;
    }
    public void recursive(List<Worker> workers, int count){
        int workCount = count;
        if(workers.get(0).isDone()){
            workers.remove(0);
//            workCount++;
            count++;
            recursive(workers, count);
        }
//        return workCount;
    }
    public void progressAllWorker(List<Worker> workers){
        for(Worker w : workers){
            w.progressWork();
        }
    }
    class Worker {
        int work;
        int speed;

        public void progressWork(){
            work+=speed;
        }

        boolean isDone(){
            return work>=100;
        }
    }
}
