package com.tuling.auth.service;

import com.tuling.auth.domain.MemberDetails;
import com.tuling.auth.feign.UmsMemberFeignService;
import com.tuling.tulingmall.common.api.CommonResult;
import com.tuling.tulingmall.model.UmsMember;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Fox
 */
@Service
@Slf4j
public class TulingUserDetailService implements UserDetailsService {
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // TODO  查数据库获取用户信息   rpc调用
        // 加载用户信息
        if (StringUtils.isEmpty(username)) {
            log.warn("用户登陆用户名为空:{}", username);
            throw new UsernameNotFoundException("用户名不能为空");
        }
        
        UmsMember umsMember = getByUsername(username);
        
        if (null == umsMember) {
            log.warn("根据用户名没有查询到对应的用户信息:{}", username);
        }
        
        log.info("根据用户名:{}获取用户登陆信息:{}", username, umsMember);
        
        // 会员信息的封装 implements UserDetails
        MemberDetails memberDetails = new MemberDetails(umsMember);
        
        return memberDetails;
    }
    
    @Autowired
    private UmsMemberFeignService umsMemberFeignService;
    
    public UmsMember getByUsername(String username) {
        // fegin获取会员信息
        CommonResult<UmsMember> umsMemberCommonResult = umsMemberFeignService.loadUserByUsername(username);
        
        return umsMemberCommonResult.getData();
    }
}
