package com.study.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.study.hellospring.domain.Member;

import jakarta.persistence.EntityManager;

// @Repository
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("SELECT m from Member m", Member.class).getResultList();
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> resultList = em.createQuery("SELECT m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
}
