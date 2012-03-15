package org.deuce.transaction.tl2.field;

import org.deuce.reflection.UnsafeHolder;
import org.deuce.transform.Exclude;

@Exclude
public class LongWriteFieldAccess extends WriteFieldAccess {

	private long value;

	public void set(long value, Object reference, long field, int advice) {
		super.init(reference, field, advice);
		this.value = value;
	}

	@Override
	public void put() {
		UnsafeHolder.getUnsafe().putLong(reference, field, value);
		clear();
	}

	public long getValue() {
		return value;
	}

}
