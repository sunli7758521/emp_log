package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户员工日志表 user_log
 * 
 * @author ruoyi
 * @date 2019-07-09
 */
public class UserLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long logId;
	/** 工作内容 */
	private String description;
	/** 用户id */
	private Long userId;
	/** 用户部门id */
	private Long deptId;
	/** 审核人 */
	private String verifyPeopleName;
	/** 0.完成 1.未完成 */
	private String status;
	/** 未完成原因 */
	private String unfinished;
	/** 编辑状态 0.可编辑 1不可编辑 */
	private String editStatus;
	/** 员工姓名*/
	private String userName;
	/** 审核人 */
	private String verifyPeople;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getVerifyPeopleName() {
		return verifyPeopleName;
	}

	public void setVerifyPeopleName(String verifyPeopleName) {
		this.verifyPeopleName = verifyPeopleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVerifyPeople() {
		return verifyPeople;
	}

	public void setVerifyPeople(String verifyPeople) {
		this.verifyPeople = verifyPeople;
	}

	public void setLogId(Long logId)
	{
		this.logId = logId;
	}

	public Long getLogId() 
	{
		return logId;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setUnfinished(String unfinished) 
	{
		this.unfinished = unfinished;
	}

	public String getUnfinished() 
	{
		return unfinished;
	}
	public void setEditStatus(String editStatus) 
	{
		this.editStatus = editStatus;
	}

	public String getEditStatus() 
	{
		return editStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("description", getDescription())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("verifyPeopleName", getVerifyPeopleName())
            .append("status", getStatus())
            .append("unfinished", getUnfinished())
            .append("editStatus", getEditStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
