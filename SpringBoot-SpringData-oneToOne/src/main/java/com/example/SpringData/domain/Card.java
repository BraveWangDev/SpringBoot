package com.example.SpringData.domain;

import javax.persistence.*;

/**
 * Created by Brave on 16/10/13.
 */
@Entity
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
     * mappedBy = "card"：一对一配置参考了card
     * mappedBy = "card"中的User类中的getCard()中的Care(去除get)
     * 如果User类getCard()改为getIdCard(),这里就要写成：mappedBy = "idCard"
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
