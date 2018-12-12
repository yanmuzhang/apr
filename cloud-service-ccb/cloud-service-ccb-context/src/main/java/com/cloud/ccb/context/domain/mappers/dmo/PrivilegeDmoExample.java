package com.cloud.ccb.context.domain.mappers.dmo;

import java.util.ArrayList;
import java.util.List;

public class PrivilegeDmoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrivilegeDmoExample() {
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

        public Criteria andMasterTypeIsNull() {
            addCriterion("master_type is null");
            return (Criteria) this;
        }

        public Criteria andMasterTypeIsNotNull() {
            addCriterion("master_type is not null");
            return (Criteria) this;
        }

        public Criteria andMasterTypeEqualTo(String value) {
            addCriterion("master_type =", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotEqualTo(String value) {
            addCriterion("master_type <>", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeGreaterThan(String value) {
            addCriterion("master_type >", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("master_type >=", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeLessThan(String value) {
            addCriterion("master_type <", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeLessThanOrEqualTo(String value) {
            addCriterion("master_type <=", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeLike(String value) {
            addCriterion("master_type like", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotLike(String value) {
            addCriterion("master_type not like", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeIn(List<String> values) {
            addCriterion("master_type in", values, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotIn(List<String> values) {
            addCriterion("master_type not in", values, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeBetween(String value1, String value2) {
            addCriterion("master_type between", value1, value2, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotBetween(String value1, String value2) {
            addCriterion("master_type not between", value1, value2, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(String value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(String value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(String value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(String value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(String value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLike(String value) {
            addCriterion("master_id like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotLike(String value) {
            addCriterion("master_id not like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<String> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<String> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(String value1, String value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(String value1, String value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNull() {
            addCriterion("access_type is null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNotNull() {
            addCriterion("access_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeEqualTo(String value) {
            addCriterion("access_type =", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotEqualTo(String value) {
            addCriterion("access_type <>", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThan(String value) {
            addCriterion("access_type >", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("access_type >=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThan(String value) {
            addCriterion("access_type <", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThanOrEqualTo(String value) {
            addCriterion("access_type <=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLike(String value) {
            addCriterion("access_type like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotLike(String value) {
            addCriterion("access_type not like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIn(List<String> values) {
            addCriterion("access_type in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotIn(List<String> values) {
            addCriterion("access_type not in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeBetween(String value1, String value2) {
            addCriterion("access_type between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotBetween(String value1, String value2) {
            addCriterion("access_type not between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessIdIsNull() {
            addCriterion("access_id is null");
            return (Criteria) this;
        }

        public Criteria andAccessIdIsNotNull() {
            addCriterion("access_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccessIdEqualTo(String value) {
            addCriterion("access_id =", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdNotEqualTo(String value) {
            addCriterion("access_id <>", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdGreaterThan(String value) {
            addCriterion("access_id >", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdGreaterThanOrEqualTo(String value) {
            addCriterion("access_id >=", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdLessThan(String value) {
            addCriterion("access_id <", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdLessThanOrEqualTo(String value) {
            addCriterion("access_id <=", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdLike(String value) {
            addCriterion("access_id like", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdNotLike(String value) {
            addCriterion("access_id not like", value, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdIn(List<String> values) {
            addCriterion("access_id in", values, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdNotIn(List<String> values) {
            addCriterion("access_id not in", values, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdBetween(String value1, String value2) {
            addCriterion("access_id between", value1, value2, "accessId");
            return (Criteria) this;
        }

        public Criteria andAccessIdNotBetween(String value1, String value2) {
            addCriterion("access_id not between", value1, value2, "accessId");
            return (Criteria) this;
        }

        public Criteria andIsOperatationIsNull() {
            addCriterion("is_operatation is null");
            return (Criteria) this;
        }

        public Criteria andIsOperatationIsNotNull() {
            addCriterion("is_operatation is not null");
            return (Criteria) this;
        }

        public Criteria andIsOperatationEqualTo(Boolean value) {
            addCriterion("is_operatation =", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationNotEqualTo(Boolean value) {
            addCriterion("is_operatation <>", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationGreaterThan(Boolean value) {
            addCriterion("is_operatation >", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_operatation >=", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationLessThan(Boolean value) {
            addCriterion("is_operatation <", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationLessThanOrEqualTo(Boolean value) {
            addCriterion("is_operatation <=", value, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationIn(List<Boolean> values) {
            addCriterion("is_operatation in", values, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationNotIn(List<Boolean> values) {
            addCriterion("is_operatation not in", values, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationBetween(Boolean value1, Boolean value2) {
            addCriterion("is_operatation between", value1, value2, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andIsOperatationNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_operatation not between", value1, value2, "isOperatation");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
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