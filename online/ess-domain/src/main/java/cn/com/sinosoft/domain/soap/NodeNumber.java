package cn.com.sinosoft.domain.soap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NodeNumber {
	public boolean isShowNumber() default false;
	public String nodeName() default "total";
}
