package com.rotec.aiservicesrotec.interceptor;

import com.rotec.aiservicesrotec.common.TraceContext;
import com.rotec.aiservicesrotec.constant.TraceConstant;
import com.rotec.aiservicesrotec.util.TraceIdUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TraceIdInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = request.getHeader(TraceConstant.TRACE_ID_HEADER);
        if(traceId == null || traceId.isEmpty()){
            traceId = TraceIdUtil.generateTraceId();
        }
        TraceContext.setTraceId(traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TraceContext.clear();
    }
}
