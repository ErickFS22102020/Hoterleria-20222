package hoteleria.cheraton.metodos;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class General {
	
	public static boolean compararListaArrays(List<String[]> lista1,List<String[]> lista2)
	{
		if (lista1.size() != lista2.size()) return false;
		for(int i = 0; lista1.size() > i ; i++)
		{
			if(lista1.get(i).length != lista2.get(i).length) return false;
			
			for(int j = 0; lista1.get(i).length > j; j++)
			{
				if(! lista1.get(i)[j].equals(lista2.get(i)[j])) return false;
			}
		}
		return true;
	}
	
	public static boolean compararArrays(String[] array1,String[] array2)
	{
		if (array1.length != array2.length) return false;
		for(int i = 0; array1.length > i ; i++)
		{
			if(! array1[i].equals(array2[i])) return false;
		}
		return true;
	}
	
	public static boolean contieneArrayEnLista(List<String[]> lista, String[] array)
	{
		for(String [] i : lista)
		{
			if(compararArrays(i, array)) return true;
		}
		return false;
	}
	public static void removerArrayEnLista(List<String[]> lista, String[] array)
	{
		for(int i = 0; lista.size() > i ; i++)
		{
			if(compararArrays(lista.get(i), array)) lista.remove(i);
		}
	}
	
	public static String encriptarPassword(String password)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	public static void logProperties(Object object) throws IllegalArgumentException, IllegalAccessException {
		  Class<?> aClass = object.getClass();
		  Field[] declaredFields = aClass.getDeclaredFields();
		  Map<String, String> logEntries = new HashMap<>();

		  for (Field field : declaredFields) {
		    field.setAccessible(true);

		    Object[] arguments = new Object[]{
		      field.getName(),
		      field.getType().getSimpleName(),
		      String.valueOf(field.get(object))
		    };

		    String template = "- Property: {0} (Type: {1}, Value: {2})";
		    String logMessage = System.getProperty("line.separator")
		            + MessageFormat.format(template, arguments);

		    logEntries.put(field.getName(), logMessage);
		  }

		  SortedSet<String> sortedLog = new TreeSet<>(logEntries.keySet());

		  StringBuilder sb = new StringBuilder("Class properties:");

		  Iterator<String> it = sortedLog.iterator();
		  while (it.hasNext()) {
		    String key = it.next();
		    sb.append(logEntries.get(key));
		  }

		  System.out.println(sb.toString());
		}
	
	public static void main(String[] args)
	{

	}
}
