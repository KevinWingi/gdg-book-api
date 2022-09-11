package com.gdgbookapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
	
	private Long id;
	
	@NotBlank(message = "Title required")
	private String title;
	
	@NotNull(message = "Number of pages required")
	private Integer numPages;
	
	@NotBlank(message = "Autor required")
	private String autor;
		
	private String description;
	
	private Integer publishYear;

}
