package step02.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jpa.basic.enumtype.MemberType;
import lombok.Data;

@Data
@Entity
public class Member2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long id;
	
	@Column(columnDefinition = "varchar(100) default 'A'")
	private String name;
	
	private Integer age;
	
	//
	@Column(name = "reg_time")
	private LocalDateTime registrationTime;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date registrationTimeDate;
	
//	private String memberType; // NOMAL, VIP, VVIP, ...
	
	@Column(name = "member_type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
}
