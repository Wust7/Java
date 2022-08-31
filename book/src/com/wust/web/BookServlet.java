package com.wust.web;

import com.wust.pojo.Book;
import com.wust.pojo.Page;
import com.wust.service.BookService;
import com.wust.service.impl.BookServiceImpl;
import com.wust.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        //调用bookService保存图书
        bookService.addBook(book);

        //跳回图书列表页面
        //请求转发是一次转发会存在bug，当按下f5时页面会再一次提交请求，继续调用该添加方法，故不行，需用重定向
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        //重定向 ---两次请求
        resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //获取请求的id参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService的delete方法
        bookService.deleteBookById(id);

        //重定向跳回列表管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");

    }

    /**
     * 保存修改操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求对象参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //调用BookService中的query方法
        bookService.updateBook(book);
        //重定向跳回列表管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过bookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //将全部图书保存带Request
        req.setAttribute("books",books);
        //请求转发到/pages/manager/book_manager.jsp中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用BookService中的query方法
        Book book = bookService.queryBookById(id);
        //保存数据到request域中
        req.setAttribute("book",book);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    /**
     * 处理Book的分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

//        page.setUrl("manager/bookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
