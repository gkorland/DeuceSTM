package org.deuce.transaction.tl2.field;

import org.deuce.transaction.tl2.LockTable;
import org.deuce.transform.Exclude;
import org.deuce.trove.TLinkableAdapter;

/**
 * Represents a base class for field write access.  
 * @author Guy Koralnd
 */
@Exclude
public class ReadFieldAccess extends TLinkableAdapter{
	@Override
	public String toString() {
		return "ReadFieldAccess [advice=" + advice + ", field=" + field
				+ ", hash=" + hash + ", reference=" + reference + "]";
	}

	protected Object reference;
	protected long field;
	private int hash;
	private int advice;

	public ReadFieldAccess(){}
	
	public ReadFieldAccess( Object reference, long field, int advice){
		init(reference, field, advice);
	}
	
	public void init( Object reference, long field, int advice){
		this.reference = reference;
		this.field = field;
		this.hash = (System.identityHashCode( reference) + (int)field) & LockTable.MASK;
		this.advice = advice;
	}

	@Override
	public boolean equals( Object obj){
		ReadFieldAccess other = (ReadFieldAccess)obj;
		return reference == other.reference && field == other.field;
	}

	@Override
	final public int hashCode(){
		return hash;
	}
	
	public int getAdvice(){
		return advice;
	}

	public void clear(){
		reference = null;
	}
}