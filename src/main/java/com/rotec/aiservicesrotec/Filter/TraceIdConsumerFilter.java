package com.rotec.aiservicesrotec.Filter;

import com.rotec.aiservicesrotec.common.TraceContext;
import com.rotec.aiservicesrotec.constant.TraceConstant;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = CommonConstants.CONSUMER)
public class TraceIdConsumerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = TraceContext.getTraceId();
        if (traceId != null && !traceId.isEmpty()) {
            RpcContext.getContext().setAttachment(TraceConstant.TRACE_ID_HEADER, traceId);
        }
        return invoker.invoke(invocation);
    }

}
