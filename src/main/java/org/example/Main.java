package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //등록
            /*
            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
            System.out.println("=== BEFORE ===");
            //영속
            em.persist(member);
            System.out.println("=== AFTER ===");*/

            //Member findMember1 = em.find(Member.class, 101L);
            //Member findMember2 = em.find(Member.class, 101L);

            //System.out.println("findMember.id = " + findMember2.getId());
            //System.out.println("findMember.name = " + findMember2.getName());
            //System.out.println("result = " + (findMember1 == findMember2)); //동일성 비교 true

            /* 수정
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            findMember.setName("HelloJPA");
            */

            //삭제 em.remove(findMember);

            /* 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //.setFirstResult(5)
                    //.setMaxResults(8)
                    .getResultList();


            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            */

            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);*/

            /*Member member = em.find(Member.class, 150l);
            member.setName("ZZZZZ");*/

            /*Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();*/

            Member member = em.find(Member.class, 150l);
            member.setName("AAAAA");

            //em.detach(member);
            //em.clear();
            em.close();

            Member member2 = em.find(Member.class, 150l);

            System.out.println(" ================= ");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}