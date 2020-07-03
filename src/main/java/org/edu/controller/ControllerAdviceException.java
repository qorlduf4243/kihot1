package org.edu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerAdviceException {
   private static final Logger logger = LoggerFactory.getLogger(ControllerAdviceException.class); 
   @ExceptionHandler(Exception.class)
   public ModelAndView errorModelAndView(Exception ex) {
      ModelAndView modelAndView = new ModelAndView();
      //모델앤뷰에서 셋네임은 jsp파일명과 매칭
      modelAndView.setViewName("admin/error_controller");
      modelAndView.addObject("exception", ex);
      return modelAndView;
   }


}