package com.company;

import com.sun.org.apache.xpath.internal.operations.Mod;
import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 과제2-2
 * 배열 회전
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    //TODO: 입출력 코드 작성 필요함
        Scanner sc = new Scanner(System.in);
        Task task = new Task();
        int n; //가로열
        int m; //세로열
        String elements;
        int[][] arr; //가로열,세로열 배열
        String cmds; //실행되는 명령어
        String coordinate; //출력해야할 배열위치

        System.out.print("배열의 가로길이 : ");
        n = sc.nextInt();
        System.out.print("배열의 세로길이 : ");
        m = sc.nextInt();
        arr = new int[m][n]; //초기화

        System.out.print("배열의 원소들 (,구분) : ");
        elements = sc.next();

        String[] splitedElements = elements.split(",");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.valueOf(splitedElements[j+(i*n)]);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.print("회전명령어 : ");
        cmds = sc.next();
        System.out.print("출력할 위치 (,구분) : ");
        coordinate = sc.next();

        task.printRotateResult(arr,cmds,coordinate);

    }
}

class Task{
    int x;
    int y;

    int[][] rotate;
    public void printRotateResult(int[][] arr, String cmds, String coordinate){
        String[] crdinates = coordinate.split(",");
        this.y = Integer.valueOf(crdinates[0])-1;
        this.x = Integer.valueOf(crdinates[1])-1;
        this.rotate = arr;

        for(char cmd : cmds.toCharArray()){
            switch(cmd){
                case 'R':
                case 'L':
                    rotate(this.rotate,cmd);
                    break;
                case 'T':
                    turnOver(this.rotate);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        System.out.println(this.rotate[x][y]);
    }

    public void rotate(int[][] rotate, char direction){
        int row = rotate.length; //2차원 배열의 세로길이
        int column = rotate[0].length; //2차원 배열의 가로길이
        int[][] rotatedArr  = new int[column][row]; //회전할때마다 행열의 길이가 서로 바뀐다.

        for(int r=0; r<column; r++){
            for(int c=0; c<row; c++){
                if(direction=='R'){ //오른쪽 90도 회전일때
                    rotatedArr[r][c] = rotate[row-1-c][r];
                }else{// 왼쪽회전일때 == 오른쪽 90도 3번 회전
                    rotatedArr[r][c] = rotate[c][column-1-r];
                }
            }
        }
        this.rotate = rotatedArr;
    }

    public void turnOver(int[][] rotate){
        //TODO: 가운데를 중심으로 오른쪽과 왼쪽을 뒤집는다.
        int row = rotate.length; //2차원 배열의 세로길이
        int column = rotate[0].length; //2차원 배열의 가로길이
        int[][] turnOverArr  = new int[row][column];

        for(int r=0; r<row; r++) {
            for (int c = 0; c < column; c++) {
                turnOverArr[r][c] = rotate[r][column - 1 - c];
            }
        }
        this.rotate = turnOverArr;
    }

}
