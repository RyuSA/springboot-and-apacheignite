# Springboot and ApacheIgnite

this is an example repository.


## Bootrun

before application boot, you want to run Apache ignite cluster.

```bash
cd middleware
docker-compose up
```

then you can boot the application.

```bash
# on Windows
./gradlew.bat bootrun
# Ubuntu/Mac
./gradlew bootrun
```

## Known problem

The application cannot boot on Windows since the application cannot connect to Apache ignite cluster.(below)

<pre>
2020-10-02 09:19:21.486  INFO 13816 --- [           main] o.a.i.i.IgniteKernal%MYCOM     : Non-loopback local IPs: 10.206.153.190, 169.254.0.174, 169.254.30.6, 172.18.70.145, 192.168.178.55, 2001:240:168:a05c:0:0:1:1c9b, fe80:0:0:0:69a2:c469:3d0a:1e06%eth10, fe80:0:0:0:8027:217a:809:408f%eth21, fe80:0:0:0:aca5:6390:b21d:acde%eth4, fe80:0:0:0:f871:7a55:ce89:ff4e%eth0
2020-10-02 09:19:21.487  INFO 13816 --- [           main] o.a.i.i.IgniteKernal%MYCOM     : Enabled local MACs: 00155DCEB121, 00FF61B2D2ED, 021551CE7882, 10E7C64164B7
2020-10-02 09:19:29.463  INFO 13816 --- [         MYCOM%] o.a.i.spi.discovery.tcp.TcpDiscoverySpi  : Router node: TcpDiscoveryNode [id=417f78d6-cf14-47e7-a6c2-ab742cba670c, consistentId=127.0.0.1,172.18.0.2:47500, addrs=ArrayList [127.0.0.1, 172.18.0.2], sockAddrs=HashSet [/172.18.0.2:47500, /127.0.0.1:47500], discPort=47500, order=2, intOrder=2, lastExchangeTime=1601597967193, loc=false, ver=2.8.1#20200521-sha1:86422096, isClient=false]
2020-10-02 09:19:29.480  INFO 13816 --- [         MYCOM%] a.i.i.c.DistributedBaselineConfiguration : Baseline parameter 'baselineAutoAdjustEnabled' was changed from 'null' to 'true'
2020-10-02 09:19:29.481  INFO 13816 --- [         MYCOM%] a.i.i.c.DistributedBaselineConfiguration : Baseline parameter 'baselineAutoAdjustTimeout' was changed from 'null' to '0'
2020-10-02 09:19:29.482  INFO 13816 --- [         MYCOM%] o.a.i.i.p.query.h2.IgniteH2Indexing      : SQL parameter 'sql.disabledFunctions' was changed from 'null' to '[FILE_WRITE, CANCEL_SESSION, MEMORY_USED, CSVREAD, LINK_SCHEMA, MEMORY_FREE, FILE_READ, CSVWRITE, SESSION_ID, LOCK_MODE]'
2020-10-02 09:19:29.492  INFO 13816 --- [         MYCOM%] o.a.i.i.p.c.GridClusterStateProcessor    : Received activate request with BaselineTopology[id=0]
2020-10-02 09:19:29.493  WARN 13816 --- [         MYCOM%] o.a.i.i.p.c.GridClusterStateProcessor    : Received state finish message with unexpected ID: ChangeGlobalStateFinishMessage [id=68a6da6e471-0f01a2f6-eec9-4b6a-8419-ba2d834f9f07, reqId=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, clusterActive=true, transitionRes=true]
2020-10-02 09:19:29.494  INFO 13816 --- [         MYCOM%] o.a.i.i.p.cache.mvcc.MvccProcessorImpl   : Assigned mvcc coordinator [crd=MvccCoordinator [topVer=AffinityTopologyVersion [topVer=3, minorTopVer=0], nodeId=0651ab2b-4ce3-47cd-8bd5-1455834f580d, ver=1601597521524, local=false, initialized=false]]
2020-10-02 09:19:29.504  WARN 13816 --- [           main] o.a.i.i.m.d.GridDiscoveryManager         : Local java version is different from remote [loc=11, rmt=8]
2020-10-02 09:19:29.542  INFO 13816 --- [         MYCOM%] o.apache.ignite.internal.exchange.time   : Started exchange init [topVer=AffinityTopologyVersion [topVer=3, minorTopVer=0], crd=false, evt=NODE_JOINED, evtNode=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, customEvt=null, allowMerge=true, exchangeFreeSwitch=false]
2020-10-02 09:19:29.543  INFO 13816 --- [         MYCOM%] org.apache.ignite.cache.msg              : Components activation performed in 0 ms.
2020-10-02 09:19:29.624  INFO 13816 --- [         MYCOM%] o.a.i.i.p.cache.GridCacheProcessor       : Started cache [name=ignite-sys-cache, id=-2100569601, dataRegionName=sysMemPlc, mode=REPLICATED, atomicity=TRANSACTIONAL, backups=2147483647, mvcc=false]
2020-10-02 09:19:29.625  INFO 13816 --- [         MYCOM%] o.a.i.i.p.cache.GridCacheProcessor       : Starting caches on local join performed in 84 ms.
2020-10-02 09:19:39.632  WARN 13816 --- [         MYCOM%] o.a.i.s.c.tcp.TcpCommunicationSpi        : Connection timed out (will stop attempts to perform the connect) [node=0651ab2b-4ce3-47cd-8bd5-1455834f580d, connTimeoutStgy=ExponentialBackoffTimeoutStrategy [maxTimeout=600000, totalTimeout=10000, startNanos=780146404389800, currTimeout=16000], failureDetectionTimeoutEnabled=true, timeout=1122, err=null, addr=/172.18.0.3:47100]
2020-10-02 09:19:39.639 ERROR 13816 --- [         MYCOM%] o.a.i.s.c.tcp.TcpCommunicationSpi        : Failed to send message to remote node [node=TcpDiscoveryNode [id=0651ab2b-4ce3-47cd-8bd5-1455834f580d, consistentId=127.0.0.1,172.18.0.3:47500, addrs=ArrayList [127.0.0.1, 172.18.0.3], sockAddrs=HashSet [/127.0.0.1:47500, /172.18.0.3:47500], discPort=47500, order=1, intOrder=1, lastExchangeTime=1601597964935, loc=false, ver=2.8.1#20200521-sha1:86422096, isClient=false], msg=GridIoMessage [plc=2, topic=TOPIC_CACHE, topicOrd=8, ordered=false, timeout=0, skipOnTimeout=false, msg=GridDhtPartitionsSingleMessage [parts=null, partCntrs=null, partsSizes=null, partHistCntrs=null, err=null, client=true, exchangeStartTime=780146272658700, finishMsg=null, super=GridDhtPartitionsAbstractMessage [exchId=GridDhtPartitionExchangeId [topVer=AffinityTopologyVersion [topVer=3, minorTopVer=0], discoEvt=DiscoveryEvent [evtNode=TcpDiscoveryNode [id=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, consistentId=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, addrs=ArrayList [0:0:0:0:0:0:0:1, 10.206.153.190, 127.0.0.1, 172.18.70.145, 192.168.178.55, 2001:240:168:a05c:0:0:1:1c9b], sockAddrs=HashSet [/10.206.153.190:0, /0:0:0:0:0:0:0:1:0, /127.0.0.1:0, MYCOM.mshome.net/172.18.70.145:0, MYCOM/169.254.30.6:0, /2001:240:168:a05c:0:0:1:1c9b:0, /192.168.178.55:0], discPort=0, order=3, intOrder=0, lastExchangeTime=1601597961492, loc=true, ver=2.8.1#20200521-sha1:86422096, isClient=true], topVer=3, nodeId8=dbfcec0a, msg=null, type=NODE_JOINED, tstamp=1601597969493], nodeId=dbfcec0a, evt=NODE_JOINED], lastVer=GridCacheVersion [topVer=0, order=1601597960490, nodeOrder=0], super=GridCacheMessage [msgId=1, depInfo=null, lastAffChangedTopVer=AffinityTopologyVersion [topVer=-1, minorTopVer=0], err=null, skipPrepare=false]]]]]

org.apache.ignite.IgniteCheckedException: Failed to connect to node (is node still alive?). Make sure that each ComputeTask and cache Transaction has a timeout set in order to prevent parties from waiting forever in
case of network issues [nodeId=0651ab2b-4ce3-47cd-8bd5-1455834f580d, addrs=[/172.18.0.3:47100, /127.0.0.1:47100]]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createNioSession(TcpCommunicationSpi.java:3738) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createTcpClient(TcpCommunicationSpi.java:3458) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createCommunicationClient(TcpCommunicationSpi.java:3198) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.reserveClient(TcpCommunicationSpi.java:3078) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.sendMessage0(TcpCommunicationSpi.java:2918) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.sendMessage(TcpCommunicationSpi.java:2877) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.managers.communication.GridIoManager.send(GridIoManager.java:2035) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.managers.communication.GridIoManager.sendToGridTopic(GridIoManager.java:2132) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCacheIoManager.send(GridCacheIoManager.java:1257) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.sendLocalPartitions(GridDhtPartitionsExchangeFuture.java:2020) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.clientOnlyExchange(GridDhtPartitionsExchangeFuture.java:1436) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.init(GridDhtPartitionsExchangeFuture.java:903) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCachePartitionExchangeManager$ExchangeWorker.body0(GridCachePartitionExchangeManager.java:3214) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCachePartitionExchangeManager$ExchangeWorker.body(GridCachePartitionExchangeManager.java:3063) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.util.worker.GridWorker.run(GridWorker.java:120) ~[ignite-core-2.8.1.jar:2.8.1]
        at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: java.net.SocketTimeoutException: null
        at java.base/sun.nio.ch.SocketAdaptor.connect(SocketAdaptor.java:129) ~[na:na]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createNioSession(TcpCommunicationSpi.java:3584) ~[ignite-core-2.8.1.jar:2.8.1]
        ... 15 common frames omitted

2020-10-02 09:19:49.543  WARN 13816 --- [           main] .i.p.c.GridCachePartitionExchangeManager : Failed to wait for initial partition map exchange. Possible reasons are:
  ^-- Transactions in deadlock.
  ^-- Long running transactions (ignore if this is the case).
  ^-- Unreleased explicit locks.
2020-10-02 09:19:52.908  WARN 13816 --- [         MYCOM%] o.a.i.s.c.tcp.TcpCommunicationSpi        : Connection timed out (will stop attempts to perform the connect) [node=0651ab2b-4ce3-47cd-8bd5-1455834f580d, connTimeoutStgy=ExponentialBackoffTimeoutStrategy [maxTimeout=600000, totalTimeout=10000, startNanos=780159679444300, currTimeout=16000], failureDetectionTimeoutEnabled=true, timeout=1178, err=null, addr=/172.18.0.3:47100]
2020-10-02 09:19:52.909 ERROR 13816 --- [         MYCOM%] o.a.i.s.c.tcp.TcpCommunicationSpi        : Failed to send message to remote node [node=TcpDiscoveryNode [id=0651ab2b-4ce3-47cd-8bd5-1455834f580d, consistentId=127.0.0.1,172.18.0.3:47500, addrs=ArrayList [127.0.0.1, 172.18.0.3], sockAddrs=HashSet [/127.0.0.1:47500, /172.18.0.3:47500], discPort=47500, order=1, intOrder=1, lastExchangeTime=1601597964935, loc=false, ver=2.8.1#20200521-sha1:86422096, isClient=false], msg=GridIoMessage [plc=2, topic=TOPIC_CACHE, topicOrd=8, ordered=false, timeout=0, skipOnTimeout=false, msg=GridDhtPartitionsSingleMessage [parts=null, partCntrs=null, partsSizes=null, partHistCntrs=null, err=null, client=true, exchangeStartTime=780146272658700, finishMsg=null, super=GridDhtPartitionsAbstractMessage [exchId=GridDhtPartitionExchangeId [topVer=AffinityTopologyVersion [topVer=3, minorTopVer=0], discoEvt=DiscoveryEvent
[evtNode=TcpDiscoveryNode [id=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, consistentId=dbfcec0a-8b1a-4273-b818-6a7d2f0a67d5, addrs=ArrayList [0:0:0:0:0:0:0:1, 10.206.153.190, 127.0.0.1, 172.18.70.145, 192.168.178.55, 2001:240:168:a05c:0:0:1:1c9b], sockAddrs=HashSet [/10.206.153.190:0, /0:0:0:0:0:0:0:1:0, /127.0.0.1:0, MYCOM.mshome.net/172.18.70.145:0, MYCOM/169.254.30.6:0, /2001:240:168:a05c:0:0:1:1c9b:0, /192.168.178.55:0], discPort=0, order=3, intOrder=0, lastExchangeTime=1601597961492, loc=true, ver=2.8.1#20200521-sha1:86422096, isClient=true], topVer=3, nodeId8=dbfcec0a, msg=null, type=NODE_JOINED, tstamp=1601597969493], nodeId=dbfcec0a, evt=NODE_JOINED], lastVer=GridCacheVersion [topVer=0, order=1601597960490, nodeOrder=0], super=GridCacheMessage [msgId=1, depInfo=null, lastAffChangedTopVer=AffinityTopologyVersion [topVer=-1, minorTopVer=0], err=null, skipPrepare=false]]]]]

org.apache.ignite.IgniteCheckedException: Failed to connect to node (is node still alive?). Make sure that each ComputeTask and cache Transaction has a timeout set in order to prevent parties from waiting forever in case of network issues [nodeId=0651ab2b-4ce3-47cd-8bd5-1455834f580d, addrs=[/172.18.0.3:47100, /127.0.0.1:47100]]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createNioSession(TcpCommunicationSpi.java:3738) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createTcpClient(TcpCommunicationSpi.java:3458) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createCommunicationClient(TcpCommunicationSpi.java:3198) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.reserveClient(TcpCommunicationSpi.java:3078) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.sendMessage0(TcpCommunicationSpi.java:2918) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.sendMessage(TcpCommunicationSpi.java:2877) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.managers.communication.GridIoManager.send(GridIoManager.java:2035) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.managers.communication.GridIoManager.sendToGridTopic(GridIoManager.java:2132) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCacheIoManager.send(GridCacheIoManager.java:1257) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.sendLocalPartitions(GridDhtPartitionsExchangeFuture.java:2020) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.clientOnlyExchange(GridDhtPartitionsExchangeFuture.java:1436) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.distributed.dht.preloader.GridDhtPartitionsExchangeFuture.init(GridDhtPartitionsExchangeFuture.java:903) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCachePartitionExchangeManager$ExchangeWorker.body0(GridCachePartitionExchangeManager.java:3214) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.processors.cache.GridCachePartitionExchangeManager$ExchangeWorker.body(GridCachePartitionExchangeManager.java:3063) ~[ignite-core-2.8.1.jar:2.8.1]
        at org.apache.ignite.internal.util.worker.GridWorker.run(GridWorker.java:120) ~[ignite-core-2.8.1.jar:2.8.1]
        at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: java.net.SocketTimeoutException: null
        at java.base/sun.nio.ch.SocketAdaptor.connect(SocketAdaptor.java:129) ~[na:na]
        at org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi.createNioSession(TcpCommunicationSpi.java:3584) ~[ignite-core-2.8.1.jar:2.8.1]
        ... 15 common frames omitted
</pre>
