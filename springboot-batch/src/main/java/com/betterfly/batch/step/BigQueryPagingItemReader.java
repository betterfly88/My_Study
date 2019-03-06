package com.betterfly.batch.step;

import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by 이충일 (betterfly@wemakeprice.com)
 * Date : 2019.03.06
 */
public class BigQueryPagingItemReader<T> extends AbstractPagingItemReader{

    private DataSource dataSource;

    private PagingQueryProvider queryProvider;

    private Map<String, Object> parameterValues;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<T> rowMapper;

    private String firstPageSql;

    private String remainingPagesSql;

    private Map<String, Object> startAfterValues;

    private Map<String, Object> previousStartAfterValues;



    private int chunkSize;
    private String requestDate;


    public BigQueryPagingItemReader fetchSize(int chunkSize){
        this.chunkSize = chunkSize;
        return this;
    }

    public BigQueryPagingItemReader requestDate(String requestDate){
        this.requestDate = requestDate;
        return this;
    }

    public BigQueryPagingItemReader build(){
        return this;
    }

    @Override
    protected void doReadPage() {
        if (results == null) {
            results = new CopyOnWriteArrayList<>();
        }
        else {
            results.clear();
        }
        setPageSize(15);

        results.add("aasdas_1");
        results.add("aasdas_2");
        results.add("aasdas_3");
        results.add("aasdas_4");
        results.add("aasdas_5");
        results.add("aasdas_6");
        results.add("aasdas_7");
        results.add("aasdas_8");
        results.add("aasdas_9");
        results.add("aasdas_10");
        results.add("aasdas_11");
        results.add("aasdas_12");
        results.add("aasdas_13");
        results.add("aasdas_14");
        results.add("aasdas_15");
        results.add("aasdas_16");
        results.add(17);
        results.add("aasdas_18");
        results.add("aasdas_19");
        results.add("aasdas_20");

        List<?> query;

//        if (getPage() == 0) {
//            if (logger.isDebugEnabled()) {
//                logger.debug("SQL used for reading first page: [" + firstPageSql + "]");
//            }
//            if (parameterValues != null && parameterValues.size() > 0) {
//                if (this.queryProvider.isUsingNamedParameters()) {
//                    query = namedParameterJdbcTemplate.query(firstPageSql,
//                            getParameterMap(parameterValues, null), rowCallback);
//                }
//                else {
//                    query = getJdbcTemplate().query(firstPageSql,
//                            getParameterList(parameterValues, null).toArray(), rowCallback);
//                }
//            }
//            else {
//                query = getJdbcTemplate().query(firstPageSql, rowCallback);
//            }
//
//        }
//        else {
//            previousStartAfterValues = startAfterValues;
//            if (logger.isDebugEnabled()) {
//                logger.debug("SQL used for reading remaining pages: [" + remainingPagesSql + "]");
//            }
//            if (this.queryProvider.isUsingNamedParameters()) {
//                query = namedParameterJdbcTemplate.query(remainingPagesSql,
//                        getParameterMap(parameterValues, startAfterValues), rowCallback);
//            }
//            else {
//                query = getJdbcTemplate().query(remainingPagesSql,
//                        getParameterList(parameterValues, startAfterValues).toArray(), rowCallback);
//            }
//        }
//
//        Collection<T> result = (Collection<T>) query;
//        results.addAll(result);


    }

    @Override
    protected void doJumpToPage(int itemIndex) {

    }
}
