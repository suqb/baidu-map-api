package com.suqb.map.web;

import com.suqb.map.util.MapUtils;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

import static com.suqb.map.pojo.request.location.ArsRequestParams.*;

/**
 * @author suqb 2023/4/17
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final MapUtils mapUtils;

    @RequestMapping("/test")
    public String test() throws IOException {
        HashMap<String, Object> query = new HashMap<>(15);
        query.put(QUERY, "银行");
        query.put(REGION, "广州");
        HttpEntity httpEntity = mapUtils.searchLocationByRegion(query);
        return EntityUtils.toString(httpEntity, "UTF-8");
    }

}
