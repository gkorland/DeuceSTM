package org.deuce.transaction.tl2cm;

import org.deuce.transaction.tl2.field.ReadFieldAccess;
import org.deuce.transform.Exclude;

/**
 * Represents the transaction read set.
 * And acts as a recycle pool of the {@link ReadFieldAccess}.
 *  
 * @author Guy Korland
 * @since 0.7
 */
@Exclude
public class ReadSet{
	
	private static final int DEFAULT_CAPACITY = 1024;
	private ReadFieldAccess[] readSet = new ReadFieldAccess[DEFAULT_CAPACITY];
	private int nextAvaliable = 0;
	private ReadFieldAccess currentReadFieldAccess = null;
	
	public ReadSet(){
		fillArray( 0);
	}
	
	public void clear() {
		for (int i = 0; i < nextAvaliable; i++) {
			readSet[i].clear();
		}
		nextAvaliable = 0;
	}

	private void fillArray( int offset){
		for( int i=offset ; i < readSet.length ; ++i){
			readSet[i] = new ReadFieldAccess();
		}
	}

	public ReadFieldAccess getNext() {
		if( nextAvaliable >= readSet.length){
			int orignLength = readSet.length;
			ReadFieldAccess[] tmpReadSet = new ReadFieldAccess[ 2*orignLength];
			System.arraycopy(readSet, 0, tmpReadSet, 0, orignLength);
			readSet = tmpReadSet;
			fillArray( orignLength);
		}
		currentReadFieldAccess = readSet[ nextAvaliable++];
		return currentReadFieldAccess;
	}
	
	public ReadFieldAccess getCurrent(){
		return currentReadFieldAccess;
	}
	
    public boolean isConsistent(int version) {
        for (int i = 0; i < nextAvaliable; i++) {
        	int hash = readSet[i].hashCode();
        	long lock = LockTable.getLock(hash);
        	int lockVersion = LockTable.getVersion(lock);
        	if (lockVersion > version) {
        		return false;
        	}
        }
        return true;
    }
    
    public int size() {
    	return nextAvaliable-1;
    }
    
    public interface ReadSetListener{
    	void execute( ReadFieldAccess read);
    }
	
}
