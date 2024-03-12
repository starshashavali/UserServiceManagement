package com.anarya.matrimony.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProfileForm {

	private String profilePic;

	private String relation;

	private String gender;

	private Double height;

	private String education;

	private String occuption;

	private Double income;

	private String marriageStatus;

	private String religious;

	private String caste;

	private String subCaste;

}
