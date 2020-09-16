package com.data.structure.practice.expression;

import org.springframework.stereotype.Component;

// 中缀表达式求值
@Component
public class ExpressionOperation {

    public void main() {
        String str = "5*4+6/3*2%3";
        System.out.println(Operation.run(str));
    }
}

class Operation {
    // 是否是数字
    public static boolean isNumber(char val) {
        if(val == '*' || val == '/' || val == '%' || val == '+' || val == '-') {
            return false;
        }
        return true;
    }

    // 是否有优先权
    public static int hasPriority(char val) {
        if(val == '*' || val == '/' || val == '%') {
            return 1;
        } else if(val == '+' || val == '-') {
            return 0;
        } else {
            System.out.println("不支持的运算符");
            return -1;
        }
    }

    public static int calculate(int num1, int num2, int symbol) {
        int result = 0;
        switch (symbol) {
            case '/':
                result = num2 / num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '%':
                result = num2 % num1;
                break;
            default:
                throw new RuntimeException("运算符错误");
        }
        return result;
    }

    public static int run(String str) {
        ArrayStack arrayStack1 = new ArrayStack();
        ArrayStack arrayStack2 = new ArrayStack();
        int index = 0;// 检索表达式的下标
        char val = ' ';// 当前检索到的值
        int priority = 0;// 优先级
        int length = -1;// 二次计算长度

        while(true) {
            val = str.substring(index, index + 1).charAt(0);
            if(isNumber(val)) {// 数字则入数栈
                arrayStack1.push(Integer.parseInt(val + ""));
            } else {// 否则符合判断
                if(arrayStack2.index == -1) {// 第一个符号直接入栈
                    arrayStack2.push(val);
                    priority = hasPriority(val);
                } else {// 第二个符号比较
                    if(hasPriority(val) <= priority) {// 如果当前符号优先级小于等于栈内符号，则取出符号和两个数计算，当前符号入栈
                        arrayStack1.push(calculate(arrayStack1.pop(), arrayStack1.pop(), arrayStack2.pop()));
                        arrayStack2.push(val);
                    } else {// 大于则当前符号入栈
                        arrayStack2.push(val);
                    }
                    priority = hasPriority(val);
                }
            }

            if(index + 1 == str.length()) {
                break;
            }
            index++;
        }

        length = arrayStack2.index;
        for(int m = 0; m <= length; m++) {
            arrayStack1.push(calculate(arrayStack1.pop(), arrayStack1.pop(), arrayStack2.pop()));
        }

        return arrayStack1.pop();
    }
}

class ArrayStack {
    int maxSize = 10;
    int [] stack = new int[maxSize];
    int index = -1;

    public void push(int number) {
        if(index == maxSize - 1) {
            System.out.println("栈满");
            return;
        }
        index++;
        stack[index] = number;
    }

    public int pop() {
        if(index < 0) {
            throw new RuntimeException("栈空");
        }
        int num = stack[index];
        index--;
        return num;
    }

    @Override
    public String toString() {
        return "ArrayStack:" + stack;
    }
}
