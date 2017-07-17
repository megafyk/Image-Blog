package com.megafyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Override and handle common errors
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
        switch (httpErrorCode){
            case 400:
                errorMsg = "Server could not understand your request";
                break;
            case 401:
                errorMsg = "Access is denied due to invalid credentials";
                break;
            case 404:
                errorMsg = "We couldn't find the page you were looking for";
                break;
            case 500:
                errorMsg = "Server has an error";
                break;
        }
        errorPage.addObject("errorCode", httpErrorCode);
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}
