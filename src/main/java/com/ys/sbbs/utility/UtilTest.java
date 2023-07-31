package com.ys.sbbs.utility;

import java.util.List;

public class UtilTest {

	public static void main(String[] args) {
		AsideUtil au = new AsideUtil();
//		String roadAddr  = au.getRoadAddr("경기도 수원시 장안구청");
//		System.out.println(roadAddr);
//
//		List<String> list = au.getGeoCode(roadAddr);
//		String lng = list.get(0);
//		String lat = list.get(1);
//		System.out.println("경도 : "+lng+" 위도 : "+lat);
		String lng ="127.010400656538", lat ="37.3040947298509";
		
		String weatherStr = au.getWeather(lng, lat);
		System.out.println(weatherStr);
		
		
	}

}
