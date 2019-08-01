package shi.jpa.jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MEMBER")
public class Member {
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String username;
	
	//매핑정보가 없는 필드
	private Integer age;
}
