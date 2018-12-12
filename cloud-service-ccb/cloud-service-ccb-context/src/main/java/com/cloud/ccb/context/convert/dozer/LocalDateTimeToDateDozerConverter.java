package com.cloud.ccb.context.convert.dozer;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author: zhangchao
 * @time: 2018-11-14 17:14
 **/
public class LocalDateTimeToDateDozerConverter extends DozerConverter<LocalDateTime, Date> {

    public LocalDateTimeToDateDozerConverter() {
        super(LocalDateTime.class, Date.class);
    }

    @Override
    public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
        return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
    }

    @Override
    public Date convertTo(LocalDateTime source, Date destination) {
        return source == null ? null : Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }

}
