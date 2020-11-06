package com.cloud.dy.user.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangquansong
 * @title: MybatisPlusConfig
 * @projectName demo
 * @description:
 * @date 2020/10/23下午2:20
 */
@Slf4j
@Configuration
@RefreshScope
public class MybatisPlusConfig {

    @Value("${my.tenantId.tableFilter.list}")
    private String tableFilter;

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 创建SQL解析器集合
        List<ISqlParser> sqlParserList = new ArrayList<>();

        // 创建租户SQL解析器
        TenantSqlParser tenantSqlParser = new TenantSqlParser();

        // 设置租户处理器
        tenantSqlParser.setTenantHandler(new TenantHandler() {

            @Override
            public Expression getTenantId() {
                // 设置当前租户ID，实际情况你可以从cookie、或者缓存中拿都行
                return new LongValue(0);
            }

            @Override
            public String getTenantIdColumn() {
                // 对应数据库租户ID的列名
                return "user_version";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                log.info("tableFilter : {}", tableFilter);
                // 是否需要需要过滤某一张表
                List<String> tableNameList = Arrays.asList(tableFilter.split(","));
                if (tableNameList.contains(tableName)) {
                    return true;
                }
                return false;
            }
        });

        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);


        return paginationInterceptor;
    }

}