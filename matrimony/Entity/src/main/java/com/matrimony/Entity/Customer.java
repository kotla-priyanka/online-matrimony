package com.matrimony.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;


@Entity
@Table(name = "customer")
@Builder
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	  
	@NotNull
	@Size(min = 2, message = "please fill the first name ")
	private String firstName;
	@NotNull
	@Size(min = 2, message = "please fill the last name ")
	private String lastName;
	@NotNull
	@Size(min = 2, message = "please fill the password ")
	private String password;
	@NotBlank
	@Email
	private String emailId;
	@NotNull
	private long phoneNo;
	@NotNull
	@Size(min = 2, message = "please fill the caste ")
	private String caste;
	@NotNull
	@Size(min = 2, message = "please fill the religion ")
	private String religion;
	@NotNull
	@Size(min = 2, message = "please fill the education ")
	private String education;
	@NotNull
	@Size(min = 2, message = "please fill the language ")
	private String language;
	@NotNull
	@Size(min = 2, message = "please fill the location ")
	private String location;
	@NotNull
	@Size(min = 2, message = "please fill the gender ")
	private String gender;
	@NotNull
    private float height;
	@NotNull
	private float weight;
	@NotNull
	@Size(min = 2, message = "please fill the profession ")
	private String profession;
	@NotNull
	@Size(min = 2, message = "please fill the country ")
	private String country;
	@NotNull
	private String plans;
	@NotNull
	@Size(min = 2, message = "please fill the maritalStatus ")
	private String maritalStatus;
	
	
     @OneToOne(targetEntity=Payment.class,cascade=CascadeType.ALL)  
     private Payment payment;

	
     public Customer() {
 		super();
 		// TODO Auto-generated constructor stub
 	}


	

	public Customer(long id, @NotNull @Size(min = 2, message = "please fill the first name ") String firstName,
			@NotNull @Size(min = 2, message = "please fill the last name ") String lastName,
			@NotNull @Size(min = 2, message = "please fill the password ") String password,
			@NotBlank @Email String emailId, @NotNull long phoneNo,
			@NotNull @Size(min = 2, message = "please fill the caste ") String caste,
			@NotNull @Size(min = 2, message = "please fill the religion ") String religion,
			@NotNull @Size(min = 2, message = "please fill the education ") String education,
			@NotNull @Size(min = 2, message = "please fill the language ") String language,
			@NotNull @Size(min = 2, message = "please fill the location ") String location,
			@NotNull @Size(min = 2, message = "please fill the gender ") String gender, @NotNull float height,
			@NotNull float weight, @NotNull @Size(min = 2, message = "please fill the profession ") String profession,
			@NotNull @Size(min = 2, message = "please fill the country ") String country, @NotNull String plans,
			@NotNull @Size(min = 2, message = "please fill the maritalStatus ") String maritalStatus, Payment payment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.caste = caste;
		this.religion = religion;
		this.education = education;
		this.language = language;
		this.location = location;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.profession = profession;
		this.country = country;
		this.plans = plans;
		this.maritalStatus = maritalStatus;
		this.payment = payment;
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", caste=" + caste + ", religion=" + religion
				+ ", education=" + education + ", language=" + language + ", location=" + location + ", gender="
				+ gender + ", height=" + height + ", weight=" + weight + ", profession=" + profession + ", country="
				+ country + ", plans=" + plans + ", maritalStatus=" + maritalStatus + ", payment=" + payment + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPlans() {
		return plans;
	}


	public void setPlans(String plans) {
		this.plans = plans;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	


	

	

	
	
}