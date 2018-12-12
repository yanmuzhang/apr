package com.cloud.ccb.context.domain.mappers.dmo;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDmoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationDmoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNull() {
            addCriterion("organization_type is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNotNull() {
            addCriterion("organization_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeEqualTo(String value) {
            addCriterion("organization_type =", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotEqualTo(String value) {
            addCriterion("organization_type <>", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThan(String value) {
            addCriterion("organization_type >", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_type >=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThan(String value) {
            addCriterion("organization_type <", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThanOrEqualTo(String value) {
            addCriterion("organization_type <=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLike(String value) {
            addCriterion("organization_type like", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotLike(String value) {
            addCriterion("organization_type not like", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIn(List<String> values) {
            addCriterion("organization_type in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotIn(List<String> values) {
            addCriterion("organization_type not in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeBetween(String value1, String value2) {
            addCriterion("organization_type between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotBetween(String value1, String value2) {
            addCriterion("organization_type not between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNull() {
            addCriterion("register_number is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIsNotNull() {
            addCriterion("register_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberEqualTo(String value) {
            addCriterion("register_number =", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotEqualTo(String value) {
            addCriterion("register_number <>", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThan(String value) {
            addCriterion("register_number >", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("register_number >=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThan(String value) {
            addCriterion("register_number <", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLessThanOrEqualTo(String value) {
            addCriterion("register_number <=", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberLike(String value) {
            addCriterion("register_number like", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotLike(String value) {
            addCriterion("register_number not like", value, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberIn(List<String> values) {
            addCriterion("register_number in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotIn(List<String> values) {
            addCriterion("register_number not in", values, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberBetween(String value1, String value2) {
            addCriterion("register_number between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterNumberNotBetween(String value1, String value2) {
            addCriterion("register_number not between", value1, value2, "registerNumber");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("organization_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("organization_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("organization_code =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("organization_code <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("organization_code >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_code >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("organization_code <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("organization_code <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("organization_code like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("organization_code not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("organization_code in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("organization_code not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("organization_code between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("organization_code not between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIsNull() {
            addCriterion("license_type is null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIsNotNull() {
            addCriterion("license_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeEqualTo(String value) {
            addCriterion("license_type =", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotEqualTo(String value) {
            addCriterion("license_type <>", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThan(String value) {
            addCriterion("license_type >", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("license_type >=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThan(String value) {
            addCriterion("license_type <", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLessThanOrEqualTo(String value) {
            addCriterion("license_type <=", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeLike(String value) {
            addCriterion("license_type like", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotLike(String value) {
            addCriterion("license_type not like", value, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeIn(List<String> values) {
            addCriterion("license_type in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotIn(List<String> values) {
            addCriterion("license_type not in", values, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeBetween(String value1, String value2) {
            addCriterion("license_type between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeNotBetween(String value1, String value2) {
            addCriterion("license_type not between", value1, value2, "licenseType");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIsNull() {
            addCriterion("legal_person_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIsNotNull() {
            addCriterion("legal_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameEqualTo(String value) {
            addCriterion("legal_person_name =", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotEqualTo(String value) {
            addCriterion("legal_person_name <>", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameGreaterThan(String value) {
            addCriterion("legal_person_name >", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_name >=", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLessThan(String value) {
            addCriterion("legal_person_name <", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLessThanOrEqualTo(String value) {
            addCriterion("legal_person_name <=", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameLike(String value) {
            addCriterion("legal_person_name like", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotLike(String value) {
            addCriterion("legal_person_name not like", value, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameIn(List<String> values) {
            addCriterion("legal_person_name in", values, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotIn(List<String> values) {
            addCriterion("legal_person_name not in", values, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameBetween(String value1, String value2) {
            addCriterion("legal_person_name between", value1, value2, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNameNotBetween(String value1, String value2) {
            addCriterion("legal_person_name not between", value1, value2, "legalPersonName");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberIsNull() {
            addCriterion("legal_person_id_number is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberIsNotNull() {
            addCriterion("legal_person_id_number is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberEqualTo(String value) {
            addCriterion("legal_person_id_number =", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberNotEqualTo(String value) {
            addCriterion("legal_person_id_number <>", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberGreaterThan(String value) {
            addCriterion("legal_person_id_number >", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_id_number >=", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberLessThan(String value) {
            addCriterion("legal_person_id_number <", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberLessThanOrEqualTo(String value) {
            addCriterion("legal_person_id_number <=", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberLike(String value) {
            addCriterion("legal_person_id_number like", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberNotLike(String value) {
            addCriterion("legal_person_id_number not like", value, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberIn(List<String> values) {
            addCriterion("legal_person_id_number in", values, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberNotIn(List<String> values) {
            addCriterion("legal_person_id_number not in", values, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberBetween(String value1, String value2) {
            addCriterion("legal_person_id_number between", value1, value2, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdNumberNotBetween(String value1, String value2) {
            addCriterion("legal_person_id_number not between", value1, value2, "legalPersonIdNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontIsNull() {
            addCriterion("legal_person_id_front is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontIsNotNull() {
            addCriterion("legal_person_id_front is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontEqualTo(String value) {
            addCriterion("legal_person_id_front =", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontNotEqualTo(String value) {
            addCriterion("legal_person_id_front <>", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontGreaterThan(String value) {
            addCriterion("legal_person_id_front >", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_id_front >=", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontLessThan(String value) {
            addCriterion("legal_person_id_front <", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontLessThanOrEqualTo(String value) {
            addCriterion("legal_person_id_front <=", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontLike(String value) {
            addCriterion("legal_person_id_front like", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontNotLike(String value) {
            addCriterion("legal_person_id_front not like", value, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontIn(List<String> values) {
            addCriterion("legal_person_id_front in", values, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontNotIn(List<String> values) {
            addCriterion("legal_person_id_front not in", values, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontBetween(String value1, String value2) {
            addCriterion("legal_person_id_front between", value1, value2, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdFrontNotBetween(String value1, String value2) {
            addCriterion("legal_person_id_front not between", value1, value2, "legalPersonIdFront");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackIsNull() {
            addCriterion("legal_person_id_back is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackIsNotNull() {
            addCriterion("legal_person_id_back is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackEqualTo(String value) {
            addCriterion("legal_person_id_back =", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackNotEqualTo(String value) {
            addCriterion("legal_person_id_back <>", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackGreaterThan(String value) {
            addCriterion("legal_person_id_back >", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_id_back >=", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackLessThan(String value) {
            addCriterion("legal_person_id_back <", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackLessThanOrEqualTo(String value) {
            addCriterion("legal_person_id_back <=", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackLike(String value) {
            addCriterion("legal_person_id_back like", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackNotLike(String value) {
            addCriterion("legal_person_id_back not like", value, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackIn(List<String> values) {
            addCriterion("legal_person_id_back in", values, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackNotIn(List<String> values) {
            addCriterion("legal_person_id_back not in", values, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackBetween(String value1, String value2) {
            addCriterion("legal_person_id_back between", value1, value2, "legalPersonIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIdBackNotBetween(String value1, String value2) {
            addCriterion("legal_person_id_back not between", value1, value2, "legalPersonIdBack");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}