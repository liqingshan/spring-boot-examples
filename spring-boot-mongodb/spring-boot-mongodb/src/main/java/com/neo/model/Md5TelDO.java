package com.neo.model;

import lombok.Getter;
import lombok.Setter;

import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liqingshan
 * Date: 2019-09-17
 * Time: 18:34
 */
@Getter
@Setter
@Accessors(chain = true)
@Document
public class Md5TelDO implements Serializable {

    @Indexed(unique=true)
    private String Md5;

    private String Telephone;
}
