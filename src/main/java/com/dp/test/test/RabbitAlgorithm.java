package com.dp.test.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Ldp
 * @date 2021/8/24
 */
public class RabbitAlgorithm {

    public static void main(String[] args) throws ParseException {

        Long l = new Long("0");
        List<Long> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(3L);
        int i = 1;
        while (CollectionUtils.isNotEmpty(list)){
            l += xxx(l,list);
            i++;
            if (i > 5){
                list= null;
            }
        }
    }


    private static Long xxx(Long l,List<Long> list){
        for (Long aLong : list) {
            System.out.println(++l);
        }
        return l;
    }
}
