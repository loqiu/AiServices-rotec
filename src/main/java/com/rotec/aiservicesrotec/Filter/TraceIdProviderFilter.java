package com.rotec.aiservicesrotec.Filter;

import com.rotec.aiservicesrotec.common.TraceContext;
import com.rotec.aiservicesrotec.constant.TraceConstant;
import com.rotec.aiservicesrotec.util.TraceIdUtil;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = CommonConstants.PROVIDER)
public class TraceIdProviderFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment(TraceConstant.TRACE_ID_HEADER);
        if (traceId != null && !traceId.isEmpty()) {
            TraceContext.setTraceId(traceId);
        } else {
            TraceContext.setTraceId(TraceIdUtil.generateTraceId());
        }
        try {
            return invoker.invoke(invocation);
        } finally {
            TraceContext.removeTraceId();
        }
    }
}
