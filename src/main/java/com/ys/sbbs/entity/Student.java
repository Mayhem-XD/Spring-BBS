package com.ys.sbbs.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * 아래의 어노테이션을 사용하게 되면
 * 기본 생성자, 모든 멤버변수 생성자, toString(), Getter/Setter를 만들어 줌
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Student {
	private int sid;
	private String name;
	private LocalDate regDate;

}
