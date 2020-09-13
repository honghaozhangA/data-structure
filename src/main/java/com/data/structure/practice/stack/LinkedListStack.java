package com.data.structure.practice.stack;

import org.springframework.stereotype.Component;

// 链表模拟栈
@Component
public class LinkedListStack {

    public void main() {
        LinkedListStackDemo.addElement(new StackElement(11));
        LinkedListStackDemo.addElement(new StackElement(22));
        LinkedListStackDemo.addElement(new StackElement(33));
        LinkedListStackDemo.showStack();
        LinkedListStackDemo.getElement();
        LinkedListStackDemo.showStack();
        LinkedListStackDemo.getElement();
        LinkedListStackDemo.getElement();
        LinkedListStackDemo.getElement();

        LinkedListStackDemo.showStack();
    }
}

class LinkedListStackDemo {
    static StackElement first = new StackElement(0);
    static int index = -1;

    public static void addElement(StackElement element) {
        StackElement topElement = first;
        while(true) {
            if(index == -1) {
                first = element;
                index++;
                break;
            }
            for(int m = 0; m < index; m++) {
                topElement = topElement.nextElement;
            }
            topElement.nextElement = element;
            index++;
            break;
        }
    }

    public static void getElement() {
        StackElement topElement = first;

        if (index < 0) {
            System.out.println("没有数据可取！");
            return;
        } else if(index == 0) {
            System.out.println("取出：" + first.elementValue);
            first = null;
        } else {
            for(int m = 0; m < index - 1; m++) {
                topElement = topElement.nextElement;
            }
            System.out.println("取出：" + topElement.nextElement.elementValue);
            topElement.nextElement = null;
        }
        index--;
    }

    public static void showStack() {
        if(index < 0) {
            System.out.println("showStack：没有数据！");
            return;
        }

        StackElement topElement = first;
        System.out.println("showStack-----");
        for(int m = 0; m <= index; m++) {
            System.out.println(topElement);
            topElement = topElement.nextElement;
        }
        System.out.println("showStack-----");
    }

}

class StackElement {
    int elementValue;
    StackElement nextElement;

    public StackElement(int elementValue) {
        this.elementValue = elementValue;
    }

    @Override
    public String toString() {
        return "StackElement{" +
            "elementValue=" + elementValue +
            '}';
    }
}