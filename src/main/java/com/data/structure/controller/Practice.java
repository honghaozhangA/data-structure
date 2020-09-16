package com.data.structure.controller;

import com.data.structure.api.DataStructure;
import com.data.structure.practice.expression.ConvertInfixToSuffix;
import com.data.structure.practice.expression.ExpressionOperation;
import com.data.structure.practice.expression.PolandExpression;
import com.data.structure.practice.linkedList.AnnularLinkedList;
import com.data.structure.practice.linkedList.OrderlySingleLinkedList;
import com.data.structure.practice.linkedList.SingleLinkedList;
import com.data.structure.practice.linkedList.TwoWayLinkedList;
import com.data.structure.practice.queue.AnnularQueue;
import com.data.structure.practice.queue.QueuePractice;
import com.data.structure.practice.sparseaArray.SparseArray;
import com.data.structure.practice.stack.LinkedListStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * 待重新优化，越来越多，改用懒加载
 */
@Controller
public class Practice implements DataStructure {

    // region 注入
    @Autowired
    private SparseArray sparseArray;

    @Autowired
    private QueuePractice queuePractice;

    @Autowired
    private AnnularQueue annularQueue;

    @Autowired
    private SingleLinkedList singleLinkedList;

    @Autowired
    private OrderlySingleLinkedList orderlySingleLinkedList;

    @Autowired
    private TwoWayLinkedList twoWayLinkedList;

    @Autowired
    private AnnularLinkedList annularLinkedList;

    @Autowired
    private LinkedListStack linkedListStack;

    @Autowired
    private ExpressionOperation expressionOperation;

    @Autowired
    private PolandExpression polandExpression;

    @Autowired
    private ConvertInfixToSuffix convertInfixToSuffix;
    // endregion

    @Override
    public void executeDataStructure(String str) throws IOException {
        switch(str) {
            // 稀疏数组
            case "sparseArray":
                sparseArray.main();
                break;
            // 数组模拟队列
            case "queuePractice":
                queuePractice.main();
                break;
            // 环形队列
            case "annularQueue":
                annularQueue.main();
                break;
            // 单链表
            case "singleLinkedList":
                singleLinkedList.main();
                break;
            // 有序单链表
            case "orderlySingleLinkedList":
                orderlySingleLinkedList.main();
                break;
            // 双向链表
            case "twoWayLinkedList":
                twoWayLinkedList.main();
                break;
            // 环形链表
            case "annularLinkedList":
                annularLinkedList.main();
                break;
            // 链表模拟栈
            case "linkedListStack":
                linkedListStack.main();
                break;
            // 中缀表达式计算
            case "expressionOperation":
                expressionOperation.main();
                break;
            // 后缀表达式计算
            case "polandExpression":
                polandExpression.main();
                break;
            // 中缀表达式转后缀表达式
            case "convertInfixToSuffix":
                convertInfixToSuffix.main();
                break;
        }
    }
}
