package com.cloud.ccb.context.domain.mappers.dmo;

import java.util.ArrayList;
import java.util.List;

public class CertificationInfoDmoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CertificationInfoDmoExample() {
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

        public Criteria andIdCardNumberIsNull() {
            addCriterion("id_card_number is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberIsNotNull() {
            addCriterion("id_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberEqualTo(String value) {
            addCriterion("id_card_number =", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotEqualTo(String value) {
            addCriterion("id_card_number <>", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberGreaterThan(String value) {
            addCriterion("id_card_number >", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_number >=", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberLessThan(String value) {
            addCriterion("id_card_number <", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberLessThanOrEqualTo(String value) {
            addCriterion("id_card_number <=", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberLike(String value) {
            addCriterion("id_card_number like", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotLike(String value) {
            addCriterion("id_card_number not like", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberIn(List<String> values) {
            addCriterion("id_card_number in", values, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotIn(List<String> values) {
            addCriterion("id_card_number not in", values, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberBetween(String value1, String value2) {
            addCriterion("id_card_number between", value1, value2, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotBetween(String value1, String value2) {
            addCriterion("id_card_number not between", value1, value2, "idCardNumber");
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

        public Criteria andCardFrontIsNull() {
            addCriterion("card_front is null");
            return (Criteria) this;
        }

        public Criteria andCardFrontIsNotNull() {
            addCriterion("card_front is not null");
            return (Criteria) this;
        }

        public Criteria andCardFrontEqualTo(String value) {
            addCriterion("card_front =", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontNotEqualTo(String value) {
            addCriterion("card_front <>", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontGreaterThan(String value) {
            addCriterion("card_front >", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("card_front >=", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontLessThan(String value) {
            addCriterion("card_front <", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontLessThanOrEqualTo(String value) {
            addCriterion("card_front <=", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontLike(String value) {
            addCriterion("card_front like", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontNotLike(String value) {
            addCriterion("card_front not like", value, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontIn(List<String> values) {
            addCriterion("card_front in", values, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontNotIn(List<String> values) {
            addCriterion("card_front not in", values, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontBetween(String value1, String value2) {
            addCriterion("card_front between", value1, value2, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardFrontNotBetween(String value1, String value2) {
            addCriterion("card_front not between", value1, value2, "cardFront");
            return (Criteria) this;
        }

        public Criteria andCardBackIsNull() {
            addCriterion("card_back is null");
            return (Criteria) this;
        }

        public Criteria andCardBackIsNotNull() {
            addCriterion("card_back is not null");
            return (Criteria) this;
        }

        public Criteria andCardBackEqualTo(String value) {
            addCriterion("card_back =", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackNotEqualTo(String value) {
            addCriterion("card_back <>", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackGreaterThan(String value) {
            addCriterion("card_back >", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackGreaterThanOrEqualTo(String value) {
            addCriterion("card_back >=", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackLessThan(String value) {
            addCriterion("card_back <", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackLessThanOrEqualTo(String value) {
            addCriterion("card_back <=", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackLike(String value) {
            addCriterion("card_back like", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackNotLike(String value) {
            addCriterion("card_back not like", value, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackIn(List<String> values) {
            addCriterion("card_back in", values, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackNotIn(List<String> values) {
            addCriterion("card_back not in", values, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackBetween(String value1, String value2) {
            addCriterion("card_back between", value1, value2, "cardBack");
            return (Criteria) this;
        }

        public Criteria andCardBackNotBetween(String value1, String value2) {
            addCriterion("card_back not between", value1, value2, "cardBack");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIsNull() {
            addCriterion("people_id is null");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIsNotNull() {
            addCriterion("people_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleIdEqualTo(String value) {
            addCriterion("people_id =", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotEqualTo(String value) {
            addCriterion("people_id <>", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdGreaterThan(String value) {
            addCriterion("people_id >", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdGreaterThanOrEqualTo(String value) {
            addCriterion("people_id >=", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdLessThan(String value) {
            addCriterion("people_id <", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdLessThanOrEqualTo(String value) {
            addCriterion("people_id <=", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdLike(String value) {
            addCriterion("people_id like", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotLike(String value) {
            addCriterion("people_id not like", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIn(List<String> values) {
            addCriterion("people_id in", values, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotIn(List<String> values) {
            addCriterion("people_id not in", values, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdBetween(String value1, String value2) {
            addCriterion("people_id between", value1, value2, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotBetween(String value1, String value2) {
            addCriterion("people_id not between", value1, value2, "peopleId");
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