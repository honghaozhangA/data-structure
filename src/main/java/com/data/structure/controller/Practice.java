package com.data.structure.controller;

import com.data.structure.api.DataStructure;
import com.data.structure.practice.linkedList.OrderlySingleLinkedList;
import com.data.structure.practice.linkedList.SingleLinkedList;
import com.data.structure.practice.queue.AnnularQueue;
import com.data.structure.practice.queue.QueuePractice;
import com.data.structure.practice.sparseaArray.SparseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class Practice implements DataStructure {

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

    @Override
    public void executeDataStructure(String str) throws IOException {
        switch(str) {
            case "sparseArray":
                sparseArray.main();
                break;
            case "queuePractice":
                queuePractice.main();
                break;
            case "annularQueue":
                annularQueue.main();
                break;
            case "singleLinkedList":
                singleLinkedList.main();
                break;
            case "orderlySingleLinkedList":
                orderlySingleLinkedList.main();
                break;
        }
    }
}
