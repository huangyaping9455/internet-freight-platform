/**
 *
 */
package com.rising.rbac.authentication;

import com.rising.rbac.domain.Admin;
import com.rising.rbac.repository.AdminRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


/**
 * 描述：rbac impl用户详细信息服务
 *
 * @see UserDetailsService
 * @see SocialUserDetailsService
 * 作者：李启云
 * 日期：2021-01-07
 */
@Component
@Transactional
public class RbacUserDetailsServiceImpl implements UserDetailsService, SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 创建：李启云
     * 日期：2020-10-13
     * 描述：加载用户的用户名
     *
     * @param username 用户名
     * @return {@link UserDetails }
     * @throws UsernameNotFoundException 用户名没有发现异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名:" + username);
        Admin admin = adminRepository.findByUsername(username);
        //根据查找到的用户信息判断用户是否被冻结
        Set<String> urls = admin.getUrls();
        if (StringUtils.equals("admin", username)) {
            return admin;
        }
        redisTemplate.opsForValue().set(username, urls);

        return admin;

    }

    /**
     * 创建：李启云
     * 日期：2020-10-13
     * 描述：加载用户的用户id
     *
     * @param userId 用户id
     * @return {@link SocialUserDetails }
     * @throws UsernameNotFoundException 用户名没有发现异常
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户Id:" + userId);
        Admin admin = adminRepository.findById(Long.valueOf(userId)).get();
        ////根据查找到的用户信息判断用户是否被冻结
        admin.getUrls();
        return admin;
    }

}
