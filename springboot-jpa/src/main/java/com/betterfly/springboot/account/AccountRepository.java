package com.betterfly.springboot.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by betterfly
 * Date : 2019.03.14
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
