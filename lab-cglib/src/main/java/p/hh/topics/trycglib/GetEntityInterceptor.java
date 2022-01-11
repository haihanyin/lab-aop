package p.hh.topics.trycglib;


import org.apache.commons.lang3.concurrent.EventCountCircuitBreaker;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public class GetEntityInterceptor implements MethodInterceptor {

    private final EventCountCircuitBreaker eventCountCircuitBreaker;

    private RestTemplate restTemplate;

    public GetEntityInterceptor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        eventCountCircuitBreaker = new EventCountCircuitBreaker(2, 100, TimeUnit.SECONDS);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("getForEntity".equals(method.getName())) {
            if (eventCountCircuitBreaker.checkState()) {
                try {
                    return methodProxy.invoke(restTemplate, objects);
                } catch (Throwable throwable) {
                    System.out.println("eventCountCircuitBreaker.incrementAndCheckState");
                    eventCountCircuitBreaker.incrementAndCheckState();
                    throw throwable;
                }
            } else {
                throw new ResourceAccessException("Throw error directly from proxy because the remote service is busy.");
            }
        } else {
            return methodProxy.invoke(restTemplate, objects);
        }
    }
}
