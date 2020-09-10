package com.data.structure;

import com.data.structure.api.DataStructure;
import com.data.structure.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);

        DataStructure practice = ApplicationContextUtil.getBean(DataStructure.class);
        practice.executeDataStructure("orderlySingleLinkedList");
    }
}
