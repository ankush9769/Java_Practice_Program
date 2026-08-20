package com.example.productcatalog1throughVersion.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.RequestInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {
    private static final int MAX_REQUEST = 5;
    private static final long TIME_WINDOW = 60000;
    private final Map<String,RequestInfo> requestCounts = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String clintIp = request.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        RequestInfo requestInfo = requestCounts.get(clintIp); //null

        if(requestInfo == null){
            requestInfo = new RequestInfo(1,currentTime);
            requestCounts.put(clintIp,requestInfo);
        }
        else if(currentTime - requestInfo.getStartTime() > TIME_WINDOW){
            requestInfo.setRequestCount(1);
            requestInfo.setStartTime(currentTime);
        }
        else{
            requestInfo.setRequestCount(requestInfo.getRequestCount()+1);
        }

        if(requestInfo.getRequestCount() > MAX_REQUEST){
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.setContentType("application/json");
            response.getWriter().write(
                    String.format("""
                            {
                            "success":false,
                            "message":"rate limit exceede for %s. Try again later."
                            "data":null
                            }
                            """,clintIp)
            );
            return; // stop execution
        }
        filterChain.doFilter(
                request,response
        );
    }

    //static inner class
    private static class RequestInfo{
        private int requestCount;
        private long startTime;
        public RequestInfo(int requestCount,long startTime){
            this.requestCount = requestCount;
            this.startTime = startTime;
        }
        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }
        
    }
}
