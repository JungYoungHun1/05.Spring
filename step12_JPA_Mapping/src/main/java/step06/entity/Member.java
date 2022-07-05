package step06.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = {"memberProducts"})
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private Long id;
	
	@Column(length = 20)
	private String name;
	
	private Integer age;
	
	@OneToMany(mappedBy = "member")
//	@OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE})
	private List<Order> memberProducts = new ArrayList<Order>();
	

	
}
