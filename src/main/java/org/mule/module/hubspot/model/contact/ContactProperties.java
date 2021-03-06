/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contact;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
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

    public ContactProperties() {
    }

    @JsonProperty
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty
    public String getLastname() {
        return lastname;
    }

    @JsonProperty
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty
    public String getSalutation() {
        return salutation;
    }

    @JsonProperty
    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(final String email) {
        this.email = email;
    }

    @JsonProperty
    public String getPhone() {
        return phone;
    }

    @JsonProperty
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @JsonProperty
    public String getFax() {
        return fax;
    }

    @JsonProperty
    public void setFax(final String fax) {
        this.fax = fax;
    }

    @JsonProperty
    public String getAddress() {
        return address;
    }

    @JsonProperty
    public void setAddress(final String address) {
        this.address = address;
    }

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public void setCity(final String city) {
        this.city = city;
    }

    @JsonProperty
    public String getState() {
        return state;
    }

    @JsonProperty
    public void setState(final String state) {
        this.state = state;
    }

    @JsonProperty
    public String getZip() {
        return zip;
    }

    @JsonProperty
    public void setZip(final String zip) {
        this.zip = zip;
    }

    @JsonProperty
    public String getCountry() {
        return country;
    }

    @JsonProperty
    public void setCountry(final String country) {
        this.country = country;
    }

    @JsonProperty
    public String getJobtitle() {
        return jobtitle;
    }

    @JsonProperty
    public void setJobtitle(final String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(final String message) {
        this.message = message;
    }

    @JsonProperty
    public ContactPropertiesLifecycleStage getLifecyclestage() {
        return lifecyclestage;
    }

    @JsonProperty
    public void setLifecyclestage(final ContactPropertiesLifecycleStage lifecyclestage) {
        this.lifecyclestage = lifecyclestage;
    }

    @JsonProperty
    public String getCompany() {
        return company;
    }

    @JsonProperty
    public void setCompany(final String company) {
        this.company = company;
    }

    @JsonProperty
    public String getWebsite() {
        return website;
    }

    @JsonProperty
    public void setWebsite(final String website) {
        this.website = website;
    }

    @JsonProperty
    public ContactPropertiesNumberOfEmployees getNumemployees() {
        return numemployees;
    }

    @JsonProperty
    public void setNumemployees(final ContactPropertiesNumberOfEmployees numemployees) {
        this.numemployees = numemployees;
    }

    @JsonProperty
    public String getIndustry() {
        return industry;
    }

    @JsonProperty
    public void setIndustry(final String industry) {
        this.industry = industry;
    }

    @JsonProperty
    public String getTwitterhandle() {
        return twitterhandle;
    }

    @JsonProperty
    public void setTwitterhandle(final String twitterhandle) {
        this.twitterhandle = twitterhandle;
    }

    @JsonProperty
    public String getTwitterprofilephoto() {
        return twitterprofilephoto;
    }

    @JsonProperty
    public void setTwitterprofilephoto(final String twitterprofilephoto) {
        this.twitterprofilephoto = twitterprofilephoto;
    }

    @JsonProperty
    public Long getClosedate() {
        return closedate;
    }

    @JsonProperty
    public void setClosedate(final Long closedate) {
        this.closedate = closedate;
    }

    @JsonProperty
    public Long getAnnualrevenue() {
        return annualrevenue;
    }

    @JsonProperty
    public void setAnnualrevenue(final Long annualrevenue) {
        this.annualrevenue = annualrevenue;
    }

    @JsonProperty
    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    @JsonProperty
    public void setCustomProperties(final Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
}
