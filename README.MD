# what
2 parts are in this demo.
1. how to config hazelcast in Spring
2. how to config cache in Spring

# hazelcast
you can use hazelcast to sync data between different apps or app instances.  
you can use hazelcast to cache data as well.  

to use hazelcast you need to:  
1. in pom:
'''

   	<dependency>
   		<groupId>com.hazelcast</groupId>
   		<artifactId>hazelcast</artifactId>
   		<version>${hazelcast.version}</version>
   	</dependency>
'''
2. config, see suny.example.hazelcast.config.HazelCastConfiguration#hazelcastLocalConfig  
there are two ways to cluster/deploy hazelcast. A the embedded way or B the client/server way.  
see https://docs.hazelcast.com/imdg/4.2/overview/topology  
by the embedded way the hazelcast service is distributed in applications and it is the way in this demo.  
there are 3 options for hc service discovery: 1 TCP, 2 broadcast, 3 kubernetes  
2.1 TCP: the app find the hc service on some TCP address (of a service member).  
2.2 broadcast: send discovery message to all members  
2.3 kubernetes: leave kubernetes service discovery to do the magic,   
deploy the hazelcastservice.yaml to your kubernetes cluster and see example config in   
suny.example.hazelcast.config.HazelCastConfiguration#hazelcastLocalConfig comments   
3. run this app and you will like this msg in console:  
'''

Members {size:1, ver:1} [ Member [localhost]:5701 - 2d2be2cf-5d11-450a-b345-5e8921eb1f0c this ]
[           main] c.h.internal.cluster.ClusterService      : [localhost]:5701 [dev] [5.5.0]
Members {size:1, ver:1} [ Member [localhost]:5701 - 2d2be2cf-5d11-450a-b345-5e8921eb1f0c this ]
'''

# spring cache
when to use cache?  
if you get some data form some very slow services and this low your performance,  
you can cache the data and pre cache the data to improve your app performance  
## how
1. enable caching @EnableCaching  
2. config CacheManager, see config class suny.example.hazelcast.config.CachingConfig#cacheManager   
qualify the Hazelcast bean with @Qualifier("hazelcastInstance")  
3. test with and have fun   
   http://localhost:8899/weather/hometown   
   http://localhost:8899/cache/size   
