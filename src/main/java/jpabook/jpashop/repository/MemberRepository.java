package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;


    //회원 등록
    public void save(Member member) {
        em.persist(member);
    }

    //회원 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //회원 리스트 조회
    public List<Member> findAll(){

        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //회원 이름으로 검색
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
