package com.example.daegam.websocket;

import java.util.Vector;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketServerHandler extends TextWebSocketHandler implements MqttCallback {

	private MqttClient mqttclient = null;
	private Vector<WebSocketSession> clients = new Vector<WebSocketSession>();

	public SocketServerHandler() {
		super();
		// TODO Auto-generated constructor stub

		// mqtt
		try {
			if (mqttclient == null) {
				mqttclient = new MqttClient("tcp://211.110.130.80:1883", "p201407_sp_daegam1");

				MqttConnectOptions authen = new MqttConnectOptions();
				authen.setKeepAliveInterval(600);
				authen.setConnectionTimeout(1800);

				mqttclient.connect(authen); // ����

				mqttclient.setCallback(this); //

				mqttclient.subscribe("ds/class601/#", 0);
				// ds/class601/a, ds/class601/b,
			}

		} catch (Exception e) {
			
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		clients.remove(session);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		clients.add(session);
	}

	// ũ�ҿ��� �Է��Ѱ��� �ð��
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		System.out.println("recv msg:" + message.getPayload().toString());

		MqttMessage mqttmsg = new MqttMessage();

		// String to byte[]
		mqttmsg.setPayload(message.getPayload().toString().getBytes());
		mqttclient.publish("ds/class601/daegam", mqttmsg);

		/*
		 * String recvMsg = message.getPayload().toString(); for (int i = 0; i <
		 * clients.size(); i++) { WebSocketSession tmp = clients.get(i); if
		 * (tmp.isOpen()) { tmp.sendMessage(new TextMessage(recvMsg)); } }
		 */
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(arg0 + "," + arg1.toString());

		String msg = arg0 + "," + arg1.toString();
		for (int i = 0; i < clients.size(); i++) {
			WebSocketSession tmp = clients.get(i);
			if (tmp.isOpen()) {
				tmp.sendMessage(new TextMessage(msg));
			}
		}
	}
}