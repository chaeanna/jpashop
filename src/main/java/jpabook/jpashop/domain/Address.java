package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //public보단 protected가 안전함.
    protected Address() {
    }

    //값 타입은 변경 불가능하게 설계해야함.
    //생성자에서 값을 모두 초기화해서 변경 불가능한 클래스로 만듦
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
