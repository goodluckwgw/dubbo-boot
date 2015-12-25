package com.github.bootapi.api;

import java.util.List;

import com.github.bootapi.common.PageSize;
import com.github.bootapi.common.ResultDTO;
import com.github.bootapi.dto.AccountDto;
import com.github.bootapi.dto.BookDto;
import com.github.bootapi.exception.ServiceException;


public interface BookManager {

	ResultDTO<List<BookDto>> listAllBook(PageSize pageSize);

	ResultDTO<BookDto> listOneBook(Long id);

	ResultDTO<Void> saveBook(BookDto bookDto, AccountDto accountDto);

	ResultDTO<Void> modifyBook(BookDto bookDto, Long id)throws ServiceException;

	ResultDTO<Void> deleteBook(Long id, Long currentAccountId)throws ServiceException;

	ResultDTO<Void> applyBorrowRequest(Long id, AccountDto accountDto)throws ServiceException;

	ResultDTO<Void> cancelBorrowRequest(Long id, AccountDto accountDto)throws ServiceException;

	ResultDTO<Void> markBookBorrowed(Long id, AccountDto accountDto)throws ServiceException;

	ResultDTO<Void> rejectBorrowRequest(Long id, AccountDto accountDto)throws ServiceException;

	ResultDTO<Void> markBookReturned(Long id, AccountDto accountDto)throws ServiceException;

	ResultDTO<List<BookDto>> listMyBook(Long id, PageSize pageSize);

	ResultDTO<List<BookDto>> listMyBorrowedBook(Long id, PageSize pageSize);

}
