package com.example.jpalab.c1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tuna_factory")
public class TunaFactory {

	@Id
	@GeneratedValue
	@Column(name = "tuna_factory_id")
	private Long id;

	@OneToMany(mappedBy = "tuna_can_id")
	private List<TunaCan> tunaCanList = new ArrayList<>();
}
