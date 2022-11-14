package com.company.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Lesson42586 {

    /**
     * [93, 30, 55]	[1, 30, 5]	[2, 1]
     * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     * @param args
     */
    public static void main(String[] args) {
        Lesson42586 lesson = new Lesson42586();
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        Arrays.stream(lesson.solution(progresses,speeds)).forEach(i-> System.out.println(i));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> deployedWork = new ArrayList<>();
        List<Worker> workers = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            Worker worker = new Worker(progresses[i],speeds[i]);
            workers.add(worker);
        }

        int count = 0;
        while(!workers.isEmpty()){
            count = this.recursive(workers,count);
            if(count>=1){
                deployedWork.add(count);
                count = 0;
            }
            this.progressAllWorker(workers);
        }

        answer = deployedWork.stream().mapToInt(i->i).toArray();
        return answer;
    }
    public int recursive(List<Worker> workers, int count){
//        int workCount = count;
        if(workers.get(0).isDone()){
            workers.remove(0);
//            workCount++;
            if(!workers.isEmpty()){
                count = recursive(workers, count);
            }
            count++;
        }
        return count;
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

        public Worker(int work, int speed){
            this.work = work;
            this.speed = speed;
        }
        public void progressWork(){
            work+=speed;
        }

        boolean isDone(){
            return work>=100;
        }
    }
}
