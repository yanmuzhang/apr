package com.cloud.ccb.context.domain.mappers.dmo;

import java.util.ArrayList;
import java.util.List;

public class ButtonDmoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ButtonDmoExample() {
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

        public Criteria andBtnNoIsNull() {
            addCriterion("btn_no is null");
            return (Criteria) this;
        }

        public Criteria andBtnNoIsNotNull() {
            addCriterion("btn_no is not null");
            return (Criteria) this;
        }

        public Criteria andBtnNoEqualTo(String value) {
            addCriterion("btn_no =", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoNotEqualTo(String value) {
            addCriterion("btn_no <>", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoGreaterThan(String value) {
            addCriterion("btn_no >", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoGreaterThanOrEqualTo(String value) {
            addCriterion("btn_no >=", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoLessThan(String value) {
            addCriterion("btn_no <", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoLessThanOrEqualTo(String value) {
            addCriterion("btn_no <=", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoLike(String value) {
            addCriterion("btn_no like", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoNotLike(String value) {
            addCriterion("btn_no not like", value, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoIn(List<String> values) {
            addCriterion("btn_no in", values, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoNotIn(List<String> values) {
            addCriterion("btn_no not in", values, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoBetween(String value1, String value2) {
            addCriterion("btn_no between", value1, value2, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNoNotBetween(String value1, String value2) {
            addCriterion("btn_no not between", value1, value2, "btnNo");
            return (Criteria) this;
        }

        public Criteria andBtnNameIsNull() {
            addCriterion("btn_name is null");
            return (Criteria) this;
        }

        public Criteria andBtnNameIsNotNull() {
            addCriterion("btn_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtnNameEqualTo(String value) {
            addCriterion("btn_name =", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotEqualTo(String value) {
            addCriterion("btn_name <>", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameGreaterThan(String value) {
            addCriterion("btn_name >", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameGreaterThanOrEqualTo(String value) {
            addCriterion("btn_name >=", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLessThan(String value) {
            addCriterion("btn_name <", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLessThanOrEqualTo(String value) {
            addCriterion("btn_name <=", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLike(String value) {
            addCriterion("btn_name like", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotLike(String value) {
            addCriterion("btn_name not like", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameIn(List<String> values) {
            addCriterion("btn_name in", values, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotIn(List<String> values) {
            addCriterion("btn_name not in", values, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameBetween(String value1, String value2) {
            addCriterion("btn_name between", value1, value2, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotBetween(String value1, String value2) {
            addCriterion("btn_name not between", value1, value2, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnTypeIsNull() {
            addCriterion("btn_type is null");
            return (Criteria) this;
        }

        public Criteria andBtnTypeIsNotNull() {
            addCriterion("btn_type is not null");
            return (Criteria) this;
        }

        public Criteria andBtnTypeEqualTo(String value) {
            addCriterion("btn_type =", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeNotEqualTo(String value) {
            addCriterion("btn_type <>", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeGreaterThan(String value) {
            addCriterion("btn_type >", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("btn_type >=", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeLessThan(String value) {
            addCriterion("btn_type <", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeLessThanOrEqualTo(String value) {
            addCriterion("btn_type <=", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeLike(String value) {
            addCriterion("btn_type like", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeNotLike(String value) {
            addCriterion("btn_type not like", value, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeIn(List<String> values) {
            addCriterion("btn_type in", values, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeNotIn(List<String> values) {
            addCriterion("btn_type not in", values, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeBetween(String value1, String value2) {
            addCriterion("btn_type between", value1, value2, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnTypeNotBetween(String value1, String value2) {
            addCriterion("btn_type not between", value1, value2, "btnType");
            return (Criteria) this;
        }

        public Criteria andBtnIconIsNull() {
            addCriterion("btn_icon is null");
            return (Criteria) this;
        }

        public Criteria andBtnIconIsNotNull() {
            addCriterion("btn_icon is not null");
            return (Criteria) this;
        }

        public Criteria andBtnIconEqualTo(String value) {
            addCriterion("btn_icon =", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconNotEqualTo(String value) {
            addCriterion("btn_icon <>", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconGreaterThan(String value) {
            addCriterion("btn_icon >", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconGreaterThanOrEqualTo(String value) {
            addCriterion("btn_icon >=", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconLessThan(String value) {
            addCriterion("btn_icon <", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconLessThanOrEqualTo(String value) {
            addCriterion("btn_icon <=", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconLike(String value) {
            addCriterion("btn_icon like", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconNotLike(String value) {
            addCriterion("btn_icon not like", value, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconIn(List<String> values) {
            addCriterion("btn_icon in", values, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconNotIn(List<String> values) {
            addCriterion("btn_icon not in", values, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconBetween(String value1, String value2) {
            addCriterion("btn_icon between", value1, value2, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andBtnIconNotBetween(String value1, String value2) {
            addCriterion("btn_icon not between", value1, value2, "btnIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andInitStatusIsNull() {
            addCriterion("init_status is null");
            return (Criteria) this;
        }

        public Criteria andInitStatusIsNotNull() {
            addCriterion("init_status is not null");
            return (Criteria) this;
        }

        public Criteria andInitStatusEqualTo(Boolean value) {
            addCriterion("init_status =", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusNotEqualTo(Boolean value) {
            addCriterion("init_status <>", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusGreaterThan(Boolean value) {
            addCriterion("init_status >", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("init_status >=", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusLessThan(Boolean value) {
            addCriterion("init_status <", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("init_status <=", value, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusIn(List<Boolean> values) {
            addCriterion("init_status in", values, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusNotIn(List<Boolean> values) {
            addCriterion("init_status not in", values, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("init_status between", value1, value2, "initStatus");
            return (Criteria) this;
        }

        public Criteria andInitStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("init_status not between", value1, value2, "initStatus");
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