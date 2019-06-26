package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import version2.InfixInToSuffix;

public class InfixInToSuffixTest {
	private InfixInToSuffix infixInToSuffix;
	/**
	 * 在每个方法执行前执行
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// 构建对象
		infixInToSuffix=new InfixInToSuffix();
	}
	/**
	 * 在每个方法执行后执行
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	/**
	 * @Description: 测试将中缀表达式转化为后缀表达式
	 * @author BushRo
	 * @date 2019-06-23
	 * @version 1.0
	 *
	 */
	@Test
	public void testToSuffix() {
		String suff=infixInToSuffix.toSuffix("1 + 2 * 3 + (4 * 5 + 6) * 7");
		System.out.println(suff);
	}

}
