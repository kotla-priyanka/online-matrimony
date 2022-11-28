package com.matrimony.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groom")
public class Groom {
	
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		
		private String firstName;
		private String lastName;
		private String password;
		private String emailId;
		private long phoneNo;
		private String caste;
		private String religion;
		private String education;
		private String language;
		private String location;
		private String gender;
	    private float height;
		private float weight;
		private String profession;
		private String country;
		private String plans;
		private String maritalStatus;
		public Groom(long id, String firstName, String lastName, String password, String emailId, long phoneNo,
				String caste, String religion, String education, String language, String location, String gender,
				float height, float weight, String profession, String country, String plans, String maritalStatus) {
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
		
		
		
		
	
		
		
		

}
