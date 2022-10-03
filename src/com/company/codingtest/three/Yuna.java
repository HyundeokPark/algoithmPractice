package com.company.codingtest.three;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Yuna {

    public static void main(String[] args) {
        Yuna yuna = new Yuna();
        //        int[][] orders = {{2, 3, 4, 0, 1}, {1, 4, 3, 2, 0}, {4, 1, 0, 2, 3}, {3, 2, 1, 4, 0},
//            {0, 3, 2, 1, 4}};
        int[][] orders = {{2, 1, 0, 3},{3, 2, 0, 1},{3, 0, 2, 1},{2, 3, 0, 1}};
        yuna.solution(orders);
    }
    public int[] solution(int[][] orders) {
        int[] answer = {};

        int studentCount = orders.length;
        boolean[] leavingOut = new boolean[studentCount];
        int[] numberOfVotes = new int[studentCount];

        List<Integer>[] votes = new ArrayList[studentCount];
        for (int i = 0; i < votes.length; i++) {
            votes[i] = new ArrayList<>();
            for (int j = 0; j < orders[i].length; j++) {
                votes[i].add(orders[i][j]);
            }
        }

        int voteCount = 0;
        int elected = -1;
        int half = 0;
        if (studentCount % 2 == 0) {
            half = studentCount / 2;
        } else {
            half = (studentCount + 1) / 2;
        }

        while (true) {
            voteCount++;
            for (int i = 0; i < votes.length; i++) {
                numberOfVotes[votes[i].get(0)]++;
            }

            int halfCount = calcHalfStudent(numberOfVotes, half);

            if (halfCount == 2) {
                int index = 0;
                for (int i = 0; i < studentCount; i++) {
                    if (numberOfVotes[i] >= half) {
                        if (index < i) {
                            index = i;
                        }
                    }
                }
                elected = index;
                break;
            } else if (halfCount == 1) {
                int index = 0;
                for (int i = 0; i < studentCount; i++) {
                    if (numberOfVotes[i] >= half) {
                        index = i;
                    }
                }
                elected = index;
                break;
            } else {
                int minValue = Integer.MAX_VALUE;
                int minValueCount = 0;
                for (int i = 0; i < studentCount; i++) {
                    if (numberOfVotes[i] < minValue && !leavingOut[i]) {
                        minValue = numberOfVotes[i];
                    }
                }
                for (int i = 0; i < studentCount; i++) {
                    if (numberOfVotes[i] == minValue) {
                        if (!leavingOut[i]) {
                            minValueCount++;
                        }
                    }
                }


                if (minValueCount > 1) {
                    int index = getMinIndex(leavingOut);
                    leavingOut[index] = true;
                    for (int i = 0; i < studentCount; i++) {
                        votes[i].removeIf(item -> item == index);
                    }
                } else if (minValueCount == 1) {
                    int index = 0;
                    for (int i = 0; i < studentCount; i++) {
                        if (numberOfVotes[i] == minValue && !leavingOut[i]) {
                            index = i;
                        }
                    }
                    leavingOut[index] = true;
                    for (int i = 0; i < studentCount; i++) {
                        for (int j = 0; j < votes[i].size(); j++) {
                            if (votes[i].get(j) == index) {
                                votes[i].remove(j);
                            }
                        }
                    }
                }
            }

            init(numberOfVotes);

            if(voteCount == 5) {
                break;
            }
        }

        answer = new int[]{voteCount, elected};

        return answer;
    }

    private int getMinIndex(boolean[] leavingOut) {
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < leavingOut.length; i++) {
            if (!leavingOut[i]) {
                minIndex = i;
                break;
            }
        }

        return minIndex;
    }

    private int calcHalfStudent(int[] numberOfVotes, int half) {
        int count = 0;
        for (int i = 0; i < numberOfVotes.length; i++) {
            if (numberOfVotes[i] >= half) {
                count++;
            }
        }

        return count;
    }

    private void init (int[] numberOfVotes) {
        for (int i = 0; i < numberOfVotes.length; i++) {
            numberOfVotes[i] = 0;
        }
    }
}
