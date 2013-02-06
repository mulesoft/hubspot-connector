/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contact;

import java.util.Map;


public class ContactProperties {
	
	private String firstname;
	private String lastname;
	private String salutation;
	private String email;
	private String phone;
	private String fax;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String jobtitle;
	private String message;
	private Long closedate;
	private ContactPropertiesLifecycleStage lifecyclestage;
	private String company;
	private String website;
	private ContactPropertiesNumberOfEmployees numemployees;
	private Long annualrevenue;
	private String industry;
	private String twitterhandle;
	private String twitterprofilephoto;
	/**
	 * If the property is not included in the attributes in this class, it will be added as a customProperties key, value pair.
	 * <p>
	 * Also for the create/update, you can add properties in here that are custom and will be sended to the service
	 */
	private Map<String, String> customProperties;
	
	public ContactProperties() {}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ContactPropertiesLifecycleStage getLifecyclestage() {
		return lifecyclestage;
	}

	public void setLifecyclestage(ContactPropertiesLifecycleStage lifecyclestage) {
		this.lifecyclestage = lifecyclestage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public ContactPropertiesNumberOfEmployees getNumemployees() {
		return numemployees;
	}

	public void setNumemployees(ContactPropertiesNumberOfEmployees numemployees) {
		this.numemployees = numemployees;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getTwitterhandle() {
		return twitterhandle;
	}

	public void setTwitterhandle(String twitterhandle) {
		this.twitterhandle = twitterhandle;
	}

	public String getTwitterprofilephoto() {
		return twitterprofilephoto;
	}

	public void setTwitterprofilephoto(String twitterprofilephoto) {
		this.twitterprofilephoto = twitterprofilephoto;
	}

	public Long getClosedate() {
		return closedate;
	}

	public void setClosedate(Long closedate) {
		this.closedate = closedate;
	}

	public Long getAnnualrevenue() {
		return annualrevenue;
	}

	public void setAnnualrevenue(Long annualrevenue) {
		this.annualrevenue = annualrevenue;
	}

	public Map<String, String> getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(Map<String, String> customProperties) {
		this.customProperties = customProperties;
	}	
}
