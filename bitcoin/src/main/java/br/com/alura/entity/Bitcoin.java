package br.com.alura.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bitcoin {

	
	private Long id;
	private Double preco;
	private String tipo;
	private LocalDate data;


}
