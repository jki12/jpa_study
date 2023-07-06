package com.example.demo;

import com.example.demo.member.Member;
import com.example.demo.repo.MemberRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class DemoApplicationTests {
	@Autowired private MemberRepo repo;

	@Test
	void test() {
		Member member = new Member("member1");

		repo.save(member);

		Member findMember = repo.findById(member.getId()).get();
		Assertions.assertEquals(findMember, member);


		findMember = repo.findByName(member.getName()).orElseGet(() -> new Member("void"));
		// Assertions.assertEquals(findMember, member);
	}

	@Test
	void contextLoads() {
	}

}
