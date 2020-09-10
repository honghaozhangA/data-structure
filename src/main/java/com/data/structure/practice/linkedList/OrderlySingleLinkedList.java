package com.data.structure.practice.linkedList;

import org.springframework.stereotype.Component;

/**
 * 单链表，顺序添加数据
 */
@Component
public class OrderlySingleLinkedList {

    public void main() {
        OrderlySingleLinkedListDemo.add(new OrderlyHero(3,"松江大学城"));
        OrderlySingleLinkedListDemo.add(new OrderlyHero(1,"松江体育中心"));
        OrderlySingleLinkedListDemo.add(new OrderlyHero(2,"松江新城"));
        OrderlySingleLinkedListDemo.add(new OrderlyHero(4,"洞泾"));
        OrderlySingleLinkedListDemo.getLength();
        OrderlySingleLinkedListDemo.del(new OrderlyHero(3,"松江大学城"));
        OrderlySingleLinkedListDemo.getLength();
        OrderlySingleLinkedListDemo.upd(new OrderlyHero(4,"洞泾2"));
    }

}

class OrderlySingleLinkedListDemo {
    private static OrderlyHero head = new OrderlyHero(0, "");

    // 新增根据顺序来加
    public static void add(OrderlyHero hero) {
        OrderlyHero temp = head;
        boolean flag;

        while(true) {
            if(temp.getNextHero() == null) {
                flag = true;
                temp.setNextHero(hero);
                break;
            } else if(temp.getNextHero().getHeroNo() == hero.getHeroNo()) {
                flag = false;
                break;
            } else if(temp.getNextHero().getHeroNo() > hero.getHeroNo()) {
                flag = true;
                hero.setNextHero(temp.getNextHero());
                temp.setNextHero(hero);
                break;
            }
            temp = temp.getNextHero();
        }
        if(flag) {
            System.out.println("添加成功！");
            showList();
        } else {
            System.out.println("添加失败！");
        }
    }

    // 删除不变
    public static void del(OrderlyHero hero) {
        OrderlyHero temp = head;
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
            showList();
        } else {
            System.out.println("删除失败！");
        }
    }

    // 修改不变
    public static void upd(OrderlyHero hero) {
        OrderlyHero temp = head;
        boolean flag;

        while(true) {
            if(temp.getNextHero() == null) {
                flag = false;
                break;
            } else if(temp.getNextHero().getHeroNo() == hero.getHeroNo()) {
                flag = true;
                temp.getNextHero().setHeroName(hero.getHeroName());
                break;
            }
            temp = temp.getNextHero();
        }
        if(flag) {
            System.out.println("修改成功！");
            showList();
        } else {
            System.out.println("修改失败！");
        }
    }

    public static void showList() {
        System.out.println(head);
    }

    public static int getLength() {
        int length = 0;
        OrderlyHero temp = head;

        while (true) {
            if(temp.getNextHero() != null) {
                length++;
            } else {
                break;
            }
            temp = temp.getNextHero();
        }
        System.out.println("length：" + length);
        return length;
    }
}

class OrderlyHero {
    private int heroNo;
    private String heroName;
    private OrderlyHero nextHero;

    public OrderlyHero(int heroNo, String heroName) {
        this.heroNo = heroNo;
        this.heroName = heroName;
    }

    public void setNextHero(OrderlyHero nextHero) {
        this.nextHero = nextHero;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroNo() {
        return heroNo;
    }

    public OrderlyHero getNextHero() {
        return nextHero;
    }

    @Override
    public String toString() {
        return "OrderlyHero{" +
            "heroNo=" + heroNo +
            ", heroName='" + heroName + '\'' +
            ", nextHero=" + nextHero +
            '}';
    }
}
