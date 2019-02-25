package com.mp.test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.beans.User;
import com.mp.mapper.UserMapper;

public class TestMP {
	private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private UserMapper userMapper = iocContext.getBean("userMapper",UserMapper.class);
	@Test
	public void testEnvironment() throws Exception {
		DataSource ds = iocContext.getBean("dataSource", DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	
	@Test//查询全部
	public void testSelect() {
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}
	@Test//查询count
	public void testSelect2() {
		int count = userMapper.selectCount(null);
		System.out.println(count);
	}
	@Test//查询单个对象
	public void testSelect3() {
		User user = new User();
		user.setAge(18);
		user.setEmail("510453754@qq.com");
		user.setId(6);
		user.setName("dongmei");
		User u = userMapper.selectById(1);
		
		System.out.println(u);
	}
	@Test//增
	public void testInsert() {
		User user = new User();
		user.setAge(18);
		user.setEmail("510453754@qq.com");
		user.setId(6);
		user.setName("dongmei");
		userMapper.insert(user);
	}
	@Test//改
	public void testUpdate() {
		User user = new User();
		user.setId(6);
		user.setName("zhangyang");
		user.setAge(18);
		user.setEmail("510453754@qq.com");
		userMapper.updateById(user);
	}
//	@Test//改
//	public void testUpdate2() {
//		User user = new User();
//		user.setId(6);
//		user.setName("zhangyang");
//		user.setAge(18);
//		user.setEmail("510453754@qq.com");
//		userMapper.update(user,null);
//	}
	@Test//删:DELETE FROM user WHERE id=?
	public void testDelete() {
		int result = userMapper.deleteById(8);
		System.out.println(result);
	}
	@Test//分页:SELECT id AS id,`name`,age,email FROM user WHERE (age BETWEEN ? AND ?)
	//使用条件构造器:2.3版本：EntityWrapper，3.0.7版本用QueryWrapper/UpdateWrapper
	public void testPage() {
//		List<User> userListCondition = userMapper.selectPage(
//				new Page<User>(2,3), Condition.create().between("age", 18, 20));
//		userListCondition.forEach(System.out::println);
		List<User> userList = userMapper.selectPage(
				new Page<User>(2, 3),
				new EntityWrapper<User>().between("age", 18, 20)
				);
		userList.forEach(System.out::println);
	}
	
	@Test	//setSqlSelect:SELECT id,name FROM user
	public void setSqlSelect() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().setSqlSelect("id","name"));
		System.out.println(userList);
	}
	
	@Test	//where:SELECT id AS id,`name`,age,email FROM user WHERE (name like '%ang%' and age=18)
	public void where() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().where("name like '%ang%' and age=18"));
		System.out.println(userList);
	}
	
	@Test	//and:SELECT id AS id,`name`,age,email FROM user WHERE (name like '%ang%' AND age=18)
	public void and() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().where("name like '%ang%'").and("age=18"));
		System.out.println(userList);
	}
	
	@Test	//or:SELECT id AS id,`name`,age,email FROM user WHERE (name like '%ang%' OR age=18)
	public void or() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().where("name like '%ang%'").or("age=18"));
		System.out.println(userList);
	}
	
	@Test	//orNew:SELECT id AS id,`name`,age,email FROM user WHERE (name like '%ang%') OR (age=18)
	//同理与andNew
	public void orNew() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().where("name like '%ang%'").orNew("age=18"));
		System.out.println(userList);
	}
	
	@Test	//eq:SELECT id AS id,`name`,age,email FROM user WHERE (name = ?)
	public void eq() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().eq("name", "zhangyang"));
		System.out.println(userList);
	}
	
	@Test	//allEq:SELECT id AS id,`name`,age,email FROM user WHERE (name = ? AND age = ?)
	public void allEq() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("age",18);
		map.put("name", "dongmei");
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().allEq(map));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//ne:SELECT id AS id,`name`,age,email FROM user WHERE (age <> ?)
	public void ne() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("age",18);
//		map.put("name", "dongmei");
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().ne("age",18));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//gt:SELECT id AS id,`name`,age,email FROM user WHERE (age > ?)
	//ge：>=		lt:<	le:<=
	public void gt() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().gt("age",18));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//like:SELECT id AS id,`name`,age,email FROM user WHERE (name LIKE ?)
	//同理与notLike
	public void like() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().like("name", "ang"));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//in:SELECT id AS id,`name`,age,email FROM user WHERE (age IN (?,?))
	//SELECT id AS id,`name`,age,email FROM user WHERE (name IN (?,?))
	//同理于notIn
	public void in() {
		//String[] ages = {"20","21"};//必须是字符串数组
		String[] names = {"dongmei","huangfei"};
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().in("name",names));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//isNull:SELECT id AS id,`name`,age,email FROM user WHERE (name IS NULL)
	//同理于isNotNull
	public void isNull() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().isNull("name"));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//groupBy:SELECT id AS id,`name`,age,email FROM user GROUP BY name, age
	//3.0.7版本可以直接groupBy("name","age")
	public void groupBy() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().groupBy("name").groupBy("age"));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//having:SELECT sum(age),email FROM user GROUP BY email HAVING (sum(age)>40)
	public void having() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().groupBy("email").having("sum(age)>40"));
		for(User user : userList) {
			System.out.println(user.getName());
		}
	}
	
	@Test	//orderBy:SELECT id AS id,`name`,age,email FROM user ORDER BY age
	//同理于orderAsc/orderDesc
	public void orderBy() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().orderBy("age"));
		for(User user : userList) {
			System.out.println(user.getName()+"----------------"+user.getAge());
		}
	}
	@Test	//EXISTS:SELECT id AS id,`name`,age,email FROM user WHERE ( EXISTS (select id from user where age = 1))
	//EXISTS ( sql语句 ),同理于notExists
	public void exists() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().exists("select id from user where age = 1"));
		for(User user : userList) {
			System.out.println(user.getName()+"----------------"+user.getAge());
		}
	}
	
	@Test	//between:SELECT id AS id,`name`,age,email FROM user WHERE (age BETWEEN ? AND ?)
	//同理于notBetween
	public void between() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().between("age", 18, 20));
		for(User user : userList) {
			System.out.println(user.getName()+"----------------"+user.getAge());
		}
	}
	
	@Test	//addFilter:Preparing: SELECT id AS id,`name`,age,email FROM user WHERE (id=?)
	//Parameters: 1(Integer)
	//在3.0.7版本方法名是：apply,表示自由拼接sql，动态入参的params对应前面sqlHaving内部的{index}部分.这样是不会有sql注入风险的,反之会有!
	public void addFilter() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().addFilter("id={0}",1));
		for(User user : userList) {
			System.out.println(user.getName()+"----------------"+user.getAge());
		}
	}
	
	@Test	//addFilter:Preparing: SELECT id AS id,`name`,age,email FROM user WHERE (age BETWEEN ? AND ?) limit 1
	//无视优化规则直接拼接到 sql 的最后
	//只能调用一次,多次调用以最后一次为准 有sql注入的风险,请谨慎使用
	public void last() {
		List<User> userList = userMapper.selectList(new EntityWrapper<User>().last("limit 1").between("age", 18, 20));
		for(User user : userList) {
			System.out.println(user.getName()+"----------------"+user.getAge());
		}
	}
}
