package org.deuce.transaction.tl2;

import java.util.HashMap;
import java.util.Iterator;

import org.deuce.transaction.tl2.field.ReadFieldAccess;
import org.deuce.transaction.tl2.field.WriteFieldAccess;

/**
 * Represents the transaction write set.
 *  
 * @author Guy Korland
 * @since 0.7
 */
public class WriteSet implements Iterable<WriteFieldAccess>{
	
	final private HashMap<WriteFieldAccess,WriteFieldAccess> writeSet = new HashMap<WriteFieldAccess,WriteFieldAccess>( 50);
	final private BloomFilter bloomFilter = new BloomFilter();
	
	public void clear() {
		bloomFilter.clear();
		writeSet.clear();
	}

	public boolean isEmpty() {
		return writeSet.isEmpty();
	}

	public Iterator<WriteFieldAccess> iterator() {
		// Use the value and not the key since the key might hold old key.
		// Might happen if the same field was update more than once.
		return writeSet.values().iterator();
	}

	public void put(WriteFieldAccess write) {
		// Add to bloom filter
		bloomFilter.add( write.hashCode());

		// Add to write set
		writeSet.put( write, write);
	}
	
	public WriteFieldAccess contains(ReadFieldAccess read) {
		// Check if it is already included in the write set
		return bloomFilter.contains(read.hashCode()) ? writeSet.get( read): null;
	}
}