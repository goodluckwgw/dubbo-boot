package com.github.bootapi.api;

import com.github.bootapi.common.ResultDTO;
import com.github.bootapi.dto.AccountDto;


public interface AccountManager {

	ResultDTO<String> login(String email, String password);

	ResultDTO<Void> logout(String token);

	ResultDTO<Void> register(String email, String name, String password);
	
	ResultDTO<AccountDto> getLoginUser(String token);
}
