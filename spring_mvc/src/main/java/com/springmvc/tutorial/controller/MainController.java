package com.springmvc.tutorial.controller;

import com.springmvc.tutorial.model.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @Controller
@RestController // ModelAndView를 활용하지 않는 형태, Data를 반환
public class MainController {

    // localhost:8090
    @RequestMapping("/")
    public String init() {
        return "index"; // index.jsp
    }

    // 2. ModelAndView.class, Servlet/JSP 활용 방식
    // @RequestMapping("/add")
    // public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
    //     String name = request.getParameter("name");

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");
    //     modelAndView.addObject("name", name);
    //     modelAndView.addObject("author", request.getParameter("author"));

    //     return modelAndView;
    // }

    // 3. RequestParam 방식,(HttpServletRequest보다 간소화된 형태)
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("name") String name, @RequestParam String author) {
        
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");

    //     modelAndView.addObject("name", name);
    //     modelAndView.addObject("author", author);

    //     return modelAndView;
    // }

    // 4. JSON 객체 반환 방식, @Controller -> @RestController로 변경.
    // @RestController = @Controller + @ResponseBody
    @RequestMapping(value="/get", method=RequestMethod.GET)
    public Book getBook(@RequestParam("name") String name,
                        @RequestParam("author") String author) {

        Book book = new Book();
        book.setName(name);             
        book.setAuthor(author);

        return book;
    }
    
}
