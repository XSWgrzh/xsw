package com.xsw.blog.config;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author xiesw
 * @since 2020/12/31 10:05
 */
@Component
public class DataSourceRuleManager {

    private static final String remoteAddress = "localhost:8848";
    private static final String groupId = "DEFAULT_GROUP";
    private static final String flowDataId = "xsw-blog-sentinel";

    @PostConstruct
    public void loadFlowRules() {
        FlowConverter converter = new FlowConverter();
        //连接Nacos，读取配置信息并通过converter将内容转换为对象
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource =
                new NacosDataSource<>(remoteAddress, groupId, flowDataId, converter);
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

    //转换器 从Nacos配置中心读取到的数据转换为对象
    public class FlowConverter implements Converter {
        @Override
        public Object convert(Object source) {
            return JSON.parseArray(source.toString(), FlowRule.class);
        }
    }

}
