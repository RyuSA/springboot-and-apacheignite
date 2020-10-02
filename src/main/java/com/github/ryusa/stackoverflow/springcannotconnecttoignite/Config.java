package com.github.ryusa.stackoverflow.springcannotconnecttoignite;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  Ignite igniteInstance() throws UnknownHostException {
    TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
    // conncect to Ignite cluster on localhost
    // port numbers 47501 and 47502 will be exposed on localhost
    ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
    TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
    tcpDiscoverySpi.setIpFinder(ipFinder);

    IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
    igniteConfiguration.setClientMode(true);
    igniteConfiguration.setIgniteInstanceName(InetAddress.getLocalHost().getHostName());
    igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);

    // for debug
    igniteConfiguration.setPeerClassLoadingEnabled(true);

    final Ignite ignite = Ignition.start(igniteConfiguration);
    ignite.cluster().active(true);
    return ignite;
  }
}
