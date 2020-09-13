package com.data.structure.practice.linkedList;

import org.springframework.stereotype.Component;

/**
 * 双向链表，添加数据至末尾，无序
 */
@Component
public class TwoWayLinkedList {

    public void main() {
        TwoWayLinkedListDemo.add(new TwoWayHero(1,"松江体育中心"));
        TwoWayLinkedListDemo.add(new TwoWayHero(2,"松江新城"));
        TwoWayLinkedListDemo.add(new TwoWayHero(3,"松江大学城"));
        TwoWayLinkedListDemo.add(new TwoWayHero(4,"洞泾"));
        TwoWayLinkedListDemo.showList();
        TwoWayLinkedListDemo.del(new TwoWayHero(3,"松江大学城"));
        TwoWayLinkedListDemo.showList();
    }

}

class TwoWayLinkedListDemo {
    private static TwoWayHero head = new TwoWayHero(0, "");

    // 添加方法较单链表有变化
    public static void add(TwoWayHero hero) {
        TwoWayHero temp = head;
        while(true) {
            if(temp.getNextHero() == null) {
                temp.setNextHero(hero);
                hero.setPreHero(temp);
                break;
            }
            temp = temp.getNextHero();
        }
        System.out.println("添加成功！");
    }

    // 删除方法较单链表有变化
    public static void del(TwoWayHero hero) {
        TwoWayHero temp = head;
        boolean flag;

        while(true) {
            if(temp.getNextHero() == null) {
                flag = false;
                break;
            } else if(temp.getNextHero().getHeroNo() == hero.getHeroNo()) {
                flag = true;
                temp.getNextHero().getNextHero().setPreHero(temp);
                temp.setNextHero(temp.getNextHero().getNextHero());
                break;
            }
            temp = temp.getNextHero();
        }
        if(flag) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    public static void showList() {
        TwoWayHero temp = head;

        while(true) {
            if(temp.getNextHero() == null) {
                break;
            }
            System.out.println(temp.getNextHero());
            temp = temp.getNextHero();
        }
    }
}

class TwoWayHero {
    private int heroNo;
    private String heroName;
    private TwoWayHero nextHero;
    private TwoWayHero preHero;

    public TwoWayHero() {}

    public TwoWayHero(int heroNo, String heroName) {
        this.heroNo = heroNo;
        this.heroName = heroName;
    }

    public void setNextHero(TwoWayHero nextHero) {
        this.nextHero = nextHero;
    }

    public void setPreHero(TwoWayHero preHero) {
        this.preHero = preHero;
    }

    public TwoWayHero getPreHero() {
        return preHero;
    }

    public int getHeroNo() {
        return heroNo;
    }

    public TwoWayHero getNextHero() {
        return nextHero;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "heroNo=" + heroNo +
            ", heroName='" + heroName + '\'' +
            '}';
    }
}
