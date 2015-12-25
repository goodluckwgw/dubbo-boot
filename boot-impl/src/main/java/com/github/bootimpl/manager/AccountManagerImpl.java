package com.github.bootimpl.manager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.bootapi.api.AccountManager;
import com.github.bootapi.common.ResultDTO;
import com.github.bootapi.dto.AccountDto;
import com.github.bootapi.exception.ErrorCode;
import com.github.bootapi.exception.ServiceException;
import com.github.bootcommon.core.mapper.BeanMapper;
import com.github.bootimpl.domain.Account;
import com.github.bootimpl.service.AccountService;
/**
 * <p>Title: AccountManagerImpl</p>
  * <p>Description: dubbo服务</p>
  * @author wgw
 */
@Service
public class AccountManagerImpl implements AccountManager {
	
	private static Logger logger = LoggerFactory.getLogger(AccountManagerImpl.class);
	
	@Autowired
	private AccountService accountServcie;

	@Override
	public ResultDTO<String> login(String email, String password) {
		ResultDTO<String> result = new ResultDTO<String>();
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new ServiceException("User or password empty", ErrorCode.BAD_REQUEST);
		}

		String token = accountServcie.login(email, password);
		result.setSuccess(true);
		result.setData(token);
		return result;
	}

	@Override
	public ResultDTO<Void> logout(String token) {
		ResultDTO<Void> result = new ResultDTO<Void>();
		accountServcie.logout(token);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<Void> register(String email, String name, String password) {
		ResultDTO<Void> result = new ResultDTO<Void>();
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			throw new ServiceException("User or name or password empty", ErrorCode.BAD_REQUEST);
		}

		accountServcie.register(email, name, password);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<AccountDto> getLoginUser(String token) {
		ResultDTO<AccountDto> result = new ResultDTO<AccountDto>();
		Account account = accountServcie.getLoginUser(token);
		result.setSuccess(true);
		result.setData(BeanMapper.map(account, AccountDto.class));
		return result;
	}

}
