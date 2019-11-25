package com.yangfan.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value="user对象",description="用户对象user")
public class User implements Serializable {
    @ApiModelProperty(value="用户ID",name="ID",example="1")
    private Integer id;
    @ApiModelProperty(value="用户名",name="username",example="xingguo")
    private String  name;

}