package cstk.chisato.security;

import cstk.chisato.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JdbcTemplateUserDetailService implements UserDetailsService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateUserDetailService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = jdbcTemplate.queryForObject("select * from user where username = ?", User.class, username);

        if (user == null){
            throw new UsernameNotFoundException("用户名/密码错误");
        }

        return new SystemUserDetails(user);
    }
}
