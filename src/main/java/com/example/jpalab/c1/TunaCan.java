package com.example.jpalab.c1;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //lombok에서 지원하는 어노테이션
/*
setter는 만들지 않음
get과 set이 모든 필드에 있으면 사실상 private가 아니라고 생각.
필요한 필드에 대해서만 set을 열어두자.
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 만들어주기
/*
기본생성자는 설정이 없을 시 public으로 설정되어진다.
jpa에서는 private이면 안됨 - 영속성컨텍스트에서 프록시 생성 시 지원이 안되기때문
public인가 protected인가? 엔간하면 protected로 설정하고, 필요하면 public이 좋지않을까
보수적인 방향에서
*/

@Entity
@Table(name = "tuna_can") //테이블 이름 설정

public class TunaCan {

	@Id //기본키(PK) 라는 뜻
	@GeneratedValue //대리키방식으로 기본키를 만들고, 옵션없을 시 AUTO로 만듬
	@Column(name = "tuna_can_id") //컬럼 이름을 지정해줌
	private Long id; //long타입으로 하면 null값에 대해서 0으로 표현되기에
	//왜 int를 쓰지 않는가? - 어느순간 int의 범위를 벗어나버릴 수 있기 때문(overflow)


	@ManyToOne
	@JoinColumn(name = "tuna_factory")
	private TunaFactory tunaFactoryList;
}
