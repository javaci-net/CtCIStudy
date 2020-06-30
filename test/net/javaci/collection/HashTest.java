package net.javaci.collection;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import net.javaci.collection.hash.Hash;
import net.javaci.collection.hash.SimpleHash;

public class HashTest {
	
	@Test
	public void test() {
		Hash<String> hash = new SimpleHash<>();
		
		hash.add("istanbul");
		hash.add("ankara");
		hash.add("izmir");
		hash.add("antalya");
		hash.add("canakkale");
		
		assertTrue(hash.contains("antalya"));
	}
}
