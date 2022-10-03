package com.company.codingtest.line;

import com.sun.deploy.util.StringUtils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.*;
import java.util.stream.Collectors;

public class q2 {

    public static void main(String[] args) {
        q2 q = new q2();
        int size = 0;
        String[] commands = {"action addPage -1", "action 1", "undo"};
        String[] sample = {"addPage -1"};
        //["action addPage -1", "action movePage 1", "action addRound 1 0,0,50,50", "undo 2"]
        // - > ["addPage -1"]

        //["action addPage -1", "action movePage 1", "action addRound 1 0,0,50,50", "undo 2", "redo"]
        // -> ["addPage -1", "movePage 1"]
//
//        ["action addPage -1", "action movePage 1", "action addRound 1 0,0,50,50", "undo 3", "redo 2"]
//            -> ["addPage -1", "movePage 1"]
        Arrays.stream(q.ss(size, commands)).forEach(System.out::println);

    }

    public String[] solution(int size, String[] commands) {
        /**
         * 1. 우선 올바르지 않은 입력이나 오류 발생 시 빈 리스트 반환이므로 try-catch로 감싸주자
         * 2. size만큼 언두와 리두를 실행할 버퍼를 생성한다. 스택?..
         * 3. 답안?.. 출력을 해야할 스택이 필요! 아니면 큐? 리스트?? 링크드 리스트면 마지막 값 확인 가능!
         * 4. 언두 이후 새로 문자열? 입력 들어오면 리두는 할 수 없다. 버퍼를 비운다!!
         */
        String[] answer = {};
        Stack buffer = new Stack();
        buffer.setSize(size);

        LinkedList<String> tmpAnswer = new LinkedList<>();
        try {
            for (String command : commands) {
                //Undo,Redo 명령어인지 확인이 필요하다!
                if (command.contains("undo")) {
                    String[] splitedCommand = command.split(" ");
                    int repeatCount = Math.min(splitedCommand.length==2 ?Integer.valueOf(splitedCommand[1]):1, size-buffer.size());
                    for (int i = 0; i < repeatCount; i++) {
                        buffer.push(tmpAnswer.getLast());
                        tmpAnswer.removeLast();
                    }
                } else if (command.contains("redo")) {
                    String[] splitedCommand = command.split(" ");
                    int repeatCount = Math.min(splitedCommand.length==2 ?Integer.valueOf(splitedCommand[1]):1, size-buffer.size());
                    for (int i = 0; i < repeatCount; i++) {
                        tmpAnswer.add(buffer.peek().toString()); //버퍼에서 꺼내서 다시 추가!
                        buffer.pop(); //버퍼에서 제거
                    }
                } else {

                    tmpAnswer.add(command);
                    buffer.clear();
                }
            }
        } catch (Exception e) {
            return new String[]{};
        }
        answer = tmpAnswer.stream().toArray(String[]::new);
        return answer;
    }

    public String[] ss(int size, String[] commands) {
        Stack<String> deque = new Stack<>();
        Deque<String> backup = new LinkedList<>();
//        backup.setSize(size);
        try {
            for (String command : commands) {
                String[] orders = command.split(" ");
                String order = orders[0];

//                if (backup.size() > size) {
//                    backup.pollFirst();
//                }

                if (order.equals("action")) {
//                    backup = new Stack<>();
                    if(orders.length>1){
                        if(orders[1].matches("[0-9]]*")){
                            return new String[]{};
                        }

                    }
                    backup.clear();
                    deque.push(command.substring("action ".length()));

                } else if (order.equals("undo")) {
                    int count = 1;
                    if (orders.length > 1) {
                        count = Integer.parseInt(orders[1]);
                    }
                    if(size != 0){
                        count = Math.min(count,size-backup.size());
                    }
                    for (int i = 0; i < count; i++) {
                        if (!deque.isEmpty()) {
                            String s = deque.pop();
                            if(size!=0){
                                backup.push(s);
                            }
                            if (backup.size() > size) {
                                backup.pollFirst();
                            }
                        }
                    }
                } else if (order.equals("redo")) {
                    int count = 1;
                    if (orders.length > 1) {
                        count = Integer.parseInt(orders[1]);
                    }
                    for (int i = 0; i < count; i++) {
                        if (!backup.isEmpty()) {
                            String lastOrder = backup.pop();
                            deque.push(lastOrder);
                        }
                    }
                }
            }
            return deque.stream().toArray(String[]::new);
        } catch (Exception e) {
            return new ArrayList<String>().stream().toArray(String[]::new);
        }
    }
}


