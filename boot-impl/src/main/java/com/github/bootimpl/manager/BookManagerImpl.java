package com.github.bootimpl.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.bootapi.api.BookManager;
import com.github.bootapi.common.PageSize;
import com.github.bootapi.common.ResultDTO;
import com.github.bootapi.dto.AccountDto;
import com.github.bootapi.dto.BookDto;
import com.github.bootapi.exception.ServiceException;
import com.github.bootcommon.core.mapper.BeanMapper;
import com.github.bootimpl.domain.Account;
import com.github.bootimpl.domain.Book;
import com.github.bootimpl.service.BookAdminService;
import com.github.bootimpl.service.BookBorrowService;

/**
 * <p>Title: AccountManagerImpl</p>
  * <p>Description: dubbo服务</p>
  * @author wgw
 */
@Service
public class BookManagerImpl implements BookManager {
	
	private static Logger logger = LoggerFactory.getLogger(BookManagerImpl.class);

	@Autowired
	private BookAdminService adminService;

	@Autowired
	private BookBorrowService borrowService;

	@Override
	public ResultDTO<List<BookDto>> listAllBook(PageSize pageSize) {
		final ResultDTO<List<BookDto>> result = new ResultDTO<List<BookDto>>();
		Iterable<Book> books = adminService.findAll(new PageRequest(pageSize.getPageNo() - 1, pageSize.getPageSize(),
                null));
		List<BookDto> dtos = BeanMapper.mapList(books, BookDto.class);
		result.setSuccess(true);
		result.setData(dtos);
		return result;
	}

	@Override
	public ResultDTO<BookDto> listOneBook(Long id) {
		final ResultDTO<BookDto> result = new ResultDTO<BookDto>();
		Book book = adminService.findOne(id);
		result.setSuccess(true);
		result.setData(BeanMapper.map(book, BookDto.class));
		return result;
	}

	@Override
	public ResultDTO<Void> saveBook(BookDto bookDto, AccountDto accountDto) {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		// 使用BeanMapper, 将与外部交互的BookDto对象复制为应用内部的Book对象
		Book book = BeanMapper.map(bookDto, Book.class);
		Account account = BeanMapper.map(accountDto, Account.class);
		adminService.saveBook(book, account);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<Void> modifyBook(BookDto bookDto, Long id) throws ServiceException{
		final ResultDTO<Void> result = new ResultDTO<Void>();
		try{
			Book book = BeanMapper.map(bookDto, Book.class);
			adminService.modifyBook(book, id);
			result.setSuccess(true);
		}catch(ServiceException e){
			result.setSuccess(false);
		}
	
		return result;
	}

	@Override
	public ResultDTO<Void> deleteBook(Long id, Long currentAccountId)throws ServiceException {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		try{
			adminService.deleteBook(id, currentAccountId);
			result.setSuccess(true);
		}catch(ServiceException e){
			result.setSuccess(false);
		}
		
		return result;
	}

	@Override
	public ResultDTO<Void> applyBorrowRequest(Long id, AccountDto accountDto) throws ServiceException{
		final ResultDTO<Void> result = new ResultDTO<Void>();
		try{
			Account account = BeanMapper.map(accountDto, Account.class);
			borrowService.applyBorrowRequest(id, account);
			result.setSuccess(true);
		}catch(ServiceException e){
			result.setSuccess(false);
		}
		
		return result;
		
	}

	@Override
	public ResultDTO<Void> cancelBorrowRequest(Long id, AccountDto accountDto) throws ServiceException{
		final ResultDTO<Void> result = new ResultDTO<Void>();
		try{
			Account account = BeanMapper.map(accountDto, Account.class);
			borrowService.cancelBorrowRequest(id, account);
			result.setSuccess(true);
		}catch(ServiceException e){
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDTO<Void> markBookBorrowed(Long id, AccountDto accountDto) {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		Account account = BeanMapper.map(accountDto, Account.class);
		borrowService.markBookBorrowed(id, account);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<Void> rejectBorrowRequest(Long id, AccountDto accountDto) {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		Account account = BeanMapper.map(accountDto, Account.class);
		borrowService.rejectBorrowRequest(id, account);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<Void> markBookReturned(Long id, AccountDto accountDto) {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		Account account = BeanMapper.map(accountDto, Account.class);
		borrowService.markBookReturned(id, account);
		result.setSuccess(true);
		return result;
	}

	@Override
	public ResultDTO<List<BookDto>> listMyBook(Long id, PageSize pageSize) {
		final ResultDTO<List<BookDto>> result = new ResultDTO<List<BookDto>>();
		List<Book> books = adminService.listMyBook(id, new PageRequest(pageSize.getPageNo() - 1, pageSize.getPageSize(),
                null));
		result.setSuccess(true);
		result.setData(BeanMapper.mapList(books, BookDto.class));
		return result;
	}

	@Override
	public ResultDTO<List<BookDto>> listMyBorrowedBook(Long id,
			PageSize pageSize) {
		final ResultDTO<List<BookDto>> result = new ResultDTO<List<BookDto>>();
		List<Book> books = borrowService.listMyBorrowedBook(id, new PageRequest(pageSize.getPageNo() - 1, pageSize.getPageSize(),
                null));
		result.setSuccess(true);
		result.setData(BeanMapper.mapList(books, BookDto.class));
		return result;
	}

}
