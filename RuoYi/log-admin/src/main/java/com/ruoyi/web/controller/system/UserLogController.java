package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UserLog;
import com.ruoyi.system.service.IUserLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户员工日志 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-07-09
 */
@Controller
@RequestMapping("/system/userLog")
public class UserLogController extends BaseController
{
    private String prefix = "system/userLog";
	
	@Autowired
	private IUserLogService userLogService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ISysRoleService iSysRoleService;

	@RequiresPermissions("system:userLog:view")
	@GetMapping()
	public String userLog()
	{
	    return prefix + "/userLog";
	}
	
	/**
	 * 查询用户员工日志列表
	 */
	@RequiresPermissions("system:userLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserLog userLog)
	{
		 startPage();
		 List<UserLog> list = null;
		 SysUser user =	ShiroUtils.getSysUser();
		if(user.isAdmin()){
			list = userLogService.selectUserLogList(userLog);
		}

		List<SysUserRole> list1 = iSysRoleService.selectUserRoleId(user.getUserId());
			for (SysUserRole userRole : list1) {
			if(userRole.getRoleId()==1){
				userLog.setDeptId(user.getDeptId());
				list = userLogService.selectUserLogList(userLog);
			}else{
				userLog.setUserId(user.getUserId());
				list = userLogService.selectUserLogList(userLog);
			}
		}

		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户员工日志列表
	 */
	@RequiresPermissions("system:userLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserLog userLog)
    {
    	List<UserLog> list = userLogService.selectUserLogList(userLog);
        ExcelUtil<UserLog> util = new ExcelUtil<UserLog>(UserLog.class);
        return util.exportExcel(list, "userLog");
    }
	
	/**
	 * 新增用户员工日志
	 */
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
		String userName = sysUserService.selectUserById(ShiroUtils.getUserId()).getUserName();

		modelMap.put("userName",userName);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户员工日志
	 */
	@RequiresPermissions("system:userLog:add")
	@Log(title = "用户员工日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserLog userLog)
	{
		SysUser user =	ShiroUtils.getSysUser();
		userLog.setUserId(user.getUserId());
		userLog.setDeptId(user.getDeptId());
		userLog.setCreateTime(DateUtils.getNowDate());
		return toAjax(userLogService.insertUserLog(userLog));
	}

	/**
	 * 修改用户员工日志
	 */
	@GetMapping("/edit/{logId}")
	public String edit(@PathVariable("logId") Long logId, ModelMap mmap)
	{
		UserLog userLog = userLogService.selectUserLogById(logId);
		mmap.put("userLog", userLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户员工日志
	 */
	@RequiresPermissions("system:userLog:edit")
	@Log(title = "用户员工日志", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserLog userLog)
	{
		userLog.setUpdateTime(DateUtils.getNowDate());
		return toAjax(userLogService.updateUserLog(userLog));
	}
	
	/**
	 * 删除用户员工日志
	 */
	@RequiresPermissions("system:userLog:remove")
	@Log(title = "用户员工日志", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userLogService.deleteUserLogByIds(ids));
	}
	
}
