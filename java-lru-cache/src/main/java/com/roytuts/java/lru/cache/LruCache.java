package com.roytuts.java.lru.cache;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LruCache<K, V> {

	// Capacity of LRUCache
	private final int capacity = 50;

	// Interval for testing existence of an object
	private final int sleepTime = 5000;

	// Current size of LRUCache
	private int currentSize;

	// Cache expire time
	private int expireTime;

	// Time unit like Seconds, Minutes, Hours etc.
	private TimeUnit timeUnit;

	// Node of DoublyLinkedList
	class DoublyLinkedListNode {
		DoublyLinkedListNode prev;
		DoublyLinkedListNode next;
		Date dateOfExpiration;
		K key;
		V value;

		public DoublyLinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
			dateOfExpiration = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dateOfExpiration);

			switch (timeUnit) {
			case MILLISECONDS:
				cal.add(Calendar.MILLISECOND, expireTime);
				break;
			case SECONDS:
				cal.add(Calendar.SECOND, expireTime);
				break;
			case MINUTES:
				cal.add(Calendar.MINUTE, expireTime);
				break;
			case HOURS:
				cal.add(Calendar.HOUR, expireTime);
				break;
			default:
				break;
			}

			dateOfExpiration = cal.getTime();
		}

		// check whether an object is expired or not
		public boolean isExpired() {
			if (dateOfExpiration != null) {
				if (dateOfExpiration.before(new Date())) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	// First node of DoublyLinkedList
	private DoublyLinkedListNode start;

	// Last node of DoublyLinkedList
	private DoublyLinkedListNode end;

	// Map for key and DoublyLinkedList node mapping
	private HashMap<K, DoublyLinkedListNode> nodeMap;

	public LruCache(int expireTime, TimeUnit timeUnit) {
		currentSize = 0;

		this.expireTime = expireTime;
		this.timeUnit = timeUnit;

		nodeMap = new HashMap<K, DoublyLinkedListNode>();

		Thread threadCleaner = new Thread(new Runnable() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void run() {
				List<K> deleteKey = null;

				try {
					while (true) {
						System.out.println("CacheCleaner scanning for expired objects...");
						synchronized (nodeMap) {
							deleteKey = new ArrayList<K>((nodeMap.size() / 2) + 1);
							Set keySet = nodeMap.keySet();
							Iterator keys = keySet.iterator();
							while (keys.hasNext()) {
								K key = (K) keys.next();
								DoublyLinkedListNode value = (DoublyLinkedListNode) nodeMap.get(key);
								if (value.isExpired()) {
									deleteKey.add(key);
									System.out.println("CacheCleaner Running. Found an expired object in the Cache : "
											+ value.value);
								}
							}
						}

						for (K key : deleteKey) {
							synchronized (nodeMap) {
								System.out.println("CacheCleaner removed an expired object from the Cache : "
										+ nodeMap.get(key).value);
								nodeMap.remove(key);
							}

							Thread.yield();
						}

						Thread.sleep(sleepTime);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		threadCleaner.setPriority(Thread.MIN_PRIORITY);
		threadCleaner.start();
	}

	// Add an item to LRUCache
	public void put(K key, V value) {
		synchronized (nodeMap) {
			if (nodeMap.containsKey(key)) {
				DoublyLinkedListNode node = nodeMap.get(key);
				node.value = value;
				bringItemToFront(node);
			} else {
				DoublyLinkedListNode nodeToInsert = new DoublyLinkedListNode(key, value);
				if (currentSize < capacity) {
					addItemToFront(nodeToInsert);
					currentSize++;
				} else {
					removeLastNode();
					addItemToFront(nodeToInsert);
				}
			}
		}
	}

	// Get an item from LRUCache
	public V get(K key) {
		synchronized (nodeMap) {
			if (nodeMap.containsKey(key)) {
				DoublyLinkedListNode node = nodeMap.get(key);
				bringItemToFront(node);
				return node.value;
			} else {
				return null;
			}
		}
	}

	// Remove last node from queue
	private void removeLastNode() {
		System.out.println("Capacity exceeded so removing oldest cache object " + end.value
				+ " for adding the new object to the cache");
		nodeMap.remove(end.key);
		end = end.prev;
		if (end != null) {
			end.next = null;
		}
	}

	// Add node in front of queue
	private void addItemToFront(DoublyLinkedListNode node) {
		node.next = start;
		node.prev = null;
		if (start != null) {
			start.prev = node;
		}
		start = node;
		if (end == null) {
			end = node;
		}
		nodeMap.put(node.key, node);
	}

	// Reorder existing node to front of queue
	private void bringItemToFront(DoublyLinkedListNode node) {
		DoublyLinkedListNode prevNode = node.prev;
		DoublyLinkedListNode nextNode = node.next;
		if (prevNode != null) {
			prevNode.next = nextNode;
		} else {
			start = nextNode;
		}
		if (nextNode != null) {
			nextNode.prev = prevNode;
		} else {
			end = prevNode;
		}
		addItemToFront(node);
	}

}
