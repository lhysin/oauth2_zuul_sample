package io.test.config.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.netflix.zuul.ZuulFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostFilter extends ZuulFilter {
 
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.debug("Post Filter");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            Object obj = auth.getPrincipal();
            log.debug("obj : {}", obj);
        }
        
        return null;
    }
}
