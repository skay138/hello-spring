package com.study.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

}
