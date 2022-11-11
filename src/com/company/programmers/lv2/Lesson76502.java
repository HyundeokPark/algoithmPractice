package com.company.programmers.lv2;

import java.util.Stack;

public class Lesson76502 {

    public static void main(String[] args) {
        Lesson76502 lesson = new Lesson76502();
        String s = "}]()[{";
        System.out.println(lesson.solution(s));
    }

    /**
     * (), [], {} 는 모두 올바른 괄호 문자열입니다.
     * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
     *  예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
     * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
     *  예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
     * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 다음 표는 "[](){}" 를 회전시킨 모습을 나타낸 것입니다.
     * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
     * 0	"[](){}"	O
     * 1	"](){}["	X
     * 2	"(){}[]"	O
     * 3	"){}[]("	X
     * 4	"{}[]()"	O
     * 5	"}[](){"	X
     *
     * keyPoint
     * 1. 문제에선 A,B등의 단어를 추가해 설명을 하지만 쓸모없다. 어차피 문자열 s 는 괄호만으로 이루어져있다.
     * 2. 그리고 예시를 보면 한가지 규칙을 알수있는데, 결국 괄호가 열리면 닫혀야 올바른 문자열이 된다.
     * 3. 즉, 예전 처럼 스택을 이용하면 해결할 수 있을 것 같다.
     * 4. 문자열 s를 한번씩 왼쪽으로 회전시켜 확인해 보자.
     * 20221111 추가사항
     * 5. 한가지 간과한것이 있는데, ([)] 와 같은 문자열은 위 문제에 따르면 올바르지 않다.
     * 6. 해당 부분에 대한 필터를 추가로 해줘야 한다... How?..
     * 7. 3개의 Stack으로 나눴지만, 1개의 Stack만으로 해결하면 할 수 있을것 같다. 정확성만 체크하므로 시간은 신경쓰지말자!
     * @param s
     * @return
     */
    public int solution(String s) {
        int answer = 0;
        String target = s;
        //문자열을 한번씩 회전 시키고, 올바른 문자열인지 판단하는 반복문
        for(int i=0; i<s.length(); i++){
            //TODO: 여기에 올바른지 확인하는 함수 필요
            boolean isValid = this.validateTarget(target);
            if(isValid){
             answer++;
            }
            target = this.rotateString(target);
        }
        return answer;
    }

    /**
     * 문자열이 올바른지 확인한다.
     * @param target
     */
    public boolean validateTarget(String target){
        Stack stack = new Stack();
        boolean result = false;
        for(String str : target.split("")){
            if(str.equals("(") || str.equals("{") || str.equals("[")){
                stack.push(str);
            }else{
              if(stack.isEmpty() || stack.peek().equals(")") || stack.peek().equals("}") || stack.peek().equals("]")){
                  return result;
              }
              if(stack.peek().equals("(") && str.equals(")")){
                  stack.pop();
              }else if(stack.peek().equals("{") && str.equals("}")){
                  stack.pop();
              }else if(stack.peek().equals("[") && str.equals("]")){
                  stack.pop();
              }
            }
        }
        if(stack.isEmpty()){
            result = true;
        }
        return result;
    }

    /**
     * @param target
     * @return : target의 첫 문자를 끝에 붙여 반환
     */
    public String rotateString(String target){
        target = target.substring(1,target.length()) + target.substring(0,1);
        return target;
    }
}
