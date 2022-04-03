package com.sb.hazelcast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.config.MetadataPolicy;

@Configuration
public class CacheConfig {

	@Bean
	public Config configure() {

		Config config = new Config();
		config.setInstanceName("hazlecast-insatnce");
		config.addMapConfig(getHazelcastMapConfig());

		return config;
	}

	private MapConfig getHazelcastMapConfig() {

		MapConfig mapConfig = new MapConfig();

		// Map Name Property

		mapConfig.setName("useraccountcache");

		// Map Backup Properties:

		mapConfig.setBackupCount(2); // it's default 1
		mapConfig.setAsyncBackupCount(1); // it's default 0

		// -----------------------------------------------------------

		// Map Expiration Properties:

		mapConfig.setMaxIdleSeconds(3600); // it will expire items if it is no write or read operation inside one hour.
		mapConfig.setTimeToLiveSeconds(3600); // it will expire items if it is no write operation inside one hour.

		// -----------------------------------------------------------

		// Map Eviction Properties:

		// This eviction config follows if one of the partition size exceeds 1000, it
		// evicts least recently used element from partition.

		EvictionConfig evictionConfig = new EvictionConfig();
		evictionConfig.setEvictionPolicy(EvictionPolicy.LRU); // You can use NONE,LRU or LFU.
		evictionConfig.setMaxSizePolicy(MaxSizePolicy.PER_PARTITION); // You can use PER_NODE,PER_PARTITION so on.
																		// Default is PER_NODE
		evictionConfig.setSize(1000);

		mapConfig.setEvictionConfig(evictionConfig);

		// -----------------------------------------------------------

		// Map Metadata Policy Property:

		mapConfig.setMetadataPolicy(MetadataPolicy.CREATE_ON_UPDATE); // It's default property is CREATE_ON_UPDATE.You
																		// can use OFF property to disable it.
		// It provides automatic pre-processing of various data types on update time to
		// make queries faster.
		// -----------------------------------------------------------

		// Map Read Back Up Data Property:

		mapConfig.setReadBackupData(false); // It's default property is false. It improves performance while it can
											// cause stale reads.

		/*
		 * mapConfig.addEntryListenerConfig( new EntryListenerConfig(
		 * "com.justayar.springboot.util.MapEntryListener", true, false ) );
		 */

		return mapConfig;
	}

}