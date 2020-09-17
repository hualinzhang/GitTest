package com.homework.dao.impl;

import com.homework.dao.AccountsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
add func1
@Repository("accountsDao")
public class AccountsDaoImpl implements AccountsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int searchMoney(String name) {
        String sql = "select money from accounts where name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class,name);
    }

    @Override
    public void addMoney(String name, int money) {
        String sql = "update accounts set money = money + ? where name = ?";
        jdbcTemplate.update(sql, money, name);
    }
add func2
    @Override
    public void delMoney(String name, int money) {
        String sql1 = "select money from accounts where name = ?";
        int yue = jdbcTemplate.queryForObject(sql1, Integer.class,name);
        if(yue >= money){
            String sql2 = "update accounts set money = money - ? where name = ?";
            jdbcTemplate.update(sql2, money, name);
        } else {
            System.out.println("抱歉，余额不足！！");
        }
    }

}
