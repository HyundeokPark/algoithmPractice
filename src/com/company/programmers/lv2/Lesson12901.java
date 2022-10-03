package com.company.programmers.lv2;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import java.util.Stack;

public class Lesson12901 {

    /**
     * "()()"	true
     *         "(())()"	true
     *         ")()("	false
     *         "(()("	false
     * @param args
     */
    public static void main(String[] args) {
        Lesson12901 lesson = new Lesson12901();
        String s = "()()";


        System.out.println(lesson.solution(s));
    }

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) != '('){
                 return false;
                }
                stack.push(s.charAt(i));
                continue;
            }

            if(s.charAt(i) == ')'){
                stack.pop();
            }else{
                if(s.charAt(i) != '('){
                    return false;
                }
                stack.push(s.charAt(i));
            }
        }
        answer = stack.isEmpty();
        return answer;
    }


}
