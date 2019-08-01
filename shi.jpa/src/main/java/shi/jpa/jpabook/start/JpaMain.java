package shi.jpa.jpabook.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		
		// [��ƼƼ �Ŵ��� ���丮] ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		
		//��ƼƼ �Ŵ��� ����
		EntityManager em = emf.createEntityManager();
		// Ʈ����� ȹ��
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		}catch (Exception e)
		{
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
	
	// ����Ͻ� ����
	private static void logic(EntityManager em) {
		String id = "id1";
		
		Member member = new Member();
		member.setId(id);
		member.setUsername("����");
		member.setAge(2);
		
		// ���
		em.persist(member);
		
		// ����
		member.setAge(20);
		
		// �Ѱ� ��ȸ
		Member findMember = em.find(Member.class, id);
		System.out.println("findMember =" + findMember.getUsername() + ", age = " + findMember.getAge());
		
		// ��� ��ȸ
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("member.size =" + members.size());
		
		// ����
		em.remove(member);
	}

}
