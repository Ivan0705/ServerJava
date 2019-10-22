package ru.academits.servlet;

import ru.academits.PhoneBook;

import ru.academits.service.ContactService;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteContactServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String stringId = req.getParameter("id");
        if (stringId != null) {
            phoneBookService.deleteContact(Integer.parseInt(stringId));
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }

    }
}
