package com.data.structure.practice.linkedList;

import org.springframework.stereotype.Component;

/**
 * 单链表，添加数据至末尾，无序
 */
@Component
public class SingleLinkedList {

    public void main() {
        SingleLinkedListDemo.add(new Hero(1,"松江体育中心"));
        SingleLinkedListDemo.add(new Hero(2,"松江新城"));
        SingleLinkedListDemo.add(new Hero(3,"松江大学城"));
        SingleLinkedListDemo.add(new Hero(4,"洞泾"));
        SingleLinkedListDemo.showList();
        SingleLinkedListDemo.del(new Hero(3,"松江大学城"));
        SingleLinkedListDemo.showList();
    }

}

class SingleLinkedListDemo {
    private static Hero head = new Hero(0, "");

    public static void add(Hero hero) {
        Hero temp = head;
        while(true) {
            if(temp.getNextHero() == null) {
                temp.setNextHero(hero);
                break;
            }
            temp = temp.getNextHero();
        }
        System.out.println("添加成功！");
    }

    public static void del(Hero hero) {
        Hero temp = head;
        boolean flag;

        while(true) {
            if(temp.getNextHero() == null) {
                flag = false;
                break;
            } else if(temp.getNextHero().getHeroNo() == hero.getHeroNo()) {
                flag = true;
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
        System.out.println(head.toString());
    }
}

class Hero {
    private int heroNo;
    private String heroName;
    private Hero nextHero;

    public Hero() {}

    public Hero(int heroNo, String heroName) {
        this.heroNo = heroNo;
        this.heroName = heroName;
    }

    public void setNextHero(Hero nextHero) {
        this.nextHero = nextHero;
    }

    public int getHeroNo() {
        return heroNo;
    }

    public Hero getNextHero() {
        return nextHero;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "heroNo=" + heroNo +
            ", heroName='" + heroName + '\'' +
            ", nextHero=" + nextHero +
            '}';
    }
}
