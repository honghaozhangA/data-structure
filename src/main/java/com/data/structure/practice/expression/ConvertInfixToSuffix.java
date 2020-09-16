package com.data.structure.practice.expression;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 逆波兰表达式（后缀表达式）求值
@Component
public class ConvertInfixToSuffix {
    // (3+4)-3*6
    String str = "4*((3+4)-3)*6";

    // 另一种方法是将String取出每个字符，将多位数合并，放入list,循环list，操作更便捷
    public void main() {
        Stack symbolStack = new Stack();
        Stack numberStack = new Stack();
        StringBuilder strBuilder = new StringBuilder();

        for(int x = 0; x < str.length(); x++) {
            if(str.charAt(x) < 48 || str.charAt(x) > 57) {// 为符号，入栈1
                if(symbolStack.empty() || "(".equals(String.valueOf(symbolStack.peek())) || "(".equals(String.valueOf(str.charAt(x)))) {// 为空或为左括号，直接入栈1
                    symbolStack.push(String.valueOf(str.charAt(x)));
                } else if(")".equals(String.valueOf(str.charAt(x)))) {// 为右括号则栈1依次入栈2，直到左括号，丢弃括号
                    while (true) {
                        numberStack.push(symbolStack.pop());
                        if("(".equals(symbolStack.peek())) {
                            symbolStack.pop();
                            break;
                        }
                    }
                } else if (getPriorities(String.valueOf(str.charAt(x))) > getPriorities(String.valueOf(symbolStack.peek()))) {// 否则 比栈顶优先级高的入栈1
                    symbolStack.push(String.valueOf(str.charAt(x)));
                } else {// 弹出高或等优先级的栈顶元素，继续比较新栈顶
                    while (!symbolStack.empty() && getPriorities(String.valueOf(str.charAt(x))) <= getPriorities(String.valueOf(symbolStack.peek()))) {
                        numberStack.push(symbolStack.pop());
                    }
                    symbolStack.push(String.valueOf(str.charAt(x)));
                }
            } else if(str.charAt(x) >= 48 && str.charAt(x) <= 57) {// 为数字，入栈2
                numberStack.push(str.charAt(x));
            } else {
                throw new RuntimeException("不支持的格式");
            }
        }
        // 剩余栈1符号一次放入栈2
        while (!symbolStack.empty()) {
            numberStack.push(symbolStack.pop());
        }
        // 倒序排序，即获得后缀表达式
        while (!numberStack.empty()) {
            symbolStack.push(numberStack.pop());
        }
        // 取出字符
        while (!symbolStack.empty()) {
            strBuilder.append(symbolStack.pop() + " ");
        }
        opera(strBuilder.toString().trim());
    }

    public int getPriorities(String symbol) {
        if("/".equals(symbol) || "*".equals(symbol)) {
            return 1;
        } else if("+".equals(symbol) || "-".equals(symbol)) {
            return 0;
        } else if("(".equals(symbol) || ")".equals(symbol)) {
            return 2;
        } else {
            throw new RuntimeException("不支持的运算符");
        }
    }

    public void opera(String expression) {
        Stack<String> stack = new Stack<>();
        int firstNum;
        int secondNum;
        String [] str = expression.split(" ");
        for(int m = 0; m < str.length; m++) {
            if(str[m].matches("\\d+")) {
                stack.push(str[m]);
            } else {
                secondNum = Integer.parseInt(stack.pop());
                firstNum = Integer.parseInt(stack.pop());

                switch (str[m]) {
                    case "/":
                        stack.push(firstNum / secondNum + "");
                        break;
                    case "*":
                        stack.push(firstNum * secondNum + "");
                        break;
                    case "%":
                        stack.push(firstNum % secondNum + "");
                        break;
                    case "+":
                        stack.push(firstNum + secondNum + "");
                        break;
                    case "-":
                        stack.push(firstNum - secondNum + "");
                        break;
                    default:
                        throw new RuntimeException("不支持的运算符");
                }
            }
        }
        System.out.println(stack.pop());
    }
}
