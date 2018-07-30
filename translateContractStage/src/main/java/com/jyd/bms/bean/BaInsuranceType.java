package com.jyd.bms.bean;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @category Generated 2018-03-19 14:56:32 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaInsuranceType implements Serializable {
private int id;
public int getId() {
 return id;
}
public void setId(int id) {
 this.id = id;
}
private String insuranceType;
// 保险类型
public String getInsuranceType(){
 return insuranceType;
}

public void setInsuranceType(String insuranceType){
 this.insuranceType=insuranceType;
}

private String remark;
// 备注
public String getRemark(){
 return remark;
}

public void setRemark(String remark){
 this.remark=remark;
}

private Timestamp createDate;
// 创建时间
public Timestamp getCreateDate(){
 return createDate;
}

public void setCreateDate(Timestamp createDate){
 this.createDate=createDate;
}

private String createUser;
// 创建用户
public String getCreateUser(){
 return createUser;
}

public void setCreateUser(String createUser){
 this.createUser=createUser;
}

private Timestamp updateDate;
// 修改时间
public Timestamp getUpdateDate(){
 return updateDate;
}

public void setUpdateDate(Timestamp updateDate){
 this.updateDate=updateDate;
}

private String updateUser;
// 修改用户
public String getUpdateUser(){
 return updateUser;
}

public void setUpdateUser(String updateUser){
 this.updateUser=updateUser;
}

}