package com.suqb.map.pojo.request.location;

/**
 * @author suqb 2023/4/17
 * 多边形区域地点检索请求参数
 */
@SuppressWarnings("all")
public interface PrrRequestParams {
    /**
     * required
     * 检索关键字
     */
    String QUERY = "query";
    /**
     * required
     * 检索多边形区域。需传入多个坐标对集合，坐标对用','分割，首尾坐标对需相同。多边形为矩形时，可传入左上右下两顶点坐标对。
     */
    String BOUNDS = "bounds";
    /**
     * required
     * 开发者的访问密钥
     */
    String AK = "ak";
    /**
     * 检索偏好，多个可以以逗号分隔
     */
    String TAG = "tag";
    /**
     * 是否召回国标行政区划编码，true（召回）、false（不召回）
     */
    String EXTENSIONS_ADCODE = "extensions_adcode";
    /**
     * json xml
     */
    String OUTPUT = "output";
    /**
     * 检索结果详细程度。取值为1 或空，则返回基本信息；取值为2，返回检索POI详细信息
     */
    String SCOPE = "scope";
    /**
     * 检索过滤条件。当scope取值为2时，可以设置filter进行排序。
     *      industry_type：行业类型，注意：设置该字段可提高检索速度和过滤精度，
     *          取值有： hotel（宾馆）；cater（餐饮）；life（生活娱乐）
     *      sort_name：排序字段，根据industry_type字段的值而定。
     *          1、industry_type为hotel时，sort_name取值有： default（默认）；price（价格）；total_score（好评）；level（星级）；health_score（卫生）；distance（距离排序，需结合center字段一起使用）
     *          2、industry_type为cater时，sort_name取值有： default（默认）；taste_rating（口味）；price（价格）；overall_rating（好评）；service_rating（服务）；distance（距离排序，需结合center字段一起使用）
     *          3、industry_type为life时，sort_name取值有： default（默认）；price（价格）；overall_rating（好评）；comment_num（服务）；distance（距离排序，需结合center字段一起使用）
     *      sort_rule：排序规则：0（从高到低），1（从低到高）
     *      price_section：价格区间
     *      groupon：是否有团购：1（有），0（无）
     *      discount：是否有打折：1（有），0（无）
     */
    String FILTER = "filter";
    /**
     * 坐标类型，1（wgs84ll即GPS经纬度），2（gcj02ll即国测局经纬度坐标），3（bd09ll即百度经纬度坐标），4（bd09mc即百度米制坐标）
     */
    String COORD_TYPE = "coord_type";
    /**
     * 可选参数，添加后POI返回国测局经纬度坐标
     */
    String RET_COORDTYPE = "ret_coordtype";
    /**
     * 单次召回POI数量，默认为10条记录，最大返回20条。多关键字检索时，返回的记录数为关键字个数*page_size。
     */
    String PAGE_SIZE = "pageSize";
    /**
     * 分页页码，默认为0,0代表第一页，1代表第二页，以此类推。常与page_size搭配使用，仅当返回结果为poi时可以翻页
     */
    String PAGE_NUM = "pageNum";
    /**
     * 开发者的权限签名
     */
    String SN = "sn";
    /**
     * 时间戳 设置sn后该值必填
     */
    String TIMESTAMP = "timestamp";
    /**
     * 是否输出图片信息：true(输出) 、false(不输出)
     */
    String PHOTO_SHOW = "photo_show";

}
