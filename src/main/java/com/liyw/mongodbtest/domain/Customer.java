package com.liyw.mongodbtest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author liyw
 * @version V1.0
 * @date 2019/4/3 11:15
 */
@Data
public class Customer implements Serializable {
    @Id
    public String id;//使用@id注解设置主键，这个主键是MongoDB自动生成的，具有唯一性
    public String firstName;
    public String lastName;
    public Long birthday;

    public Customer(String firstName, String lastName,Long birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;

    }
}
