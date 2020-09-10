package com.data.structure.practice.queue;

import org.springframework.stereotype.Component;

// 数组模拟普通队列
@Component
public class QueuePractice {

    int maxSize = 4;
    int [] queue = new int[maxSize];

    // 指向当前下标的前一位
    int frontPointer = -1;

    // 指向最后一位数据的下标
    int finalPointer = 0;

    public void addQueue(int data) {
        if(!isFull()) {
            queue[finalPointer++] = data;
        } else {
            System.out.println("当前队列已满！");
        }
    }

    public int getQueue() {
        if(!isEmpty()) {
            return queue[++frontPointer];
        }
        throw new RuntimeException("队列为空");
    }

    public boolean isFull() {
        return finalPointer == maxSize;
    }

    public boolean isEmpty() {
        return (frontPointer + 1) == finalPointer;
    }

    public void main() {
        addQueue(11);
        addQueue(22);
        addQueue(33);
        addQueue(44);
        addQueue(55);
        System.out.println(getQueue());
        System.out.println(getQueue());
        System.out.println(getQueue());
        System.out.println(getQueue());
        System.out.println(getQueue());
    }
}