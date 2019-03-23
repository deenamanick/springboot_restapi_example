package com.springbootdemo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 598721 on 10/5/2017.
 */

@Controller
public class SampleController {
	@RequestMapping(method = RequestMethod.POST,value="/messages")
	@ResponseBody
	  public Answer processMessage(@RequestBody Message message) throws Exception{
		  System.out.println("HERE");
          Answer a = new Answer();
          a.setValue(message.getId());
          a.setDescription(message.getDescription());
          return a;
		  
		}
	  @ExceptionHandler
	  @ResponseBody
	  public String  handleException(Exception e, HttpServletResponse response) throws IOException {
		  System.out.println(e.getMessage());
		return e.getMessage();
	        //response.sendError(HttpStatus.BAD_REQUEST.value());
		  
	    }
}
