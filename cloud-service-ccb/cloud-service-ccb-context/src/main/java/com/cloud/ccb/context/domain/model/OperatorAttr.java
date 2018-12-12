package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * @author: zhangchao
 * @time: 2018-11-14 10:18
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorAttr extends ValueObject {
    private static final long serialVersionUID = 6779252666316833666L;
    private String name;
    private String value;
    private Integer sort;


    public void init(String name,  String value, Integer sort) {
        this.name = name;
        this.value = value;
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorAttr that = (OperatorAttr) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
