package de.gedoplan.beantrial.wildflycdiscopeinit.interceptor;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@TraceCall
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TraceCallInterceptor implements Serializable
{
  @AroundInvoke
  public Object traceCall(InvocationContext invocationContext) throws Exception
  {
    System.out.println(invocationContext.getMethod());

    return invocationContext.proceed();
  }
}
