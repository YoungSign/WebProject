package com.tuling.auth.domain;

import com.tuling.tulingmall.model.UmsMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Fox
 */
public class MemberDetails implements UserDetails {
    private UmsMember umsMember;
    
    public MemberDetails(UmsMember umsMember) {
        this.umsMember = umsMember;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限  BRAC   user  role  authority
        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
    }
    
    @Override
    public String getPassword() {
        return umsMember.getPassword();
    }
    
    @Override
    public String getUsername() {
        return umsMember.getUsername();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return umsMember.getStatus()==1;
    }
    
    public UmsMember getUmsMember() {
        return umsMember;
    }
}