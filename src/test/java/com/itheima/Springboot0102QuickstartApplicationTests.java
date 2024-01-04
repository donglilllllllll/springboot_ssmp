package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mapper.bookMapper;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author kaixiang
 * date:2024/1/4 10:48
 */
@SpringBootTest(classes = Springboot0102QuickstartApplication.class)
class Springboot0102QuickstartApplicationTests {
	//注入你要测试的对象
	@Autowired
	private bookMapper bookmapper;

	@Test
	void testSvae(){
		Book book= new Book();
		book.setDescription("yrwehihhhhhhkhkh");
		book.setName("test");
		book.setType("还是客家话");
		bookmapper.insert(book);

	}
	@Test
	void testDelete(){

		bookmapper.deleteById(2001);


	}
	@Test
	void testUpdate(){
		Book book= new Book();
		book.setId(2000);
		book.setDescription("测试");
		book.setName("test3");
		book.setType("还是客家话");
		bookmapper.updateById(book);

	}
	@Test
	void testGetById() {

		bookmapper.selectById(1);

	}


	@Test
	void testGetAll(){
		bookmapper.selectList(null);

	}

	@Test
	void testGetPage(){

		IPage page = new Page(1,10);
		bookmapper.selectPage(page,null);
		System.out.println(page.getPages());
		System.out.println(page.getCurrent());
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.getRecords());



	}
	@Test
	void testGetby(){
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name","张");
		bookmapper.selectList(queryWrapper);
	}
	@Test
	void testGetb2(){

		String name ="张";
		LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
		//普通的
		//if(name != null)queryWrapper.like(Book::getName,name);

		queryWrapper.like(name != null,Book::getName,name);
		bookmapper.selectList(queryWrapper);
	}
	@Test
	void testGetb3(){



	}


}
