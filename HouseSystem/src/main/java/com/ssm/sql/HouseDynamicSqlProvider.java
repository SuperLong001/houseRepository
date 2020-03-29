package com.ssm.sql;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

import com.ssm.bean.AdvancedQueryCondition;

/**
 * 房产动态sql提供类
 * @author 小龙
 *
 */
public class HouseDynamicSqlProvider {
	
	public String select (AdvancedQueryCondition condition){
		
		return new SQL(){
			{
				SELECT("*");
				FROM("house_info");
				
				StringBuffer whereClause = new StringBuffer();
				
				if(condition.getDistrict()!=0){
					String district =" and house_district="+condition.getDistrict();
					whereClause.append(district);
				}
				
				if(condition.getStreet()!=0){
					String street =" and house_street ="+condition.getStreet();
					whereClause.append(street);
				}
				
				if(condition.getRoom()!=0){
					String room =" and room ="+condition.getRoom();
					whereClause.append(room);
				}
				
				if(condition.getHall()!=0){
					String hall =" and hall ="+condition.getHall();
					whereClause.append(hall);
				}
				
				if(condition.getMax_price()!=0){
					String price = " and (rental_price>="+condition.getMin_price()+" and  rental_price<="+condition.getMax_price()+")";
					whereClause.append(price);
				}
				
				if(condition.getHouse_types()!=null){
					StringBuffer in =new StringBuffer(" AND house_type IN (");
					
					for(int i=0;i<condition.getHouse_types().size();i++){
						if(i==0){
							in.append(condition.getHouse_types().get(i));
						}
						
						in.append(","+condition.getHouse_types().get(i));
						
						if(i==condition.getHouse_types().size()-1){
							in.append(","+condition.getHouse_types().get(i)+")");
						}
					}
					
					whereClause.append(in);
				}
				
				if(condition.getRelease_time()!=0){
					
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			        
					String today = sdf.format(new Date()).toString();
					
			        Calendar rightNow = Calendar.getInstance();
			        rightNow.setTime(new Date());
			        
			        //rightNow.add(Calendar.YEAR,-1); 日期减1年
			        //rightNow.add(Calendar.MONTH,3); 日期加3个月
			        
			        rightNow.add(Calendar.DAY_OF_YEAR,-condition.getRelease_time());//日期加10天
			        
			        Date dt1=rightNow.getTime();
			        String reStr = sdf.format(dt1); 
					
			        whereClause.append(" and DATE(release_time) BETWEEN '"+reStr+"' AND '"+today+"'");
			    
				}
				
			    if(!"".equals(whereClause.toString())){
                     WHERE(whereClause.toString().replaceFirst("and", ""));
                }
			    
			}
		}.toString();
		
	}
	
}
