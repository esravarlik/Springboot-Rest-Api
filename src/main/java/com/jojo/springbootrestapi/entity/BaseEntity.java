package com.jojo.springbootrestapi.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@ToString
public class BaseEntity implements Serializable {

    private Date createdDate;

    private String createdBy;

    private Date updateAt;

    private String updatedBy;

}
