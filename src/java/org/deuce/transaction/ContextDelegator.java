package org.deuce.transaction;

import org.deuce.objectweb.asm.Type;
import org.deuce.reflection.AddressUtil;
import org.deuce.transaction.Context;
import org.deuce.transaction.tl2.TransactionManagerImpl;
import org.deuce.transform.Exclude;

/**
 * Cluster static delegate methods.
 * These methods delegates calls from the dynamic generated code to the context.
 * 
 * 
 * @author	Guy Korland
 * @since	1.0
 *
 */
public class ContextDelegator {

	final static public String CONTEXT_DELEGATOR_INTERNAL = Type.getInternalName(ContextDelegator.class);
	
	final static public String BEFORE_READ_METHOD_NAME = "beforeReadAccess";
	final static public String BEFORE_READ_METHOD_DESC = "(Ljava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static public String IRREVOCABLE_METHOD_NAME = "onIrrevocableAccess";
	final static public String IRREVOCABLE_METHOD_DESC = "(" + Context.CONTEXT_DESC + ")V";
	
	
	final static public String WRITE_METHOD_NAME = "onWriteAccess";
	final static public String WRITE_ARR_METHOD_NAME = "onArrayWriteAccess";
	final static public String STATIC_WRITE_METHOD_NAME = "addStaticWriteAccess";
	final static public String READ_METHOD_NAME = "onReadAccess";
	final static public String READ_ARR_METHOD_NAME = "onArrayReadAccess";

	final static private String WRITE_METHOD_BOOLEAN_DESC = "(Ljava/lang/Object;ZJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_BYTE_DESC = "(Ljava/lang/Object;BJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_CHAR_DESC = "(Ljava/lang/Object;CJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_SHORT_DESC = "(Ljava/lang/Object;SJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_INT_DESC = "(Ljava/lang/Object;IJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_LONG_DESC = "(Ljava/lang/Object;JJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_FLOAT_DESC = "(Ljava/lang/Object;FJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_DOUBLE_DESC = "(Ljava/lang/Object;DJI" + Context.CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;JI" + Context.CONTEXT_DESC +")V";

	final static private String STATIC_WRITE_METHOD_BOOLEAN_DESC = "(ZLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_BYTE_DESC = "(BLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_CHAR_DESC = "(CLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_SHORT_DESC = "(SLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_INT_DESC = "(ILjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_LONG_DESC = "(JLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_FLOAT_DESC = "(FLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_DOUBLE_DESC = "(DLjava/lang/Object;JI" + Context.CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;JI" + Context.CONTEXT_DESC +")V";

	final static private String READ_METHOD_BOOLEAN_DESC = "(Ljava/lang/Object;ZJI" + Context.CONTEXT_DESC +")Z";
	final static private String READ_METHOD_BYTE_DESC = "(Ljava/lang/Object;BJI" + Context.CONTEXT_DESC +")B";
	final static private String READ_METHOD_CHAR_DESC = "(Ljava/lang/Object;CJI" + Context.CONTEXT_DESC +")C";
	final static private String READ_METHOD_SHORT_DESC = "(Ljava/lang/Object;SJI" + Context.CONTEXT_DESC +")S";
	final static private String READ_METHOD_INT_DESC = "(Ljava/lang/Object;IJI" + Context.CONTEXT_DESC +")I";
	final static private String READ_METHOD_LONG_DESC = "(Ljava/lang/Object;JJI" + Context.CONTEXT_DESC +")J";
	final static private String READ_METHOD_FLOAT_DESC = "(Ljava/lang/Object;FJI" + Context.CONTEXT_DESC +")F";
	final static private String READ_METHOD_DOUBLE_DESC = "(Ljava/lang/Object;DJI" + Context.CONTEXT_DESC +")D";
	final static private String READ_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;JI" + Context.CONTEXT_DESC +")Ljava/lang/Object;";

	final static public String WRITE_ARRAY_METHOD_BYTE_DESC = "([BIBI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_CHAR_DESC = "([CICI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_SHORT_DESC = "([SISI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_INT_DESC = "([IIII" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_LONG_DESC = "([JIJI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_FLOAT_DESC = "([FIFI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_DOUBLE_DESC = "([DIDI" + Context.CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_OBJ_DESC = "([Ljava/lang/Object;ILjava/lang/Object;I" + Context.CONTEXT_DESC +")V";

	final static public String READ_ARRAY_METHOD_BYTE_DESC = "([BII" + Context.CONTEXT_DESC +")B";
	final static public String READ_ARRAY_METHOD_CHAR_DESC = "([CII" + Context.CONTEXT_DESC +")C";
	final static public String READ_ARRAY_METHOD_SHORT_DESC = "([SII" + Context.CONTEXT_DESC +")S";
	final static public String READ_ARRAY_METHOD_INT_DESC = "([III" + Context.CONTEXT_DESC +")I";
	final static public String READ_ARRAY_METHOD_LONG_DESC = "([JII" + Context.CONTEXT_DESC +")J";
	final static public String READ_ARRAY_METHOD_FLOAT_DESC = "([FII" + Context.CONTEXT_DESC +")F";
	final static public String READ_ARRAY_METHOD_DOUBLE_DESC = "([DII" + Context.CONTEXT_DESC +")D";
	final static public String READ_ARRAY_METHOD_OBJ_DESC = "([Ljava/lang/Object;II" + Context.CONTEXT_DESC +")Ljava/lang/Object;";


	final static private int BYTE_ARR_BASE = AddressUtil.arrayBaseOffset(byte[].class);
	final static private int CHAR_ARR_BASE = AddressUtil.arrayBaseOffset(char[].class);
	final static private int SHORT_ARR_BASE = AddressUtil.arrayBaseOffset(short[].class);
	final static private int INT_ARR_BASE = AddressUtil.arrayBaseOffset(int[].class);
	final static private int LONG_ARR_BASE = AddressUtil.arrayBaseOffset(long[].class);
	final static private int FLOAT_ARR_BASE = AddressUtil.arrayBaseOffset(float[].class);
	final static private int DOUBLE_ARR_BASE = AddressUtil.arrayBaseOffset(double[].class);
	final static private int OBJECT_ARR_BASE = AddressUtil.arrayBaseOffset(Object[].class);

	final static private int BYTE_ARR_SCALE = AddressUtil.arrayIndexScale(byte[].class);
	final static private int CHAR_ARR_SCALE = AddressUtil.arrayIndexScale(char[].class);
	final static private int SHORT_ARR_SCALE = AddressUtil.arrayIndexScale(short[].class);
	final static private int INT_ARR_SCALE = AddressUtil.arrayIndexScale(int[].class);
	final static private int LONG_ARR_SCALE = AddressUtil.arrayIndexScale(long[].class);
	final static private int FLOAT_ARR_SCALE = AddressUtil.arrayIndexScale(float[].class);
	final static private int DOUBLE_ARR_SCALE = AddressUtil.arrayIndexScale(double[].class);
	final static private int OBJECT_ARR_SCALE = AddressUtil.arrayIndexScale(Object[].class);


	final private static ContextThreadLocal THREAD_CONTEXT = new ContextThreadLocal();
	
 	final static public TransactionManager transactionManager;  
	static{
		String className = System.getProperty( "org.deuce.transaction.transactionManagerClass", TransactionManagerImpl.class.getName());
		TransactionManager tempManager = null;
		try {
			Class managerClass = Class.forName(className);
			tempManager = (TransactionManager) managerClass.newInstance();
		} catch (Exception e) {
			throw new TransactionException( e);
		}
		finally{
			transactionManager = tempManager;
		}
	}

	@Exclude
	private static class ContextThreadLocal extends ThreadLocal<Context>
	{
		@Override
		protected synchronized Context initialValue() {
			try {
				return transactionManager.createContext();
			} catch (Exception e) {
				throw new TransactionException( e);
			}
		}
	}

	public static Context getInstance(){
		return THREAD_CONTEXT.get();
	}

	public static String getWriteMethodDesc( Type type) {
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return WRITE_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return WRITE_METHOD_BYTE_DESC;
		case Type.CHAR:
			return WRITE_METHOD_CHAR_DESC;
		case Type.SHORT:
			return WRITE_METHOD_SHORT_DESC;
		case Type.INT:
			return WRITE_METHOD_INT_DESC;
		case Type.LONG:
			return WRITE_METHOD_LONG_DESC;
		case Type.FLOAT:
			return WRITE_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return WRITE_METHOD_DOUBLE_DESC;
		default:
			return WRITE_METHOD_OBJ_DESC;
		}
	}

	public static String getStaticWriteMethodDesc( Type type) {
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return STATIC_WRITE_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return STATIC_WRITE_METHOD_BYTE_DESC;
		case Type.CHAR:
			return STATIC_WRITE_METHOD_CHAR_DESC;
		case Type.SHORT:
			return STATIC_WRITE_METHOD_SHORT_DESC;
		case Type.INT:
			return STATIC_WRITE_METHOD_INT_DESC;
		case Type.LONG:
			return STATIC_WRITE_METHOD_LONG_DESC;
		case Type.FLOAT:
			return STATIC_WRITE_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return STATIC_WRITE_METHOD_DOUBLE_DESC;
		default:
			return STATIC_WRITE_METHOD_OBJ_DESC;
		}
	}

	public static String getReadMethodDesc( Type type) {
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return READ_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return READ_METHOD_BYTE_DESC;
		case Type.CHAR:
			return READ_METHOD_CHAR_DESC;
		case Type.SHORT:
			return READ_METHOD_SHORT_DESC;
		case Type.INT:
			return READ_METHOD_INT_DESC;
		case Type.LONG:
			return READ_METHOD_LONG_DESC;
		case Type.FLOAT:
			return READ_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return READ_METHOD_DOUBLE_DESC;
		default:
			return READ_METHOD_OBJ_DESC;
		}
	}


	static public void beforeReadAccess( Object obj, long field, int advice, Context context) {
		context.beforeReadAccess(obj, field, advice);
	}

	static public Object onReadAccess( Object obj, Object value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public boolean onReadAccess( Object obj, boolean value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public byte onReadAccess( Object obj, byte value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public char onReadAccess( Object obj, char value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public short onReadAccess( Object obj, short value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public int onReadAccess( Object obj, int value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public long onReadAccess( Object obj, long value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public float onReadAccess( Object obj, float value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}
	static public double onReadAccess( Object obj, double value, long field, int advice, Context context) {
		return context.onReadAccess(obj, value, field, advice);
	}

	static public void onWriteAccess( Object obj, Object value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, boolean value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, byte value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, char value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, short value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, int value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, long value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, float value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void onWriteAccess( Object obj, double value, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}

	static public void addStaticWriteAccess( Object value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( boolean value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( byte value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( char value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( short value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( int value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( long value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( float value, Object obj, long field, int advice, Context context) {
		context.onWriteAccess(obj, value, field, advice);
	}
	static public void addStaticWriteAccess( double value, Object obj, long field, int advice, Context context) { 
		context.onWriteAccess(obj, value, field, advice);
	}

	static public Object onArrayReadAccess( Object[] arr, int index, int advice, Context context) {
		int address = OBJECT_ARR_BASE + OBJECT_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public byte onArrayReadAccess( byte[] arr, int index, int advice, Context context) {
		int address = BYTE_ARR_BASE + BYTE_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public char onArrayReadAccess( char[] arr, int index, int advice, Context context) {
		int address = CHAR_ARR_BASE + CHAR_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public short onArrayReadAccess( short[] arr, int index, int advice, Context context) {
		int address = SHORT_ARR_BASE + SHORT_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public int onArrayReadAccess( int[] arr, int index, int advice, Context context) {
		int address = INT_ARR_BASE + INT_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public long onArrayReadAccess( long[] arr, int index, int advice, Context context) {
		int address = LONG_ARR_BASE + LONG_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public float onArrayReadAccess( float[] arr, int index, int advice, Context context) {
		int address = FLOAT_ARR_BASE + FLOAT_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	static public double onArrayReadAccess( double[] arr, int index, int advice, Context context) {
		int address = DOUBLE_ARR_BASE + DOUBLE_ARR_SCALE*index;
		context.beforeReadAccess(arr, address, advice);
		return context.onReadAccess(arr, arr[index], address, advice);
	}
	
	static public <T> void onArrayWriteAccess( T[] arr,  int index, T value, int advice, Context context) {
		T t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, OBJECT_ARR_BASE + OBJECT_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( byte[] arr, int index, byte value, int advice, Context context) {
		byte t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, BYTE_ARR_BASE + BYTE_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( char[] arr, int index, char value, int advice, Context context) {
		char t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, CHAR_ARR_BASE + CHAR_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( short[] arr, int index, short value, int advice, Context context) {
		short t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, SHORT_ARR_BASE + SHORT_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( int[] arr, int index, int value, int advice, Context context) {
		int t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, INT_ARR_BASE + INT_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( long[] arr, int index, long value, int advice, Context context) {
		long t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, LONG_ARR_BASE + LONG_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( float[] arr, int index, float value, int advice, Context context) {
		float t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, FLOAT_ARR_BASE + FLOAT_ARR_SCALE*index, advice);
	}
	static public void onArrayWriteAccess( double[] arr, int index, double value, int advice, Context context) {
		double t = arr[index]; // dummy access just to check the index in range
		context.onWriteAccess(arr, value, DOUBLE_ARR_BASE + DOUBLE_ARR_SCALE*index, advice);
	}
			
	static public void onIrrevocableAccess(Context context) {
		context.onIrrevocableAccess();
	}
	
}
