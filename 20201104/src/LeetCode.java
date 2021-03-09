
/*
猫狗书容所
https://leetcode-cn.com/problems/animal-shelter-lcci/
 */

/*
有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型(猫或狗)，并收养该种动物中最早进入收容所的。

给定一个操作序列int[][2] ope(C+t中为vector<vector<int>>)代表所有事件。若第一个元素为1，
则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫;若第一个元素为2，则代表有人收养动物，
第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，
即没有可以符合领养要求的动物，则将这次领养操作忽略。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        /*
        建立三个队列，一个放收养的猫，一个放收养的狗，一个放所有收养的动物。因为队列的特性，先放入其中的就先出队列，
         */
            Queue<Integer> catQueue = new LinkedList<Integer>();
            Queue<Integer> dogQueue = new LinkedList<Integer>();
            Queue<Integer> allQueue = new LinkedList<Integer>();
            ArrayList<Integer> res = new ArrayList<Integer>();


            for (int i = 0; i < ope.length; i++) {
                if (ope[i][0] == 1) {// 进收养所
                    if (ope[i][1] > 0) {// 狗
                        dogQueue.offer(ope[i][1]);
                    }
                    if (ope[i][1] < 0) {// 猫
                        catQueue.offer(ope[i][1]);
                    }
                    allQueue.offer(ope[i][1]);
                }
                if (ope[i][0] == 2) {// 有人收养
                    if (ope[i][1] == 0) {// 收养最早的
                        if(!allQueue.isEmpty()){
                            int popNum = allQueue.poll();
                            res.add(popNum);
                            if (popNum > 0) {
                                dogQueue.poll();
                            } else if(popNum < 0) {
                                catQueue.poll();
                            }
                        }
                    }

                    if (ope[i][1] == 1) {// 收养最早的狗
                        if(!dogQueue.isEmpty()){
                            int tmp = dogQueue.poll();
                            res.add(tmp);
                            allQueue.remove(tmp);
                        }
                    }

                    if (ope[i][1] == -1) {// 收养最早的猫
                        if(!catQueue.isEmpty()){
                            int tmp = catQueue.poll();
                            res.add(tmp);
                            allQueue.remove(tmp);
                        }
                    }
                }
            }

            return res;
        }


    }


public class LeetCode {
}
