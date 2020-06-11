package cn.yqd.service;

import java.util.concurrent.Future;

public interface GatewayService {
    void getAlipayGateway(String username);
    Future<String> getAlipayGatewayString(String username);
}
