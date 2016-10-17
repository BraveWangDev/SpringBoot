package com.example.SpringData.domain;

import javax.persistence.*;

/**
 * Created by Brave on 16/10/12.
 */
@Entity
public class User {

    //没有默认构造会报错
    public User(){

    }

    public User(String name, Integer age, Card card) {
        this.name = name;
        this.age = age;
        this.card = card;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    /**
     * @OneToOne：一对一关联
     * cascade：级联配置
     * CascadeType.PERSIST: 级联新建
     * CascadeType.REMOVE : 级联删除
     * CascadeType.REFRESH: 级联刷新
     * CascadeType.MERGE  : 级联更新
     * CascadeType.ALL    : 以上全部四项
     * @JoinColumn:主表外键字段
     * cid：Care所映射的表中的一个字段(会在User表创建一个cid字段,与Care外键关系)
     */
    @OneToOne(cascade = CascadeType.REFRESH)//使用CascadeType.ALL无法保存成功
    @JoinColumn(name = "cid", unique=true)
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}