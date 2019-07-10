package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserLogMapper;
import com.ruoyi.system.domain.UserLog;
import com.ruoyi.system.service.IUserLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户员工日志 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-09
 */
@Service
public class UserLogServiceImpl implements IUserLogService 
{
	@Autowired
	private UserLogMapper userLogMapper;

	/**
     * 查询用户员工日志信息
     * 
     * @param logId 用户员工日志ID
     * @return 用户员工日志信息
     */
    @Override
	public UserLog selectUserLogById(Long logId)
	{
	    return userLogMapper.selectUserLogById(logId);
	}
	
	/**
     * 查询用户员工日志列表
     * 
     * @param userLog 用户员工日志信息
     * @return 用户员工日志集合
     */
	@Override
	public List<UserLog> selectUserLogList(UserLog userLog)
	{
	    return userLogMapper.selectUserLogList(userLog);
	}
	
    /**
     * 新增用户员工日志
     * 
     * @param userLog 用户员工日志信息
     * @return 结果
     */
	@Override
	public int insertUserLog(UserLog userLog)
	{
	    return userLogMapper.insertUserLog(userLog);
	}
	
	/**
     * 修改用户员工日志
     * 
     * @param userLog 用户员工日志信息
     * @return 结果
     */
	@Override
	public int updateUserLog(UserLog userLog)
	{
	    return userLogMapper.updateUserLog(userLog);
	}

	/**
     * 删除用户员工日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserLogByIds(String ids)
	{
		return userLogMapper.deleteUserLogByIds(Convert.toStrArray(ids));
	}
	
}
