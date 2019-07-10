package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.UserLog;
import java.util.List;	

/**
 * 用户员工日志 数据层
 * 
 * @author ruoyi
 * @date 2019-07-09
 */
public interface UserLogMapper 
{
	/**
     * 查询用户员工日志信息
     * 
     * @param logId 用户员工日志ID
     * @return 用户员工日志信息
     */
	public UserLog selectUserLogById(Long logId);
	
	/**
     * 查询用户员工日志列表
     * 
     * @param userLog 用户员工日志信息
     * @return 用户员工日志集合
     */
	public List<UserLog> selectUserLogList(UserLog userLog);
	
	/**
     * 新增用户员工日志
     * 
     * @param userLog 用户员工日志信息
     * @return 结果
     */
	public int insertUserLog(UserLog userLog);
	
	/**
     * 修改用户员工日志
     * 
     * @param userLog 用户员工日志信息
     * @return 结果
     */
	public int updateUserLog(UserLog userLog);
	
	/**
     * 删除用户员工日志
     * 
     * @param logId 用户员工日志ID
     * @return 结果
     */
	public int deleteUserLogById(Long logId);
	
	/**
     * 批量删除用户员工日志
     * 
     * @param logIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserLogByIds(String[] logIds);
	
}