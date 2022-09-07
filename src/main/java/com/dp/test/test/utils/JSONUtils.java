package com.dp.test.test.utils;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @author Ldp
 * @date 2021/7/14
 */
public class JSONUtils {

    public static int              DEFAULT_PARSER_FEATURE;
    static {
        int features = 0;
        features |= Feature.AutoCloseSource.getMask();
        features |= Feature.InternFieldNames.getMask();
        features |= Feature.UseBigDecimal.getMask();
        features |= Feature.AllowUnQuotedFieldNames.getMask();
        features |= Feature.AllowSingleQuotes.getMask();
        features |= Feature.AllowArbitraryCommas.getMask();
        features |= Feature.SortFeidFastMatch.getMask();
        features |= Feature.IgnoreNotMatch.getMask();
        DEFAULT_PARSER_FEATURE = features;
    }

    public static <T> T gg(String json,Class<T> clazz){
        DefaultJSONParser parser = new DefaultJSONParser(json, ParserConfig.global, DEFAULT_PARSER_FEATURE);
        T value = (T) parser.parseObject(clazz, null);
        parser.handleResovleTask(value);
        return value;
    }

}
