package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * People
 * @author: zhangchao
 * @time: 2018-11-15 09:46
 **/
@Getter
@Setter
@NoArgsConstructor
public class CertificationInfo extends ValueObject {
    private static final long serialVersionUID = 1367371057585972378L;
    private String idCardNumber;
    private String name;
    private String cardFront;
    private String cardBack;

    public void init(String idCardNumber, String name, String cardFront, String cardBack) {
        this.idCardNumber = idCardNumber;
        this.name = name;
        this.cardFront = cardFront;
        this.cardBack = cardBack;
    }
}
