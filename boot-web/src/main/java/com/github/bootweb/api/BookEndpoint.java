package com.github.bootweb.api;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.bootapi.api.AccountManager;
import com.github.bootapi.api.BookManager;
import com.github.bootapi.common.PageSize;
import com.github.bootapi.common.ResultDTO;
import com.github.bootapi.dto.AccountDto;
import com.github.bootapi.dto.BookDto;
import com.github.bootapi.exception.ErrorCode;
import com.github.bootapi.exception.ServiceException;
import com.github.bootcommon.constants.MediaTypes;
import com.github.bootcommon.core.mapper.BeanMapper;


// Spring Restful MVC Controller的标识, 直接输出内容，不调用template引擎.
@RestController
public class BookEndpoint {

	private static Logger logger = LoggerFactory.getLogger(BookEndpoint.class);

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private BookManager bookManager;

	@RequestMapping(value = "/api/books", produces = MediaTypes.JSON_UTF_8)
	public List<BookDto> listAllBook(PageSize pageSize) {
		ResultDTO<List<BookDto>> books= bookManager.listAllBook(pageSize);
		return books.getData();
	}

	@RequestMapping(value = "/api/books/{id}", produces = MediaTypes.JSON_UTF_8)
	public BookDto listOneBook(@PathVariable("id") Long id) {
		ResultDTO<BookDto> book = bookManager.listOneBook(id);
		return book.getData();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST, consumes = MediaTypes.JSON_UTF_8)
	public void createBook(@RequestBody BookDto bookDto,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		// 使用Header中的Token，查找登录用户
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		// 保存Book对象
		bookManager.saveBook(bookDto, currentUser.getData());
	}

	@RequestMapping(value = "/api/books/{id}/modify", method = RequestMethod.POST, consumes = MediaTypes.JSON_UTF_8)
	public void modifyBook(@RequestBody BookDto bookDto,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.modifyBook(bookDto, currentUser.getData().id);
	}

	@RequestMapping(value = "/api/books/{id}/delete")
	public void deleteBook(@PathVariable("id") Long id, @RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.deleteBook(id, currentUser.getData().id);
	}

	@RequestMapping(value = "/api/books/{id}/request")
	public void applyBorrowRequest(@PathVariable("id") Long id,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.applyBorrowRequest(id, currentUser.getData());
	}

	@RequestMapping(value = "/api/books/{id}/cancel")
	public void cancelBorrowRequest(@PathVariable("id") Long id,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.cancelBorrowRequest(id, currentUser.getData());
	}

	@RequestMapping(value = "/api/books/{id}/confirm")
	public void markBookBorrowed(@PathVariable("id") Long id,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.markBookBorrowed(id, currentUser.getData());
	}

	@RequestMapping(value = "/api/books/{id}/reject")
	public void rejectBorrowRequest(@PathVariable("id") Long id,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.rejectBorrowRequest(id, currentUser.getData());
	}

	@RequestMapping(value = "/api/books/{id}/return")
	public void markBookReturned(@PathVariable("id") Long id,
			@RequestParam(value = "token", required = false) String token) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		bookManager.markBookReturned(id, currentUser.getData());
	}

	@RequestMapping(value = "/api/mybook", produces = MediaTypes.JSON_UTF_8)
	public List<BookDto> listMyBook(@RequestParam(value = "token", required = false) String token, PageSize pageSize) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		ResultDTO<List<BookDto>> books = bookManager.listMyBook(currentUser.getData().id, pageSize);
		return books.getData();
	}

	@RequestMapping(value = "/api/myborrowedbook", produces = MediaTypes.JSON_UTF_8)
	public List<BookDto> listMyBorrowedBook(@RequestParam(value = "token", required = false) String token,
			PageSize pageSize) {
		checkToken(token);
		ResultDTO<AccountDto> currentUser = accountManager.getLoginUser(token);
		ResultDTO<List<BookDto>> books = bookManager.listMyBorrowedBook(currentUser.getData().id, pageSize);
		return books.getData();
	}

	private void checkToken(String token) {
		if (token == null) {
			throw new ServiceException("No token in request", ErrorCode.NO_TOKEN);
		}
	}
}
