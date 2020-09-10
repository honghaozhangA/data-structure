package com.data.structure.practice.queue;

import org.springframework.stereotype.Component;

/**
 * 数组模拟环形队列，动态下标
 * 采用 index % maxSize 让下标循环
 */
@Component
public class AnnularQueue {

    int maxSize = 4;// 最大为4，实际有一个预留位，只有3
    int [] queue = new int[maxSize];
    int temp = 0;

    // 指向第一位
    int frontPointer = 0;

    // 指向最后一位的后一位
    int finalPointer = 0;

    public void addQueue(int data) {
        if(!isFull()) {
            queue[finalPointer] = data;
            finalPointer = (finalPointer + 1) % maxSize;
        } else {
            System.out.println("当前队列已满！");
        }
    }

    public int getQueue() {
        if(!isEmpty()) {
            temp = frontPointer;
            frontPointer = (frontPointer + 1) % maxSize;
            return queue[temp];
        }
//        throw new RuntimeException("队列为空");
        System.out.println("队列为空");
        return -2;
    }

    public boolean isFull() {
        return frontPointer == (finalPointer + 1) % maxSize;
    }

    public boolean isEmpty() {
        return frontPointer == finalPointer;
    }

    public void main() {
        addQueue(11);
        addQueue(22);
        addQueue(33);
        addQueue(44);   // 当前队列已满
        System.out.println(getQueue());
        System.out.println(getQueue());
        System.out.println(getQueue());
        System.out.println(getQueue()); // 队列为空
    }
}