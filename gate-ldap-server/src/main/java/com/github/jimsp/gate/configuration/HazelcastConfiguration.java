package com.github.jimsp.gate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Configuration("hazelcastConfiguration")
public class HazelcastConfiguration {
	
	@Bean
	public HazelcastInstance hazelcastInstance() {
		return Hazelcast.getOrCreateHazelcastInstance(hazelcastConfig());
	}
	
	@Bean("userCanonicoStore")
	public IMap<String, UserCanonico> userCanonicoStore(){
		return hazelcastInstance().getMap("userCanonicoStore");
	}
	
	private Config hazelcastConfig() {
		final Config config = new Config("ldapGate");
		config.addMapConfig(userCanonicoStoreMapConfig());
		return config;
	}

	private MapConfig userCanonicoStoreMapConfig() {
		return new MapConfig("userCanonicoStore");
	}
}
