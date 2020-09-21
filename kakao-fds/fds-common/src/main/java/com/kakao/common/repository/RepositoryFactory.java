package com.kakao.common.repository;

import java.sql.Connection;

public interface RepositoryFactory {
    Connection connect() throws Exception;
}
