package com.jeefl.sys.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lyz on 2017-8-26.
 */
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable{

    @Id
    private String id;

    private String name;

    private String password;

}
