package com.data.structure.practice.linkedList;

import org.springframework.stereotype.Component;

/**
 * 环形链表链表，无 头结点，解决约瑟夫问题
 */
@Component
public class AnnularLinkedList {

    public void main() {
        AnnularLinkedListDemo.add(8);
        AnnularLinkedListDemo.showList();
        AnnularLinkedListDemo.countHero(1, 2);
    }

}

class AnnularLinkedListDemo {
    private static AnnularHero first = null;
    private static AnnularHero curHero;

    public static void add(int num) {
        if(num < 2) {
            System.out.println("人数太少");
        } else {
            for(int i = 1; i <= num; i ++) {
                if(i == 1) {
                    first = new AnnularHero(i);
                    first.setNextHero(first);
                    curHero = first;
                } else {
                    curHero.setNextHero(new AnnularHero(i));
                    curHero.getNextHero().setNextHero(first);
                }
                curHero = curHero.getNextHero();
            }
        }
    }

    public static int getCountNum() {
        curHero = first;
        int num = 0;

        if (curHero == null) {
            return num;
        }

        while (true) {
            num++;
            if (curHero.getNextHero() == first) {
                break;
            }
            curHero = curHero.getNextHero();
        }
        return num;
    }

    // 根据输入，计算出出圈的顺序
    // startNo开始，num数几位
    public static void countHero(int startNo, int num) {
        curHero = first;

        // 过滤错误数据
        if (first == null || startNo < 1 || startNo > getCountNum()) {
            System.out.println("数据有误!");
            return;
        }

        // 找到最后一个节点
        while (true) {
            if (curHero.getNextHero() == first) {
                break;
            }
            curHero = curHero.getNextHero();
        }

        // 定位开始的位置
        for (int m = 0; m < startNo - 1; m++) {
            curHero = curHero.getNextHero();
            first = first.getNextHero();
        }
        System.out.println("开始：" + first.getHeroNo());

        // 开始循环计数
        while (true) {
            // 当首尾一致，则最后一位
            if (curHero == first) {
                break;
            }
            for (int m = 0; m < num; m++) {
                first = first.getNextHero();
                curHero = curHero.getNextHero();
            }
            System.out.println("出圈：" + first.getHeroNo());
            first = first.getNextHero();
            curHero.setNextHero(first);
        }
        System.out.println("最后出圈的是：" + curHero.getHeroNo());
    }

    public static void showList() {
        curHero = first;
        if(first.getNextHero() != null) {
            while (true) {
                System.out.println(curHero);
                if(curHero.getNextHero() == first) {
                    break;
                }
                curHero = curHero.getNextHero();
            }
        } else {
            System.out.println("没有对象");
            return;
        }
    }
}

class AnnularHero {
    private int heroNo;
    private AnnularHero nextHero;

    public AnnularHero() {}

    public AnnularHero(int heroNo) {
        this.heroNo = heroNo;
    }

    public void setNextHero(AnnularHero nextHero) {
        this.nextHero = nextHero;
    }

    public int getHeroNo() {
        return heroNo;
    }

    public AnnularHero getNextHero() {
        return nextHero;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "heroNo=" + heroNo +
            '}';
    }
}
