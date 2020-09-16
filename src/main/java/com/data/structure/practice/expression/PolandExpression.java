package com.data.structure.practice.expression;

import org.springframework.stereotype.Component;

import java.util.Stack;

// 逆波兰表达式（后缀表达式）求值
@Component
public class PolandExpression {
    // (3+4)-3*6
    String expression = "3 4 + 3 6 * -";
    Stack<String> stack = new Stack<>();
    int firstNum;
    int secondNum;

    public void main() {
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
