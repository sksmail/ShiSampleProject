package SHI.Server.Test.edu.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int addr;
	
	public Member() {
    }
	
    public Member(String name, int addr) {
        this.name = name;
        this.addr = addr;
    }
}
