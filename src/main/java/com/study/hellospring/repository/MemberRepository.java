package com.study.hellospring.repository;

import com.study.hellospring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String nameString);

    List<Member> findAll();

}