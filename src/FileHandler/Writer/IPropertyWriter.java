package FileHandler.Writer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IPropertyWriter {
	public boolean WriteToReport() default true;
	public boolean WriteToDB() default false;
	public String FieldName() default "";
}
