package com.example.demo.repo;

import com.example.demo.member.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepo {
    @PersistenceContext // not working.
    private EntityManager em;

    private boolean isExists(Optional<Member> member) {
            return (member.isPresent());
    }

    public Optional<Member> findByName(String name) {
        // var member = em.find(Member.class, name); // find() - only primary key.

        return Optional.empty();
    }

    public Optional<Member> findById(long id) {
        var member = em.find(Member.class, id);

        return Optional.ofNullable(member);
    }

    public Member save(Member member) {
        // if (findById(member.getId()).isPresent()) return null; // to optional

        em.persist(member);

        return member;
    }

    public void flush() {

        em.flush();

    }
}
