package step02.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Car {
	// Bean 조건 : 기본 생성자 필수, private 필드 존재 필수, getter, setter 존재 필수
	private int carNo;
	private String carName;
	
	public Car() {
		System.out.println("Car 기본 생성자");
	}
	
	public Car(int carNo, String carName) {
		this.carNo = carNo;
		this.carName = carName;
		System.out.println("Car 생성자");
	}

}
