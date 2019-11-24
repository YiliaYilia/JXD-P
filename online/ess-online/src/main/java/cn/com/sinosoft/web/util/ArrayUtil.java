package cn.com.sinosoft.web.util;

import java.io.Serializable;

public class ArrayUtil {

	/**
	 * 功能：合并数组
	 * 描述：-
	 * 作者： ZhangTiancong
	 * @param localArray	源数组
	 * @param inArray		追加数组
	 */
	public static <T> T[] mergeArray(T[] localArray,T[] inArray){
		T[] tempArray = null;
		if(localArray == null){
			tempArray = inArray;
		}else if(inArray.length>0) {
			tempArray = (T[]) new Object[localArray.length+inArray.length];
		    System.arraycopy(localArray, 0, tempArray, 0, localArray.length);
		    System.arraycopy(inArray, 0, tempArray, localArray.length, inArray.length);
		}
		return tempArray;
	}

	public static void main(String[] args) {
		String[] a = {"a","b","c"};
		String[] b = {"a","b","c"};
		String[] c = mergeArray(a, b);
		System.out.println(c);
	}
}
