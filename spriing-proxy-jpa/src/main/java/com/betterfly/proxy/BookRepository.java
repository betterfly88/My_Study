package com.betterfly.proxy;

import org.springframework.data.jpa.repository.JpaRepository;

/*
    BookRepository Interface는 어떠한 애노테이션도 없다.
    빈으로 등록될것처럼 보이지도 않는다.
    하지만 우리는 JPA를 통해 이처럼 BookRepository를 가져다 쓰고 있다.

    interface를 따로 구현하지도, Bean으로 등록하지도 않았는데 어떻게 인스턴스가 생성되었을까?
    이 부분에 주목해야 한다.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
