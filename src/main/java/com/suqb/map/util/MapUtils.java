package com.suqb.map.util;

import com.suqb.map.constant.BaiduMapApiLocationConstant;
import com.suqb.map.pojo.request.location.ArsRequestParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author suqb 2023/4/17
 * 地图工具类
 */
@Slf4j
@Component
public class MapUtils {
    @Value("${map.application.key}")
    private String key;
    @Value("${map.application.output}")
    private String output;

    /**
     * 根据行政区域查询地点
     * @param ars params
     * @return resp
     */
    public HttpEntity searchLocationByRegion(Map<String, Object> ars) throws IOException {
        // 拼接URL
        String url = BaiduMapApiLocationConstant.Location.ADMINISTRATIVE_REGION_SEARCH + paramsJoint(ars);

        log.info("execute URL = {}", url);
        // 创建客户端
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute;
        // 查询
        CloseableHttpClient httpClient = HttpClients.createDefault();
        execute = httpClient.execute(httpGet);
        StatusLine statusLine = execute.getStatusLine();
        // 当http状态码等于200是查询成功
        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
            return execute.getEntity();
        }
        return null;
    }

    /**
     * 拼接GET请求查询参数
     * @param map 参数map
     * @return String
     */
    private String paramsJoint(Map<String, Object> map) {
        // 设置ak output
        map.computeIfAbsent(ArsRequestParams.AK, k -> key);
        map.computeIfAbsent(ArsRequestParams.OUTPUT, o -> output);
        // 遍历数据拼接成[?k=v&k=v]形式
        Set<String> keySet = map.keySet();
        StringBuilder params = new StringBuilder("?");
        keySet.forEach(key -> params.append(key).append("=").append(map.get(key)).append("&"));
        return params.toString();
    }
}
