package com.example.springboot;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.RSAKeyProvider;

@Component
public class SimpleFilter implements Filter {
   @Override
   public void destroy() {}

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {
      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse res = (HttpServletResponse) response;
      
      res.setHeader("Access-Control-Allow-Origin", "*");
      res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
      res.setHeader("Access-Control-Max-Age", "3600");
      res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type");

      if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
          res.setStatus(HttpServletResponse.SC_OK);
      } else {
    	  String authTokenHeader = req.getHeader("Authorization");
          String token = authTokenHeader.split(" ")[1];
          verifyToken(token);
    	  filterchain.doFilter(req, res);
      }
   }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {}
   
   public boolean verifyToken(String token) {
		String aws_cognito_region = "us-east-2"; // Replace this with your aws cognito region
		String aws_user_pools_id = "us-east-2_LAM7l2yjv"; // Replace this with your aws user pools id
		RSAKeyProvider keyProvider = new AwsCognitoRSAKeyProvider(aws_cognito_region, aws_user_pools_id);
		Algorithm algorithm = Algorithm.RSA256(keyProvider);
		JWTVerifier jwtVerifier = JWT.require(algorithm)
		    //.withAudience("2qm9sgg2kh21masuas88vjc9se") // Validate your apps audience if needed
		    .build();

//		String token = "eyJraWQiOiJEVVwvOFBjaGJmdUJKOWVhRUl3UG01SXNjaXZlWFdTZExFM0NlWTZOQ2Q3RT0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJmNjc3MDQzYy00YTVkLTQ3OTctODgzNi0zYWY1M2E1N2I2ZmMiLCJldmVudF9pZCI6ImRmM2JkOTdkLWY3MDktNDRmOS04YmU0LTExMWQ5MWUxYTEwMCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoib3BlbmlkIGVtYWlsIiwiYXV0aF90aW1lIjoxNjExNjQ1OTY0LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0yLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMl9MQU03bDJ5anYiLCJleHAiOjE2MTE2NDk1NjQsImlhdCI6MTYxMTY0NTk2NCwidmVyc2lvbiI6MiwianRpIjoiMzE3ZWUxNjEtMDFkZS00NDkxLWJhMmYtMGMxOTA2Y2RiMzE5IiwiY2xpZW50X2lkIjoiMXN2MWVsdDdlcGxyZmtzbTdsaWo4ZjhhN3UiLCJ1c2VybmFtZSI6ImhhaW50In0.SJ0l2nu26UjsyNu6X7TQAL7rlNsEXSRi-IeAYPXlE_Ia947tMsw-rn00qrB9lpm07QNQSE5Q4TuaQD5MO4LRJiuGx6O_bRWCRb1p-1cBrJ47Xknr33S5A8v9kivKmwils93kkzyb30rUGr2JxnpZFBqtXWtCHV2Adjc0A4LVMloxUeLVY8-uoGpuy-S1bQg9Wy3YWG_XFm2E5UZaPJD5LxRbiwPpQMG9m-MVl8_Nbz97yWHhfFryOAfRrSOrqTIm1v8274LFI4l9QFPL4z0dSQfMD1dkXW0uQqaOQECAWH5bAvSfTbYnXwshKw59izXtqmZsLQRVWl56iSOaRg8wgA"; // Replace this with your JWT token
		jwtVerifier.verify(token);
		return true;
	}
}
