package com.demo.shanelee.contextinference;


import com.demo.shanelee.contextinference.entity.IAttributes;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by lx on 2016/5/17.
 */
public class CommonUtil {

    public static List<Map.Entry<String, Double>> sortMapByDoubleValue(Map<String, Double> map){
        List<Map.Entry<String, Double>> infolds = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
        Collections.sort(infolds, new Comparator<Map.Entry<String, Double>>(){
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                if(o1.getValue() < o2.getValue()){
                    return -1;
                } else if(o1.getValue().equals(o2.getValue())) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        return infolds;
    }

    public static String[] getEnumPropNamesByClazzName(String name){
        String fullPackageUrl = "com.demo.shanelee.contextinference.entity." + name.trim().substring(0,1).toUpperCase() + name.trim().substring(1).toLowerCase();
        Class<?> c = null;
        try {
            c = Class.forName(fullPackageUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String[] propNames = new String[c.getEnumConstants().length];
        for (int i = 0; i < c.getEnumConstants().length; i++){
            IAttributes a = (IAttributes)c.getEnumConstants()[i];
            propNames[i] = a.getName();
        }
        return propNames;
    }

    public static int getDrawableByFileName(String name){
        Integer resId = null;
        Class drawable = R.drawable.class;
        Field field = null;
        try {
            field = drawable.getField(name);
            resId = field.getInt(field.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return resId;
    }

}
