package com.example.SpringData.domain;

import javax.persistence.*;

/**
 * Created by Brave on 16/10/13.
 */
@Entity
@Table
public class Card {

    public Card() {

    }

    public Card(Integer cardId, String cardNumber) {
        this.cardNumber = cardNumber;
        this.cardId = cardId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardId;

    @Column(nullable = false)
    private String cardNumber;

    /**
     * @OneToOne：一对一关联
     * mappedBy = "card"：意思是说这里的一对一配置参考了card
     * card又是什么呢?card是Person类中的getCard(),注意不是Person类中的
     * card属性,Person类中的OneToOne配置就是在getCard()方法上面配的.
     * 如果Person类中的getCard()方法改成getIdCard(),其他不变的话,
     * 这里就要写成：mappedBy = "idCard"
     */
    @OneToOne(mappedBy = "card", fetch=FetchType.EAGER)
    private User user;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
